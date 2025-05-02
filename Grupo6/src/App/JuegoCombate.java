/**
 * METODOLOGÍA DE LA PROGRAMACIÓN: PRÁCTICA DE CODIFICACIÓN
 * MIEMBROS DEL GRUPO 6 QUE HAN PARTICIPADO EN EL DESARROLLO DE ESTE CÓDIGO FUENTE:
 *
 * @author Marcos Hernández Martín
 * @author Daniel Hernanz Corral
 * @author Jorge Naranjo Ballesteros
 */

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