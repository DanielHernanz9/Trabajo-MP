package Grupo6.src.App;

import Grupo6.src.Combate.Combate;
import Grupo6.src.Combate.Ranking;
import Grupo6.src.Desafio.ChallengeNotifier;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;
import Grupo6.src.Desafio.Desafio;
import Grupo6.src.sistemaDeGuardado.SingleStorage;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class JuegoCombateManager {

    private ArrayList<Usuario> usuarios;
    private Jugador jugador1;
    private Jugador jugador2;
    private final Operador operador;
    private final ArrayList<Combate> combates;
    private SingleStorage storage;
    private FactoryPersonaje factory;
    private ArrayList<Desafio> desafiosPendientesPorValidar;
    private ArrayList<Desafio> desafiosPendientes;
    private ChallengeNotifier notifier;

    /**
     * Constructor por defecto de JuegoCombateManager.
     * Inicializa las listas de combates y usuarios, y carga los datos de usuarios desde un archivo XML.
     */
    public JuegoCombateManager() {
        this.combates = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.desafiosPendientesPorValidar = new ArrayList();
        this.notifier = new ChallengeNotifier();

        storage=SingleStorage.getInstance();

        this.operador = new Operador(); // operador por defecto
        this.operador.registrarDatos("adminSupremo", "admin33", "12345");

        //Cargamos los usuarios del disco
        usuarios= storage.loadUsers();
        desafiosPendientesPorValidar = storage.loadChallenges();
        desafiosPendientes = storage.loadPendingChallenges();

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

        //Si se ha registrado un jugador nuevo mostramos el menu
        if (jugador1 != null){
            MostrarMenuJugador();
        }
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
            System.out.println("4. Editar un personaje");
            System.out.println("5. Volver");
            int opcion = sc.nextInt();
            sc.nextLine();  // Limpiar el buffer de entrada

            switch (opcion) {
                case 1 -> gestionarDesafios();
                case 2 -> bloquearDesbloquearJugador(sc, true);
                case 3 -> bloquearDesbloquearJugador(sc, false);
                case 4 ->System.out.println("Sin implementar");//Debe permitirse editar cualquier cosa de un personaje o añadir armas, armaduras, etc
                case 5 -> { return; }
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
            }
            File desafiosJugador = new File("Grupo6/src/sistemaDeGuardado/Persistencia/DesafiosPendientes.xml");
            if (desafiosJugador.length() != 0){
                ArrayList<Desafio> listaDesafios = storage.loadPendingChallenges();
                ArrayList<Desafio> listaDesafiosJugador = new ArrayList<>();
                for (Desafio d: listaDesafios){
                    if(d.getUsuarioDestino().equals(jugador1.getNombre())){
                        listaDesafiosJugador.add(d);
                    }
                }
                jugador1.setDesafiosPendientes(listaDesafiosJugador);
            }

            //Mientras haya desafios pendientes, los mostramos al jugador para que los acepte o rechaze
            while (!jugador1.getDesafiosPendientes().isEmpty()) {
                Desafio d= jugador1.getDesafiosPendientes().get(0);
                notifier.notifySubscriber(jugador1);
                System.out.println("¡Te ha desafiado " + d.getUsuarioOrigen() + "!");
                System.out.println("¿Que quieres hacer?");
                System.out.println("1. Aceptar el desafio y disputar un combate.");
                System.out.println("2. Rechazar el desafio y repartir el oro.");
                int opc = sc.nextInt();
                switch (opc){
                    case 1:{
                        jugador2 = (Jugador) usuarios.get(getUserIndexByName(d.getUsuarioOrigen()));
                        System.out.println("Puedes editar tu personaje antes de comenzar el combate: ");
                        System.out.println("1. Comenzar el combate contra " + jugador2.getName());
                        System.out.println("2. Editar personaje");
                        int opcCombate = sc.nextInt();
                        switch (opcCombate){
                            case 1:{
                                IniciarCombate();
                                break;
                            }
                            case 2:{
                                registrarPersonaje(jugador1);
                                //De momento dejo este metodo, pero supongo que habra que implementar
                                //una ediciónd de personaje con armas, esbirros, etc.
                                break;
                            }
                        }
                        break;
                    }
                    case 2:{
                        System.out.println("Rechazar desafio y descontar 10% de oro al jugador1");
                        break;
                    }

                }
                //Eliminamos el desafio pendiente de la lista y lo actualizamos en el XML
                jugador1.getDesafiosPendientes().removeFirst();
                desafiosPendientes.remove(d);
                storage.saveList(desafiosPendientes,"Grupo6/src/sistemaDeGuardado/Persistencia/DesafiosPendientes.xml");
                notifier.unSuscribe(jugador1);
            }

            boolean correctOpt = true;
            do{
                System.out.println("\nMenú Principal:");
                System.out.println("1. Desafiar a otro usuario");
                System.out.println("2. Consultar Ranking global");
                System.out.println("3. Cambiar Personaje");
                System.out.println("4. Elegir armas y armaduras activas para el personaje");
                System.out.println("5. Consultar cantidad global de oro ganado y perdido en combates anteriores");
                System.out.println("6. Volver");
                int opcion = sc.nextInt();
                sc.nextLine();  // Limpiar el buffer de entrada
                switch (opcion) {
                    case 1 -> {
                        iniciarDesafio();
                        correctOpt = true;
                    }
                    case 2 -> {
                        Ranking ranking = new Ranking();
                        ranking.showRanking();
                        correctOpt = true;
                    }
                    case 3 -> {
                        darDeBajaPersonaje(jugador1);
                        registrarPersonaje(jugador1);
                        correctOpt = true;
                    }
                    case 4 -> {System.out.println("Elección de armas y armaduras: (funcionalidad pendiente)");
                               correctOpt = true;
                            }
                    case 5 -> {
                                System.out.println("Consultar cantidad global de oro ganado y perdido (funcionalidad pendiente)");
                                correctOpt = true;
                    }
                    case 6 -> { return; }
                    default -> {
                        System.out.println("Opción inválida.");
                        correctOpt = false;
                    }
                }
            }while(!correctOpt);
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
            Combate combate = new Combate(jugador1, jugador2);
            combate.IniciarCombate();
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

    public void mostrarResultado(Combate combate) {
        System.out.println("Resultado del combate: " + combate.getResultado());
    }

    public void gestionarDesafios() {
        int numDesafios = desafiosPendientesPorValidar.size();
        if (numDesafios == 1){
            System.out.println("Hay " + numDesafios + " desafio pendiente por validar.");
        }
        else{
            System.out.println("Hay " + numDesafios + " desafios pendientes por validar.");

        }
        Scanner sc = new Scanner(System.in);
        Iterator<Desafio> iterator = desafiosPendientesPorValidar.iterator();

        while (iterator.hasNext()) {
            Desafio d = iterator.next();

            String nombreOrigen = d.getUsuarioOrigen();
            String nombreDestino = d.getUsuarioDestino();

            Jugador origen = null;
            Jugador destino = null;

            for (Usuario u : usuarios) {
                if (u instanceof Jugador j) {
                    if (j.getNombre().equals(nombreOrigen)) {
                        origen = j;
                    }
                    if (j.getNombre().equals(nombreDestino)) {
                        destino = j;
                    }
                }
            }

            System.out.println("Desafío de " + origen.getNombre() + " a " + destino.getNombre());
            System.out.println("¿Validar este desafío? (s/n)");
            String ans = sc.nextLine();

            if (ans.equals("s")) {
                destino.getDesafiosPendientes().add(d);
                //El desafio se valida y ahora pasa a ser un desafio pendiente
                desafiosPendientes.add(d);

               boolean found = updateUser(destino);
                if (found) {
                    storage.saveList(desafiosPendientes, "Grupo6/src/sistemaDeGuardado/Persistencia/DesafiosPendientes.xml");
                    System.out.println("El desafio de " + origen.getNombre() + " a " + destino.getNombre() + " ha sido validado.");
                }
            }
            iterator.remove();//Eliminamos el desafio de desafiosPendientesPorValidar
            storage.saveList(desafiosPendientesPorValidar, "Grupo6/src/sistemaDeGuardado/Persistencia/DesafiosPorValidar.XML");
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
            int TipoPersonaje = sc.nextInt();
            System.out.println("¿Cómo se llama tu personaje?");
            sc.nextLine();
            String characterName = sc.nextLine();

            if(TipoPersonaje==1){
                factory= new FactoryVampiros();
            }
            else if(TipoPersonaje==2){
                factory= new FactoryLicantropos();
            }else{
                factory= new FactoryCazadores();
            }

            jugador1.registrarPersonaje(factory, characterName);
            updateUser(jugador1);
            storage.saveList(usuarios, "Grupo6/src/sistemaDeGuardado/Persistencia/Usuarios.xml");
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
            storage.saveList(usuarios, "Grupo6/src/sistemaDeGuardado/Persistencia/Usuarios.xml");
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

    public ArrayList<Desafio> getDesafiosPendientesPorValidar() {
        return desafiosPendientesPorValidar;
    }
    public void iniciarDesafio(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe el nombre del usuario al que quieres desafiar: ");
        String playerName = sc.nextLine();

        System.out.println("¿Cuánto oro quieres apostar?");
        int apuesta = sc.nextInt();
        boolean isCorrect = true;
        do{
            if (jugador1.getOro() <= apuesta){
                System.out.println("No puedes apostar tanto oro (tienes " + jugador1.getOro() + " monedas de oro.)");
                System.out.println("Introduce una cantidad que puedas permitirte: ");
                apuesta = sc.nextInt();
                isCorrect = false;
            }
            else if (apuesta == 0) {
                System.out.println("Para desafiar a otro jugador, debes apostar oro. Introduce una cantidad no nula:  ");
                apuesta = sc.nextInt();
                isCorrect = false;
            }
            else if (apuesta < 0){
                System.out.println("Por favor, introduce una cantidad de oro coherente: ");
                apuesta = sc.nextInt();
                isCorrect = false;
            }
            else{
                isCorrect = true;
            }
        }while(!isCorrect);

       int userIndex = getUserIndexByName(playerName);
        if (userIndex > -1){
            Usuario destino = usuarios.get(userIndex);
            jugador1.desafiarUsuario((Jugador) usuarios.get(userIndex), apuesta);
            Desafio desafio = new Desafio(jugador1.getNombre(), destino.getNombre(), apuesta);
            desafiosPendientesPorValidar.add(desafio);
            storage.saveList(desafiosPendientesPorValidar, "Grupo6/src/sistemaDeGuardado/Persistencia/DesafiosPorValidar.xml");
            System.out.println("¡Se ha enviado un desafio a " + playerName + "!");
            notifier.subscribe(destino);
            storage.saveList(notifier.getSubscribers(), "Grupo6/src/sistemaDeGuardado/Persistencia/Subscriptores.xml");
        }
        else{
            System.out.println("El usuario " + playerName + " no se ha encontrado.");
            System.out.println("Asegúrate de que el usuario está registrado e inténtalo de nuevo.");
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    /**
     * Actualiza los datos de un usuario en la lista de usuarios (no sobreescribe el XML)
     * @param user El usuario que se quiere actualizar.
     * @return si la operacion se completa con exito.
     */
    public boolean updateUser(Usuario user){
        // Reemplazar el jugador actualizado (como ya arreglaste antes)
        int index = -1;
        int i = 0;
        boolean found = false;

        while (i < usuarios.size() && !found) {
            if (usuarios.get(i).getNombre().equals(user.getNombre())) {
                index = i;
                found = true;
            } else {
                i++;
            }
        }

        if (found) {
            usuarios.set(index, user);
        }
        return found;
    }

    /**
     * Como los desfafios guardan los nombres y no los objetos jugador,
     * he creado este metodo que saca el indice de un jugador a partir de su nombre.
     *
     * @param playerName El nombre del jugador buscado
     * @return userIndex El indice del jugador buscado
     */
    public int getUserIndexByName(String playerName){
        boolean found = false;
        Usuario u = null;
        int userIndex = -1;
        Iterator iterator = usuarios.iterator();
        while (!found && userIndex < usuarios.size() - 1) {
            if (iterator.hasNext()){
                u = (Usuario) iterator.next();
                if (u instanceof Jugador && u.getName().equals(playerName)){
                    found = true;
                }
                userIndex++;
            }
        }
        return userIndex;
    }
}
