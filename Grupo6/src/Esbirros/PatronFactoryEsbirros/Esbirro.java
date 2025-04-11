package Grupo6.src.Esbirros.PatronFactoryEsbirros;

/**
 * 
 */
public interface Esbirro {

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

}