package Grupo6.src.App;

import Grupo6.src.Desafio.*;

/**
 * Clase que representa a un operador del sistema.
 * El operador tiene la capacidad de validar desafíos y gestionar jugadores.
 */
public class Operador extends Usuario {

    private Handler ValidadorDesafio;  // Este handler debería ser utilizado para validar los desafíos.

    /**
     * Constructor por defecto para la clase Operador.
     * Inicializa la información heredada del usuario.
     */
    public Operador() {
        super();  // Llama al constructor de la clase base 'Usuario' para inicializar atributos comunes.
    }

    /**
     * Registra los datos del operador.
     *
     * @param nick Nombre de usuario para el operador.
     * @param nombre Nombre real del operador.
     * @param password Contraseña del operador.
     */
    public void registrarDatos(String nick, String nombre, String password){
        this.Nombre = nombre;  // Establece el nombre del operador.
        this.Nick = String.valueOf(this.hashCode());  // El nick es generado a partir del hashCode del objeto.
        this.Password = password;  // Establece la contraseña del operador.
    }

    /**
     * Obtiene el nombre del operador.
     *
     * @return El nombre del operador.
     */
    public String getNombre(){
        return this.Nombre;
    }

    /**
     * Obtiene el nick del operador.
     *
     * @return El nick del operador.
     */
    public String getNick(){
        return this.Nick;
    }

    /**
     * Obtiene la contraseña del operador.
     *
     * @return La contraseña del operador.
     */
    public String getPassword(){
        return this.Password;
    }

    /**
     * Establece el nombre del operador.
     *
     * @param name El nombre que se quiere asignar al operador.
     */
    public void setNombre(String name){
        this.Nombre = name;
    }

    /**
     * Establece la contraseña del operador.
     *
     * @param password La contraseña que se quiere asignar al operador.
     */
    public void setPassword(String password){
        this.Password = password;
    }

    /**
     * Establece el nick del operador.
     *
     * @param nick El nuevo nick para el operador.
     */
    public void setNick(String nick){
        this.Nick = nick;
    }

    /**
     * Valida un desafío utilizando el validador configurado.
     * Este método debería ser implementado para validar los desafíos de acuerdo con las reglas del sistema.
     *
     * @param desafio El desafío que se quiere validar.
     * @return true si el desafío es válido, false si no lo es.
     */
    public Boolean validarDesafio(Desafio desafio) {
        // Aquí debería añadirse la lógica para validar el desafío.
        // Ejemplo: se podría verificar si los jugadores están disponibles o si el desafío cumple con ciertos criterios.
        return desafio != null;  // Esta es una implementación temporal. Deberás agregar las condiciones de validación.
        // Si el desafío es null, no es válido.
    }

    /**
     * Permite editar el personaje de un jugador.
     *
     * @param jugador El jugador cuyo personaje se va a editar.
     */
    public void editarPersonaje(Jugador jugador) {
        if (jugador != null) {
            // Aquí se implementaría la lógica para editar los detalles del personaje del jugador.
            // Ejemplo: cambiar el nombre, atributos, habilidades, etc.
            System.out.println("Personaje de " + jugador.getNombre() + " editado correctamente.");
        } else {
            System.out.println("No se ha encontrado al jugador para editar.");
        }
    }

    /**
     * Bloquea a un jugador, lo que puede impedirle acceder a ciertas funcionalidades.
     *
     * @param jugador El jugador que será bloqueado.
     */
    public void bloquearJugador(Jugador jugador) {
        jugador.bloquear();

    }

    /**
     * Desbloquea a un jugador previamente bloqueado, permitiéndole acceder de nuevo a ciertas funcionalidades.
     *
     * @param jugador El jugador que será desbloqueado.
     */
    public void desbloquearJugador(Jugador jugador) {
        jugador.desbloquear();
    }
}
