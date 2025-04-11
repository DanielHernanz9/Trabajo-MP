package Grupo6.src.Desafio;

import Grupo6.src.App.*;

public class Desafio {

    private Integer OroApostado;
    private Jugador UsuarioOrigen;
    private Jugador UsuarioDestino;

    public Desafio(){

    }

    public Desafio(Jugador jugador1, Jugador jugador2, int oro) {
        this.OroApostado = oro;
        this.UsuarioOrigen = jugador1;
        this.UsuarioDestino = jugador2;
    }

    /**
     * @param
     */
    public void descontarOro(int oro) {
        // TODO implement here
    }

    /**
     * @param
     */
    public void IniciarDesafio(int oro) {
        // TODO implement here
    }

    public String getDesafiante() {
        // TODO implement here
        return null;
    }

    public String getDesafiado() {
        // TODO implement here
        return null;
    }

    public boolean isEmpty() {
        // TODO implement here
        return false;
    }

    public String getName(Jugador jugador1) {
        return null;
    }

    public Jugador getJugador1() {
        return null;
    }

    public Jugador getJugador2() {
        return null;
    }

    public Integer getOroApostado() {
        return OroApostado;
    }

    public Jugador getUsuarioOrigen() {
        return UsuarioOrigen;
    }

    public Jugador getUsuarioDestino() {
        return UsuarioDestino;
    }

    public void setOroApostado(Integer oroApostado) {
        OroApostado = oroApostado;
    }

    public void setUsuarioOrigen(Jugador usuarioOrigen) {
        UsuarioOrigen = usuarioOrigen;
    }

    public void setUsuarioDestino(Jugador usuarioDestino) {
        UsuarioDestino = usuarioDestino;
    }
}
