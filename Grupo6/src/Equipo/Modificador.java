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

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setTipo(TipoModificador tipo) {
        Tipo = tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getValor() {
        return valor;
    }

    public TipoModificador getTipo() {
        return Tipo;
    }

    public static enum TipoModificador {
        Debilidad,
        Fortaleza;
    }
}