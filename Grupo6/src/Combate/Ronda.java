package Grupo6.src.Combate;

import Grupo6.src.Esbirros.Esbirro;
import Grupo6.src.Esbirros.EsbirroBase;
import Grupo6.src.Esbirros.EsbirrosComposite;
import Grupo6.src.Personajes.Cazador;
import Grupo6.src.Personajes.Licantropo;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;
import Grupo6.src.Personajes.Vampiro;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ronda {

    private Personaje Atacante;
    private Personaje Atacado;
    private int PotencialAtaqueP1;
    private int PotencialAtaqueP2;
    private int PotencialDefensaP1;
    private int PotencialDefensaP2;
    private EstrategiaPotencial EstrategiaAtacante;
    private EstrategiaPotencial EstrategiaAtacado;

    public Ronda(Personaje atacante, Personaje atacado) {
        this.Atacante = atacante;
        this.Atacado = atacado;
        EstrategiaPotencial Estrategia1 = null;
        EstrategiaPotencial Estrategia2 = null;

        if (atacante instanceof Licantropo){
            Estrategia1 = new EstrategiaLicantropo();
        }
        else if (atacante instanceof Cazador){
            Estrategia1 = new EstrategiaCazador();
        }
        else if (atacante instanceof Vampiro){
            Estrategia1 = new EstrategiaVampiro();
        }

        if (atacado instanceof Licantropo){
            Estrategia2 = new EstrategiaLicantropo();
        }
        else if (atacado instanceof Cazador){
            Estrategia2 = new EstrategiaCazador();
        }
        else if (atacado instanceof Vampiro){
            Estrategia2 = new EstrategiaVampiro();
        }

        setEstrategia(Estrategia1, Estrategia2);
    }

    private int calcularPotencialDeAtaque(Personaje personaje, int personajeIndex) {
        switch (personajeIndex){
            case 1: return EstrategiaAtacante.calcularPotencialAtaque(personaje);
            case 2: return EstrategiaAtacado.calcularPotencialAtaque(personaje);
            default: return -1;
        }

    }

    private int calcularPotencialDeDefensa(Personaje personaje, int personajeIndex) {
        switch (personajeIndex){
            case 1: return EstrategiaAtacante.calcularPotencialDefensa(personaje);
            case 2: return EstrategiaAtacado.calcularPotencialDefensa(personaje);
            default: return -1;
        }

    }

    public boolean verificarFinCombate() {
        return Atacante.getSalud() == 0 || Atacante.getSalud() == 0;
    }

    private void setEstrategia(EstrategiaPotencial strategyAtacante, EstrategiaPotencial strategyAtacado ) {
        EstrategiaAtacante = strategyAtacante;
        EstrategiaAtacado = strategyAtacado;
    }

    public void reducirSalud() {
        Atacado.setSalud(Atacado.getSalud() - 1);
    }


    public void ejecutarRonda(){
        PotencialAtaqueP1 = calcularPotencialDeAtaque(Atacante, 1);
        PotencialDefensaP1 = calcularPotencialDeDefensa(Atacado, 2);

        Random random = new Random();
        int totalAtaque = 0;
        int totalDefensa = 0;
        int randomNumber = 0;

        for (int i = 0; i < PotencialAtaqueP1; i++){
            randomNumber = random.nextInt(6) + 1;
            if (randomNumber == 5 || randomNumber == 6){
                totalAtaque += 1;
            }
        }

        for (int i = 0; i < PotencialAtaqueP1; i++){
            randomNumber = random.nextInt(6) + 1;
            if (randomNumber == 5 || randomNumber == 6){
                totalAtaque += 1;
            }
        }

        for (int i = 0; i < PotencialDefensaP2; i++){
            randomNumber = random.nextInt(6) + 1;
            if (randomNumber == 5 || randomNumber == 6){
                totalDefensa += 1;
            }
        }

        if (totalAtaque >= totalDefensa){
            reducirSalud();
        }

    }

}