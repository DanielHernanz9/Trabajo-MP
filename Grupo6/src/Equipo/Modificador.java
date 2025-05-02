package Grupo6.src.Equipo;

import java.util.Objects;

public class Modificador implements Cloneable {

    private String nombre;
    private int valor;
    private TipoModificador Tipo; //ataque o defensa

    public Modificador() {
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setTipo(TipoModificador tipo) {
        Tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    public TipoModificador getTipo() {
        return Tipo;
    }

    @Override
    public Modificador clone() {
        try {
            return (Modificador) super.clone(); // String y enumerados tienen implementados los metodos de clone, no necesitamos copiarlos nosotros
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Error al clonar Modificador", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Modificador that = (Modificador) o;
        return valor == that.valor && Objects.equals(nombre, that.nombre) && Tipo == that.Tipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, valor, Tipo);
    }

    public enum TipoModificador {
        Ataque,
        Defensa
    }
}