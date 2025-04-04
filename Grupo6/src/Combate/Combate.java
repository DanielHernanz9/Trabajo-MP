package Grupo6.src.Combate;

import Grupo6.src.App.*;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;
import java.util.Date;
import java.util.ArrayList;

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

    public void IniciarCombate() {
        if (Desafiante != null && Desafiado != null) {
            System.out.println("Iniciando combate entre " + Desafiante + " y " + Desafiado);
            Combate combate = new Combate(Desafiante, Desafiado);
            manager.registrarCombate(combate);

            while (Ganador == null){
                Rondas.add(new Ronda());
            }
        } else {
            System.out.println("No se han registrado suficientes jugadores.");
        }
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

    public String getName(Jugador jugador1) {
        return null;
    }
}