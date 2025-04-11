package Grupo6.src.Esbirros;

import Grupo6.src.Esbirros.PatronFactoryEsbirros.EsbirroBase;

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
        Nombre = nombre;
    }






    public enum Lealtad {
        BAJA,
        MEDIA,
        ALTA;
        public Lealtad subir() {
            int next = this.ordinal() + 1;
            if (next >= 3) return this;
            return values()[next];
        }

        public Lealtad bajar() {
            int prev = this.ordinal() - 1;
            if (prev < 0) return this;
            return values()[prev];
        }

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

