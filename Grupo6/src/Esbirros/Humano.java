package Grupo6.src.Esbirros;

/**
 * 
 */
public class Humano extends EsbirroBase {

    /**
     * Default constructor
     */
    public Humano() {
    }

    /**
     * enum lealtad implementado aquí dentro por eficiencia
     */
    private enum Lealtad {
        BAJA,
        MEDIA,
        ALTA;
        //uso ordinal para ver su posición en el enum. Baja=0, Alta=2
        public Lealtad subir() {
            int next = this.ordinal() + 1;
            if (next >= 3) return this;
            else {
                return Lealtad.values()[next];
            }
        }

        public Lealtad bajar() {
            int prev = this.ordinal() - 1;
            if (prev < 0) return this;
            else {
                return Lealtad.values()[prev];
            }
        }


        public String lealtadString() {
            return switch (this) {
                case ALTA -> "Alta";
                case MEDIA -> "Media";
                case BAJA -> "Baja";
            };
        }
    }

    private Lealtad lealtad = Lealtad.ALTA;

    /**
     * 
     */



}