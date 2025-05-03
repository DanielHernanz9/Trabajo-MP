package Esbirros;

import Esbirros.PatronFactoryEsbirros.EsbirroBase;

public class Humano extends EsbirroBase {
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

