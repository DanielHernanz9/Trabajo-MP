package Grupo6.src.Esbirros;

public class Humano extends EsbirroBase {
    private Lealtad lealtad = Lealtad.ALTA;
    private String nombre;

    public Humano(String nombre) {
        super(nombre);
        this.lealtad = Lealtad.MEDIA;
    }

    // Hacer la enumeración pública y estática
    public static enum Lealtad {
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
