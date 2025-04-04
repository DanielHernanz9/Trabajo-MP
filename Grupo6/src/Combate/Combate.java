package Grupo6.src.Combate;

import Grupo6.src.App.Jugador;
import Grupo6.src.Personajes.PatronFactoryPersonajes.PersonajeBase;

import java.util.Date;
import java.util.ArrayList;

/**
 * No he usado la estructura completa porque solo va a haber un tipo de combate, sino si que podriamos usar una interfaz como esta en el aula con el director, de todas formas hay que preguntar al profe si asi se puede usar
 * 
 * Grupo6.src.Combate.Combate tiene muchos atributos y he intentado con el patron builder evitar hacer un constructor muy grande
 */
public class Combate {

    /**
     * Default constructor
     */
    public Combate(Jugador jugador1, Jugador jugador2) {
    }

    /**
     * 
     */
    private Jugador Desafiante;

    /**
     * 
     */
    private Jugador Desafiado;

    /**
     * 
     */
    private int NumRondas;

    /**
     * 
     */
    private Date FechaCombate;

    /**
     * 
     */
    private Jugador Ganador;

    /**
     * 
     */
    private Jugador JugadorSinEsbirrosDerrotados;

    /**
     * 
     */
    private int OroGanado;

    /**
     * 
     */
    private ArrayList<Ronda> Rondas;

    /**
     * 
     */
    private PersonajeBase PersonajeDesafiante;

    /**
     * 
     */
    private PersonajeBase PersonajeDesafiado;

    /**
     * 
     */
    public void niciarCombate() {
        // TODO implement here
    }

    /**
     * 
     */
    public void combate() {
        // TODO implement here
    }

    public String getJugador1() {
        // TODO implement here
        return null;
    }

    public String getJugador2() {
        // TODO implement here
        return null;
    }

    public String getResultado() {
        // TODO implement here
        return null;
    }
}