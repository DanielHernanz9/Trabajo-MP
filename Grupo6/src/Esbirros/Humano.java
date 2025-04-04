package Grupo6.src.Esbirros;

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

public class Humano extends EsbirroBase {
    private Lealtad lealtad = Lealtad.ALTA;
    private String Nombre;

    public Humano(String Nombre) {
        super(Nombre);
        this.lealtad = Lealtad.MEDIA;
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
