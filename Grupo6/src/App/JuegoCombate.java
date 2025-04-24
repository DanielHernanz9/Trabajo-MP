package Grupo6.src.App;

/**
 * Clase principal encargada de ejecutar el juego de combate.
 */
public class JuegoCombate {

    /**
     * Constructor por defecto para la clase JuegoCombate.
     */
    public JuegoCombate() {
    }

    /**
     * Punto de entrada principal que inicia el juego.
     */
    public static void main(String[] args) {
        JuegoCombateManager juegoCombateManager = new JuegoCombateManager();
        juegoCombateManager.IniciarJuego();  // Inicia el juego de combate.
    }
}