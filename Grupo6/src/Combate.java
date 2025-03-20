
import java.io.*;
import java.util.*;

/**
 * No he usado la estructura completa porque solo va a haber un tipo de combate, sino si que podriamos usar una interfaz como esta en el aula con el director, de todas formas hay que preguntar al profe si asi se puede usar
 * 
 * Combate tiene muchos atributos y he intentado con el patron builder evitar hacer un constructor muy grande
 */
public class Combate {

    /**
     * Default constructor
     */
    public Combate() {
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
    private Int NumRondas;

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
    private Int OroGanado;

    /**
     * 
     */
    private ListaRondas Rondas;

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

}