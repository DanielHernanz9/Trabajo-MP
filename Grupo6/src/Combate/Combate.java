package Grupo6.src.Combate;

import Grupo6.src.App.*;
import Grupo6.src.Esbirros.PatronFactoryEsbirros.Esbirro;
import Grupo6.src.Esbirros.EsbirrosComposite;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * No he usado la estructura completa porque solo va a haber un tipo de combate, sino si que podriamos usar una interfaz como esta en el aula con el director, de todas formas hay que preguntar al profe si asi se puede usar
 * 
 * Grupo6.src.Combate.Combate tiene muchos atributos y he intentado con el patron builder evitar hacer un constructor muy grande
 */
public class Combate {
    private Jugador Desafiante;
    private Jugador Desafiado;
    private JuegoCombateManager manager;
    private int NumRondas;
    private Date FechaCombate;
    private Jugador Ganador;
    private int OroGanado;
    private ArrayList<Ronda> Rondas;
    private PersonajeBase PersonajeDesafiante;
    private PersonajeBase PersonajeDesafiado;

    public Combate(Jugador desafiante, Jugador desafiado) {
        this.Desafiante = desafiante;
        this.Desafiado = desafiado;
        this.Rondas = new ArrayList<>();
        this.NumRondas = 0;
        this.Ganador = null;
    }

    public void configEsbirroSalud(List<Esbirro> listaEsbirros){
        for (Esbirro esbirro: listaEsbirros){
            esbirro.setSalud(3);
            if (esbirro instanceof EsbirrosComposite){
                List<Esbirro> listaSubordinados = ((EsbirrosComposite) esbirro).getChildren();
                for (Esbirro subordinado: listaSubordinados){
                    configEsbirroSalud(listaSubordinados);
                    //Si los esbirros tienen subordinados, se llama de manera recusriva al metodo
                    //para inicializar la salud de los subordinados y los subordinados de los subordinados, etc.
                }
            }
        }
    }

    public void IniciarCombate() {
        if (Desafiante != null && Desafiado != null) {
            //manager.registrarCombate(this);
            System.out.println("Iniciando combate entre " + Desafiante.getNombre() + " y " + Desafiado.getNombre());

            Personaje personajeDesafiado = Desafiado.getPersonaje();
            Personaje personajeDesafiante = Desafiante.getPersonaje();

            if (personajeDesafiado.hasEsbirros()){
                configEsbirroSalud(personajeDesafiado.getEsbirros());
            }

            if (personajeDesafiante.hasEsbirros()){
                configEsbirroSalud(personajeDesafiante.getEsbirros());
            }

            Ronda newRonda = null;
            int numeroRonda = 1;
            boolean swapper = false; //Esta variable va alternando en cada ronda.
            //Segun sea true o false, el peronaje atacante sera uno u otro
            //Consideramos que el primero en atacar es el personaje del jugador desafiante.

            while (newRonda == null || !newRonda.verificarFinCombate()){

                if (swapper){
                    newRonda = new Ronda(personajeDesafiado, personajeDesafiante,numeroRonda);
                }
                else{
                    newRonda = new Ronda(personajeDesafiante, personajeDesafiado, numeroRonda);
                }

                Rondas.add(newRonda);
                newRonda.ejecutarRonda();
                swapper = !swapper;
                numeroRonda += 1;
            }
            if (personajeDesafiado.getSalud() == 0){
                Ganador = Desafiado;
            }
            else if (personajeDesafiante.getSalud() == 0){
                Ganador = Desafiado;
            }
        } else {
            System.out.println("No se han registrado suficientes jugadores.");
        }
    }

    public Jugador getDesafiante() {
        return this.Desafiante;
    }

    public Jugador getDesafiado() {
        return this.Desafiado;
    }

    public String getResultado() {
        // TODO implement here
        return null;
    }

    public String getName(Jugador jugador1) {
        return null;
    }
}