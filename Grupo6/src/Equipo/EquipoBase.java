package Grupo6.src.Equipo;

public abstract class EquipoBase implements Equipo {

    protected String Nombre;
    protected Modificador modificador;
    protected int Precio;

    public Modificador getModificador() {
        return modificador;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setModificador(Modificador modificador) {
        this.modificador = modificador;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }
}