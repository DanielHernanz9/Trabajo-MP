package Grupo6.src.Esbirros;

import Grupo6.src.Esbirros.PatronFactoryEsbirros.EsbirroBase;

import java.util.Objects;

public class Humano extends EsbirroBase implements Cloneable {
    private Lealtad lealtad = Lealtad.ALTA;
    private String Nombre;

    public Humano() {
        super();
    }

    @Override
    public String getNombre() {
        return Nombre;
    }

    public void setLealtad(Lealtad lealtad) {
        this.lealtad = lealtad;
    }

    @Override
    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    @Override
    public Humano clone() {

        // Primero, clonamos el objeto base (EsbirroBase) con super.clone(), que es una clonación superficial.
        Humano cloned = (Humano) super.clone();
        // Los atributos tipo enum (Lealtad) no necesitan clonación profunda ya que los enumerados ya tienen implementada la clonacion por defecto
        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Humano humano = (Humano) o;
        return lealtad == humano.lealtad && Objects.equals(Nombre, humano.Nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lealtad, Nombre);
    }

    public enum Lealtad {
        BAJA,
        MEDIA,
        ALTA;

        public String lealtadString() {
            return switch (this) {
                case ALTA -> "Alta";
                case MEDIA -> "Media";
                case BAJA -> "Baja";
            };
        }
    }

    public Lealtad getLealtad() {
        return this.lealtad;
    }
}

