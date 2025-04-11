package Grupo6.src.Equipo;

/**
 * 
 */
public class Modificador {

    private String nombre;
    private int valor;
    private TipoModificador Tipo; //ataque o defensa


    public Modificador() {
    }

    public static enum TipoModificador {
        Debilidad,
        Fortaleza;

    }
}