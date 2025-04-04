package Grupo6.src.App;

/**
 * Clase principal para ejecutar el juego de combate.
 */
public class JuegoCombate {

    /**
     * Constructor por defecto.
     */
    public JuegoCombate() {
    }

    /**
     * Método principal que inicia el juego.
     */
    public static void main(String[] args) {
        JuegoCombateManager juegoCombateManager = new JuegoCombateManager();
        juegoCombateManager.IniciarJuego();
    }

}