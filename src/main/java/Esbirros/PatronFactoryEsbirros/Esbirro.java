package Esbirros.PatronFactoryEsbirros;

public interface Esbirro extends Cloneable {

    // Método para recibir daño y devolver la salud restante
    int recibirDaño();

    // Obtener la salud
    int getSalud();

    // Establecer la salud
    void setSalud(int salud);

    // Establecer el nombre
    void setNombre(String nombre);

    // Obtener el nombre
    String getNombre();

    EsbirroBase clone();
}