package Grupo6.src.App;

import Grupo6.src.Combate.Combate;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;
import Grupo6.src.Desafio.Desafio;
import Grupo6.src.sistemaDeGuardado.SingleStorage;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JuegoCombateManager {

    private ArrayList<Usuario> usuarios;
    private Jugador jugador1;
    private Jugador jugador2;
    private final Operador operador;
    private final ArrayList<Combate> combates;
    private int registro;
    private SingleStorage storage;
    private FactoryPersonaje factory;
    private ArrayList<Desafio> desafiosPendientes;

    /**
     * Constructor por defecto de JuegoCombateManager.
     * Inicializa las listas de combates y usuarios, y carga los datos de usuarios desde un archivo XML.
     */
    public JuegoCombateManager() {
        this.combates = new ArrayList<>();
        this.usuarios = new ArrayList<>();

        storage=SingleStorage.getInstance();

        this.operador = new Operador(); // operador por defecto
        this.operador.registrarDatos("adminSupremo", "admin33", "12345");

        //Cargamos los usuarios del disco
        usuarios= storage.loadUsers();

        //metemos el operador por defecto solo si no lo hemos metido antes
        boolean encontrado=false;
        Usuario user = null;
        int i=0;
        if (i < usuarios.size()){
            user=usuarios.get(i);
        }

        while (i < usuarios.size() && (!encontrado)) {

            if (user.getName().equals(operador.getNombre())) {
                    encontrado = true;
            }
            i++;

        }


        //Si no esta en la lista de usuarios lo metemos
        if (!encontrado){
            usuarios.add(operador); // registrar operador por defecto
        }

    }

    /**
     * Inicia el juego y gestiona los menús de interacción con el usuario.
     */
    public void IniciarJuego() {
        System.out.println("¡Bienvenido!");
        IniciarProcesoRegistro();
        Scanner sc = new Scanner(System.in);

        MostrarMenuJugador();
    }

    /**
     * Muestra el menú de opciones para el operador.
     */
    public void MostrarMenuOperador() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenú Operador:");
            System.out.println("1. Validar Desafíos");
            System.out.println("2. Bloquear Jugador");
            System.out.println("3. Desbloquear Jugador");
            System.out.println("4. Volver");
            int opcion = sc.nextInt();
            sc.nextLine();  // Limpiar el buffer de entrada

            switch (opcion) {
                case 1 -> gestionarDesafios();
                case 2 -> bloquearDesbloquearJugador(sc, true);
                case 3 -> bloquearDesbloquearJugador(sc, false);
                case 4 -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    /**
     * Bloquea o desbloquea a un jugador según la opción seleccionada.
     */
    private void bloquearDesbloquearJugador(Scanner sc, boolean bloquear) {
        System.out.print("Nombre del jugador: ");
        String nombre = sc.nextLine();
        Jugador j = buscarJugador(nombre);
        if (j != null) {
            if (bloquear) {
                bloquearJugadores(j);
            } else {
                desbloquearJugadores(j);
            }
        }
    }

    /**
     * Muestra el menú de opciones para el jugador.
     */
    public void MostrarMenuJugador() {
        Scanner sc = new Scanner(System.in);
        while (true) {

            // Si el jugador no tiene personaje, se le obliga a registrar uno
            assert jugador1 != null;
            if (jugador1.getPersonaje() == null) {
                System.out.println("No has seleccionado ningún personaje");
                registrarPersonaje(jugador1);
                overWriteUserInList(jugador1);
                System.out.println("Perosnaje " + jugador1.getPersonaje().getNombre() + " registrado.");
            }

            System.out.println("\nMenú Principal:");
            System.out.println("1. Desafiar y Combatir");
            System.out.println("2. Ver Ranking");
            System.out.println("3. Cambiar Personaje");
            System.out.println("4. Volver");
            int opcion = sc.nextInt();
            sc.nextLine();  // Limpiar el buffer de entrada

            switch (opcion) {
                case 1 -> {
                    if(usuarios.size() > 1){
                        System.out.println("¿A qué jugador quieres desafiar? Escribe su nombre de usuario: ");
                        String playerName = sc.nextLine();
                        boolean hasPlayer = false;
                        for (Usuario u: usuarios){
                            if ((u instanceof Jugador) && (u.getName().equals(playerName))){
                                hasPlayer = true;
                                jugador2 = (Jugador) u;
                            }
                        }
                        if (hasPlayer){
                            System.out.println("Se ha encontrado al jugador " + playerName + ". ¿Cuanto oro quieres apostar?");
                            int apuesta = sc.nextInt();
                            jugador1.desafiarUsuario(jugador2, apuesta);

                            //Se sobreescribe para que el desafio quede guardado cuando el oponente inicie sesion.
                            overWriteUserInList(jugador2);
                            storage.saveList(desafiosPendientes, "Grupo6/src/sistemaDeGuardado/Desafios.xml");
                        }
                        else{
                            System.out.println("No se ha encontrado al jugador " + playerName + ". Verifica que el jugador esta registrado e inténtalo de nuevo");
                        }
                    }
                    else{
                        System.out.println("No hay sufcientes jugadores registrados.");
                    }

                }
                case 2 -> System.out.println("Ranking: (funcionalidad pendiente)");
                case 3 -> {
                    darDeBajaPersonaje(jugador1);
                    registrarPersonaje(jugador1);
                    break;
                }
                case 4 -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    /**
     * Inicia el proceso de registro de un jugador nuevo.
     */
    public void IniciarProcesoRegistro() {
        boolean registered = false;
        Scanner sc = new Scanner(System.in);

        while (!registered) {
            System.out.println("¿Tienes cuenta? (s/n):");
            String tieneCuenta = sc.nextLine();

            System.out.println("Por favor introduzca sus credenciales: ");
            System.out.print("Usuario: ");
            String nombre = sc.nextLine();
            System.out.print("Contraseña: ");
            String pass = sc.nextLine();

            if (tieneCuenta.equalsIgnoreCase("s")) {
                for (Usuario u : usuarios) {
                    if (u.getNombre().equals(nombre) && u.getPassword().equals(pass)) {
                        if (u instanceof Operador) {
                            System.out.println("Bienvenido Operador: " + u.getName());
                            MostrarMenuOperador();

                        } else if (u instanceof Jugador j) {
                            System.out.println("Bienvenido Jugador: " + u.getName());
                            if (jugador1 == null) setJugador1(j);
                            else setJugador2(j);
                            MostrarMenuJugador();
                        }
                        return;
                    }
                }
                System.out.println("Usuario no encontrado o contraseña incorrecta.");
            } else {
                Jugador nuevo = new Jugador();

                registered=true;

                nuevo.registrarDatos("Jugador", nombre ,pass);
                if (jugador1 == null) setJugador1(nuevo);
                else setJugador2(nuevo);

                registrarUsuario(nuevo);
                //registrarPersonaje(nuevo); DENTRO DE REGISTRAR USUARIO YA REGISTRAMOS SU PERSONAJE TAMBIEN

            }
        }
    }

    public void IniciarCombate() {
        if (jugador1 != null && jugador2 != null) {
            System.out.println("Iniciando combate entre " + jugador1.getNombre() + " y " + jugador2.getNombre());
            Combate combate = new Combate(jugador1, jugador2);
            registrarCombate(combate);
            mostrarResultado(combate);
        } else {
            System.out.println("No se han registrado suficientes jugadores.");
        }
    }

    public void darDeBajaUsuario(Usuario user) {
        if (usuarios.contains(user)) {
            usuarios.remove(user);
            System.out.println("Usuario dado de baja: " + user.getNombre());
        }
    }

    public void registrarCombate(Combate combate) {
        combates.add(combate);
        System.out.println("Combate registrado entre: " + combate.getName(jugador1) + " y " + combate.getName(jugador2));
        try (FileWriter fw = new FileWriter("combates.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(combate.toString() + "\n");
        } catch (IOException e) {
            System.out.println("Error al guardar combate.");
        }
    }

    public void mostrarNotificacionDesafio(Desafio desafio) {
        System.out.println("¡Nuevo desafío de: " + desafio.getName(jugador1) + " a " + desafio.getName(jugador2));
    }

    public void mostrarResultado(Combate combate) {
        System.out.println("Resultado del combate: " + combate.getResultado());
    }

    public void gestionarDesafios() {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Jugador jugador) {
                for (Desafio desafio : jugador.getDesafiosPendientes()) {
                    mostrarNotificacionDesafio(desafio);
                    validarDesafio(desafio);
                }
            }
        }
    }

    public void registrarPersonaje(Jugador jugador){

        //En caso de ser nuevo el jugador, en otro caso lo que haremos sera recoger el personaje ya creado
        if (jugador != null) {

            Scanner sc = new Scanner(System.in);

            System.out.println("Selecciona el personaje que deseas usar");
            System.out.println("1. Vampiro");
            System.out.println("2. Licántropo");
            System.out.println("3. Cazador");
            int TipoPersonaje=sc.nextInt();

            if(TipoPersonaje==1){

                factory= new FactoryVampiros();
            }
            else if(TipoPersonaje==2){

                factory= new FactoryLicantropos();
            }else{

                factory= new FactoryCazadores();
            }
            jugador1.registrarPersonaje(factory);

            System.out.println("Personaje registrado para el jugador: " + jugador.getNombre());

        }
    }

    public void darDeBajaPersonaje(Jugador jugador) {
        if (jugador != null) {
            System.out.println("Personaje "+jugador.getPersonaje().getNombre()+" dado de baja para el jugador: " + jugador.getNombre());
            jugador.darDeBajaPersonaje();
        }
    }

    public void validarDesafio(Desafio desafio) {
        if (operador.validarDesafio(desafio)) {
            System.out.println("Desafío validado por el operador.");
        } else {
            System.out.println("Desafío no válido.");
        }
    }

    public void bloquearJugadores(Jugador jugador) {
        operador.bloquearUsuario(jugador);
        System.out.println("Jugador bloqueado: " + jugador.getNombre());
    }

    public void desbloquearJugadores(Jugador jugador) {
        operador.desbloquearUsuario(jugador);
        System.out.println("Jugador desbloqueado: " + jugador.getNombre());
    }

    /**
     * Busca un jugador por su nombre.
     */
    public Jugador buscarJugador(String nombre) {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Jugador j && j.getNombre().equals(nombre)) {
                return j;
            }
        }
        System.out.println("Jugador no encontrado.");
        return null;
    }

    /**
     * Registra un nuevo jugador en el sistema.
     */
    public void registrarUsuario(Jugador nuevo) {
        if (nuevo != null) {
            // Añadir el nuevo jugador a la lista de usuarios
            usuarios.add(nuevo);
            System.out.println("Nuevo jugador registrado: " + nuevo.getNombre());

            //Actualizamos los usuarios guardados en el archivo XML
            storage.saveList(usuarios, "Grupo6/src/sistemaDeGuardado/Usuarios.xml");
        }
    }

    /**
     * Guarda la lista de usuarios en un archivo XML.
     */
    /**
     * Establece el jugador1.
     */
    public void setJugador1(Jugador jugador) {
        this.jugador1 = jugador;
    }

    public void setJugador2(Jugador jugador){
        this.jugador2 = jugador;
    }

    private void overWriteUserInList(Usuario u){
        int index = usuarios.indexOf(u);
        usuarios.remove(index);
        usuarios.add(index, u);
        storage.saveList(usuarios, "Grupo6/src/sistemaDeGuardado/Usuarios.xml");
    }

    public ArrayList<Desafio> getDesafiosPendientes() {
        return desafiosPendientes;
    }
}