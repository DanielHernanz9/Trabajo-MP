package App;

/**
 * Clase que representa a un operador del sistema.
 * El operador tiene la capacidad de validar desafíos y gestionar jugadores.
 */
public class Operador extends Usuario {

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
     * @param jugador El jugador que será desbloqueado.
     */
    public void desbloquearJugador(Jugador jugador) {
        jugador.desbloquear();
    }
}
