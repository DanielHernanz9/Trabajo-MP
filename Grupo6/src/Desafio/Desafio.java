package Grupo6.src.Desafio;

import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Desafio desafio = (Desafio) o;
        return Objects.equals(OroApostado, desafio.OroApostado) && Objects.equals(UsuarioOrigen, desafio.UsuarioOrigen) && Objects.equals(UsuarioDestino, desafio.UsuarioDestino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(OroApostado, UsuarioOrigen, UsuarioDestino);
    }
}