package Grupo6.src.Desafio;

import Grupo6.src.App.*;

import java.io.Serializable;

public class Desafio implements Serializable {

    private Integer OroApostado;
    private String UsuarioOrigen;
    private String UsuarioDestino;

    public Desafio(){

    }

    public Desafio(String jugador1, String jugador2, int oro) {
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

    public boolean isEmpty() {
        // TODO implement here
        return false;
    }

    public Integer getOroApostado() {
        return OroApostado;
    }

    public String getUsuarioOrigen() {
        return UsuarioOrigen;
    }

    public String getUsuarioDestino() {
        return UsuarioDestino;
    }

    public void setOroApostado(Integer oroApostado) {
        OroApostado = oroApostado;
    }

    public void setUsuarioOrigen(String usuarioOrigen) {
        UsuarioOrigen = usuarioOrigen;
    }

    public void setUsuarioDestino(String usuarioDestino) {
        UsuarioDestino = usuarioDestino;
    }
}
