package Grupo6.src.Esbirros;
/**
 *
 */
public class Ghoul extends EsbirroBase {
    private int dependencia;

    public Ghoul(String nombre, int dependencia) {
        super(nombre);
        this.dependencia = dependencia;
    }
}