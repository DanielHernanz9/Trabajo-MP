package Grupo6.src.App;

import Grupo6.src.Desafio.*;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;
import Grupo6.src.sistemaDeGuardado.SingleStorage;

import java.util.ArrayList;
import java.util.Random;

public class Jugador extends Usuario {

    private FactoryPersonaje FabricaPersonaje;
    private final ArrayList<Desafio> DesafiosPendientes;
    private final int[] HistorialOro;
    private Personaje Personaje;
    private int Oro;
    private String RegNum; // Número de registro, solo lo tienen los jugadores y es único para cada jugador

    /**
     * Constructor por defecto de Jugador.
     * Inicializa la lista de desafíos pendientes y el historial de oro.
     */
    public Jugador() {
        setRegNumber();
        this.DesafiosPendientes = new ArrayList<>();  // Inicializa la lista de desafíos pendientes
        this.HistorialOro = new int[10];  // Inicializa el historial de oro (puedes modificar el tamaño)
        this.Oro = 500;
    }

    /**
     * Registra los datos del jugador.
     * @param nick Nick del jugador.
     * @param nombre Nombre real del jugador.
     * @param password Contraseña del jugador.
     */
    public void registrarDatos(String nick, String nombre, String password) {
        this.Nombre = nombre;
        this.Nick = nick;  // Usa el nick proporcionado en lugar de generar un hash
        this.Password = password;
    }

    /**
     * Genera un número de registro único para cada jugador.
     * El formato es LNNLL (Letra-Número-Número-Letra-Letra).
     */
    private void setRegNumber() {
        Random random = new Random();

        // Construye el formato LNNLL (Letra-Número-Número-Letra-Letra)

        // Asigna el número de registro generado al campo RegNum
        this.RegNum = String.valueOf((char) ('A' + random.nextInt(26))) +
                random.nextInt(10) +
                random.nextInt(10) +
                (char) ('A' + random.nextInt(26)) +
                (char) ('A' + random.nextInt(26));
    }

    // Métodos getter y setter

    /**
     * Obtiene el nombre del jugador.
     * @return Nombre del jugador.
     */
    public String getNombre() {
        return this.Nombre;
    }

    /**
     * Obtiene el número de registro del jugador.
     * @return Número de registro del jugador.
     */
    public String getRegNum() {
        return this.RegNum;
    }

    /**
     * Establece el nombre del jugador.
     * @param name Nombre del jugador.
     */
    public void setNombre(String name) {
        this.Nombre = name;
    }

    /**
     * Establece la contraseña del jugador.
     * @param password Contraseña del jugador.
     */
    public void setPassword(String password) {
        this.Password = password;
    }

    /**
     * Obtiene el personaje asociado al jugador.
     * @return Personaje del jugador.
     */
    public Personaje getPersonaje() {
        return this.Personaje;
    }

    /**
     * Establece el personaje para el jugador.
     * @param p Personaje que se asignará al jugador.
     */
    public void setPersonaje(Personaje p) {
        this.Personaje = p;
    }

    /**
     * Establece el nick del jugador.
     * @param nick Nick del jugador.
     */
    public void setNick(String nick) {
        this.Nick = nick;
    }

    /**
     * Registra un personaje utilizando una fábrica de personajes.
     * @param factory Fábrica de personajes que se utilizará para crear el personaje.
     */
    public void registrarPersonaje(FactoryPersonaje factory) {
        Personaje = factory.createPersonaje();  // Crea un personaje usando la fábrica
    }

    /**
     * Da de baja el personaje actual del jugador.
     * El personaje se elimina (queda como null).
     */
    public void darDeBajaPersonaje() {
        Personaje = null;  // El personaje se elimina (queda como null)
    }

    /**
     * Desafía a otro jugador añadiendo un desafío a la lista de pendientes.
     * @param oponente Jugador al que se le desafía.
     */
    public void desafiarUsuario(Jugador oponente, int oro) {
        if (oponente != null) { // Verificamos que tanto el desafío como el oponente no sean nulos
            // Agrega el desafío a la lista de desafíos pendientes del jugador
            Desafio desafio = new Desafio(this, oponente, oro);
            JuegoCombateManager manager = new JuegoCombateManager();
            ArrayList<Desafio> listaDesafios = new ArrayList<>();
            listaDesafios.add(desafio);
            SingleStorage storage = SingleStorage.getInstance();
            storage.saveList(listaDesafios, "Grupo6/src/sistemaDeGuardado/Persistencia/Desafios.xml");
            // Imprime un mensaje confirmando que el jugador ha desafiado a otro jugador
            System.out.println(this.getNombre() + " ha desafiado a " + oponente.getNombre());
        } else {
            // Si el desafío o el oponente son nulos, se imprime un mensaje de error
            System.out.println("El desafío o el oponente no son válidos.");
        }
    }

    /**
     * Acepta un desafío.
     * @param desafio Desafío a aceptar.
     */
    public void aceptarDesafio(Desafio desafio) {
        if (desafio != null) {
            // Asumiendo que `desafio.getJugador1()` y `desafio.getJugador2()` retornan los jugadores involucrados en el desafío
            Jugador jugador1 = desafio.getJugador1();
            Jugador jugador2 = desafio.getJugador2();

            System.out.println(this.getNombre() + " ha aceptado el desafío de " + jugador1.getNombre() + " contra " + jugador2.getNombre());

            // Aquí puedes agregar más lógica relacionada con el combate.
        } else {
            System.out.println("Desafío no encontrado.");
        }
    }

    /**
     * Rechaza un desafío eliminándolo de la lista de pendientes.
     * @param desafio Desafío a rechazar.
     */
    public void rechazarDesafio(Desafio desafio) {
        if (desafio != null) {
            DesafiosPendientes.remove(desafio);  // Elimina el desafío de la lista
            System.out.println(this.getNombre() + " ha rechazado el desafío de " + desafio.getJugador1().getNombre());
        } else {
            System.out.println("Desafío no encontrado.");
        }
    }

    /**
     * Consulta y muestra el historial de oro del jugador.
     */
    public void consultarHistorial() {
        // Muestra el historial de oro del jugador
        for (int i = 0; i < HistorialOro.length; i++) {
            System.out.println("Mes " + (i + 1) + ": " + HistorialOro[i] + " de oro.");
        }
    }

    /**
     * Muestra una notificación de desafío pendiente.
     */
    public void mostrarNotificacionDesafio() {
        System.out.println("¡Tienes un nuevo desafío pendiente!");
        // Aquí puedes agregar más detalles si es necesario.
    }

    /**
     * Muestra el resultado del combate.
     */
    public void mostrarResultado() {
        // Este bloque podría mostrar el resultado de un combate, por ejemplo:
        System.out.println("El combate ha terminado.");
    }

    /**
     * Muestra una notificación de bloqueo de la cuenta.
     */
    public void mostrarNotificacionBloqueo() {
        System.out.println("¡Tu cuenta ha sido bloqueada!");
    }

    /**
     * Muestra una notificación de desbloqueo de la cuenta.
     */
    public void mostrarNotificacionDesbloqueo() {
        System.out.println("¡Tu cuenta ha sido desbloqueada!");
    }

    /**
     * Getter para DesafiosPendientes.
     * @return Lista de desafíos pendientes del jugador.
     */
    public ArrayList<Desafio> getDesafiosPendientes() {
        return this.DesafiosPendientes;
    }

    /**
     * Establece el número de registro del jugador.
     * @param regNum Número de registro.
     */
    public void setRegNum(String regNum) {
        RegNum = regNum;
    }

    public int getOro() {
        return Oro;
    }

    public FactoryPersonaje getFabricaPersonaje() {
        return FabricaPersonaje;
    }

    public int[] getHistorialOro() {
        return HistorialOro;
    }
}
