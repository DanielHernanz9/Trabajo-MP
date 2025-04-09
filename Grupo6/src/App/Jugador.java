package Grupo6.src.App;

import Grupo6.src.COSAS.*;
import Grupo6.src.App.*;
import Grupo6.src.Combate.*;
import Grupo6.src.Desafio.*;
import Grupo6.src.DesafioNotify.*;
import Grupo6.src.Equipo.*;
import Grupo6.src.Esbirros.*;
import Grupo6.src.Personajes.*;
import Grupo6.src.sistemaDeGuardado.*;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;

import java.util.ArrayList;

public class Jugador extends Usuario {

    /**
     * Default constructor
     */
    public Jugador() {
    }

    private Integer NumeroRegistro;
    private FactoryPersonaje FabricaPersonaje;
    private ArrayList<Desafio> DesafiosPendientes;
    private int [] HistorialOro;
    private PersonajeBase Personaje;

    /**
     * @param
     */
    public void registrarPersonaje(FactoryPersonaje factory) {
        // TODO implement here
    }

    /**
     * 
     */
    public void darDeBajaPersonaje() {
        // TODO implement here
    }

    /**
     * @param
     */
    public void desafiarUsuario(Desafio desafio) {
        // TODO implement here
    }

    /**
     * @param
     */
    public void aceptarDesafio(Desafio desafio) {
        // TODO implement here
    }

    /**
     * @param
     */
    public void rechazarDesafio(Desafio desafio) {
        // TODO implement here
    }

    /**
     * 
     */
    public void consultarHistorial() {
        // TODO implement here
    }

    /**
     * @param
     */
    public void mostrarNotificacionDesafio() {
        // TODO implement here
        // De momento he quitado el contexto que se le pasaba a estos metodos porque no sabemos exactamente qué
        //datos necesitamos pasar a este metodo.
    }

    /**
     * @param
     */
    public void mostrarResultado() {
        // TODO implement here
    }

    /**
     * 
     */
    public void mostrarNotificacionBloqueo() {
        // TODO implement here
    }

    /**
     * 
     */
    public void mostrarNotificacionDesbloqueo() {
        // TODO implement here
    }

    // Getter para DesafiosPendientes
    public ArrayList<Desafio> getDesafiosPendientes() {
        return this.DesafiosPendientes;
    }

    public PersonajeBase getPersonaje() { return this.Personaje; }
}