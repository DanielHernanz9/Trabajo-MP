package Grupo6.src.Combate;

import Grupo6.src.Esbirros.PatronFactoryEsbirros.Esbirro;
import Grupo6.src.Personajes.Cazador;
import Grupo6.src.Personajes.Licantropo;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;
import Grupo6.src.Personajes.Vampiro;

import java.io.Serializable;
import java.util.Random;

public class Ronda implements Serializable {

    private Personaje Atacante;
    private Personaje Atacado;
    private int PotencialAtaqueP1;
    private int PotencialDefensaP2;
    private EstrategiaPotencial EstrategiaAtacante;
    private EstrategiaPotencial EstrategiaAtacado;
    private int NumeroRonda;
    private String nombreAtacante;
    private String nombreAtacado;

    public Ronda(){

    }

    public Ronda(Personaje atacante, Personaje atacado, int numeroRonda) {
        this.Atacante = atacante;
        this.Atacado = atacado;
        this.nombreAtacado = Atacado.getNombre();
        this.nombreAtacante = Atacante.getNombre();
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
        this.NumeroRonda = numeroRonda;
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

    //Como solo puede cambiar la salud del atacado, sera la que comprobemos para verificar si ha terminado el combate.
    //La del atacante no va a ser nunca 0 (o no deberia entrar a una ronda sin salud)
    public boolean verificarFinCombate() {
        return Atacado.getSalud() == 0;
    }

    private void setEstrategia(EstrategiaPotencial strategyAtacante, EstrategiaPotencial strategyAtacado ) {
        EstrategiaAtacante = strategyAtacante;
        EstrategiaAtacado = strategyAtacado;
    }

    public void reducirSalud() {
        /*
        if (Atacante.hasEsbirros()){
            int l = Atacante.getEsbirros().size();
            Esbirro esbirro = Atacante.getEsbirros().get(l - 1);
            System.out.println("¡" + nombreAtacante + " ha infligido daño a un esbirro de " + nombreAtacado  + " !");
            esbirro.setSalud(esbirro.recibirDaño());

        }
        else{
         */

        //De momento no dañamos a los esbirros porque produce un bucle infinito, hay que arreglarlo.

        Atacado.reducirSalud();
        System.out.println("¡" + nombreAtacante + " ha infligido 1 punto de daño a " + nombreAtacado + "!");
        System.out.println("La salaud de " + nombreAtacado + " ahora es de " + Atacado.getSalud());
        }


    public void ejecutarRonda(){
        System.out.println();
        System.out.println("¡Comienza la ronda " + NumeroRonda + "!");

        // Si bien el enunciado pide los potenciales de cada tipo para cada personaje,
        // no tiene sentido calcular el potencial de defensa del atacante ni el potencial de
        // ataque del atacado, pues son datos que no se van a utilizar.
        PotencialAtaqueP1 = calcularPotencialDeAtaque(Atacante, 1);
        PotencialDefensaP2 = calcularPotencialDeDefensa(Atacado, 2);

        System.out.println(nombreAtacante + " ataca a " + nombreAtacado);
        System.out.println("El potencial de ataque de " + nombreAtacante + " es de " + PotencialAtaqueP1);
        System.out.println("El potencial de defensa de " + nombreAtacado + " es de " + PotencialDefensaP2);

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

        for (int i = 0; i < PotencialDefensaP2; i++){
            randomNumber = random.nextInt(6) + 1;
            if (randomNumber == 5 || randomNumber == 6){
                totalDefensa += 1;
            }
        }

        System.out.println(nombreAtacante + " ha obtenido un ataque de " + totalAtaque);
        System.out.println((nombreAtacado) + " ha obtenido una defensa de " + totalDefensa);

        if (totalAtaque >= totalDefensa){
            reducirSalud();
        }
        else{
            System.out.println("¡" + nombreAtacante + " no logra dañar a " + nombreAtacado + " en esta ronda!");
        }

        if (verificarFinCombate()){
            System.out.println("¡" + nombreAtacado + " ha caido!");
        }

    }

    public Personaje getAtacante() {
        return Atacante;
    }

    public Personaje getAtacado() {
        return Atacado;
    }

    public int getPotencialAtaqueP1() {
        return PotencialAtaqueP1;
    }

    public int getPotencialDefensaP2() {
        return PotencialDefensaP2;
    }

    public EstrategiaPotencial getEstrategiaAtacante() {
        return EstrategiaAtacante;
    }

    public EstrategiaPotencial getEstrategiaAtacado() {
        return EstrategiaAtacado;
    }

    public int getNumeroRonda() {
        return NumeroRonda;
    }

    public String getNombreAtacante() {
        return nombreAtacante;
    }

    public String getNombreAtacado() {
        return nombreAtacado;
    }

    public void setAtacante(Personaje atacante) {
        Atacante = atacante;
    }

    public void setAtacado(Personaje atacado) {
        Atacado = atacado;
    }

    public void setPotencialAtaqueP1(int potencialAtaqueP1) {
        PotencialAtaqueP1 = potencialAtaqueP1;
    }

    public void setPotencialDefensaP2(int potencialDefensaP2) {
        PotencialDefensaP2 = potencialDefensaP2;
    }

    public void setEstrategiaAtacante(EstrategiaPotencial estrategiaAtacante) {
        EstrategiaAtacante = estrategiaAtacante;
    }

    public void setEstrategiaAtacado(EstrategiaPotencial estrategiaAtacado) {
        EstrategiaAtacado = estrategiaAtacado;
    }

    public void setNumeroRonda(int numeroRonda) {
        NumeroRonda = numeroRonda;
    }

    public void setNombreAtacante(String nombreAtacante) {
        this.nombreAtacante = nombreAtacante;
    }

    public void setNombreAtacado(String nombreAtacado) {
        this.nombreAtacado = nombreAtacado;
    }
}