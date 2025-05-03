package Grupo6.src.HabilidadesEspeciales;

import java.util.Objects;

public abstract class Habilidad_Especial implements Cloneable {

    protected String Nombre;
    protected int ValorAtaque;
    protected int ValorDefensa;

    public int getAtaque(){
        return this.ValorAtaque;
    }

    public int getDefensa(){
        return this.ValorDefensa;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setValorAtaque(int valorAtaque) {
        ValorAtaque = valorAtaque;
    }

    public void setValorDefensa(int valorDefensa) {
        ValorDefensa = valorDefensa;
    }

    @Override
    public Habilidad_Especial clone() {
        try {
            return (Habilidad_Especial) super.clone(); // Clon superficial es suficiente porque los campos son primitivos o inmutables
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clonación fallida en Habilidad_Especial", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Habilidad_Especial that = (Habilidad_Especial) o;
        return ValorAtaque == that.ValorAtaque && ValorDefensa == that.ValorDefensa && Objects.equals(Nombre, that.Nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nombre, ValorAtaque, ValorDefensa);
    }
}