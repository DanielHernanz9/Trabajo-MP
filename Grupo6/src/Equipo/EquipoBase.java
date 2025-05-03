package Grupo6.src.Equipo;

import java.util.Objects;

public abstract class EquipoBase implements Equipo,Cloneable {

    protected String Nombre;
    protected Modificador modificador;
    protected int Precio;

    public Modificador getModificador() {
        return modificador;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setModificador(Modificador modificador) {
        this.modificador = modificador;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }

    @Override
    public EquipoBase clone() {
        try {
            EquipoBase clon = (EquipoBase) super.clone();

            // Clonar el modificador si no es nulo
            if (this.modificador != null) {
                clon.modificador = this.modificador.clone();
            }

            return clon;

        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Error al clonar EquipoBase", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EquipoBase that = (EquipoBase) o;
        return Precio == that.Precio && Objects.equals(Nombre, that.Nombre) && Objects.equals(modificador, that.modificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nombre, modificador, Precio);
    }
}