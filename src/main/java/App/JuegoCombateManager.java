package App;

import Combate.Combate;
import Combate.SingleRanking;
import Desafio.ChallengeNotifier;
import Equipo.*;
import HabilidadesEspeciales.Disciplina;
import HabilidadesEspeciales.Don;
import HabilidadesEspeciales.Habilidad_Especial;
import Personajes.Cazador;
import Personajes.Licantropo;
import Personajes.PatronFactoryPersonajes.*;
import Desafio.Desafio;
import Personajes.Vampiro;
import sistemaDeGuardado.SingleStorage;

import java.io.*;
import java.util.*;


public class JuegoCombateManager {

    private ArrayList<Usuario> usuarios;
    private Jugador jugador1;
    private Jugador jugador2;
    private final Operador operador;
    private final ArrayList<Combate> combates;
    private final SingleStorage storage;
    private FactoryPersonaje factory;
    private FabricaEquipo factoryEquipo;
    private ArrayList<Desafio> desafiosPendientesPorValidar;
    private final ArrayList<Desafio> desafiosPendientes;
    private final ChallengeNotifier notifier;

    /**
     * Constructor por defecto de JuegoCombateManager.
     * Inicializa las listas de combates y usuarios, y carga los datos de usuarios desde un archivo XML.
     */
    public JuegoCombateManager() {
        this.combates = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.desafiosPendientesPorValidar = new ArrayList();
        this.notifier = new ChallengeNotifier();

        storage = SingleStorage.getInstance();

        this.operador = new Operador(); // operador por defecto
        this.operador.registrarDatos("adminSupremo", "admin33", "12345");

        //Cargamos los usuarios del disco
        usuarios = storage.loadUsers();
        desafiosPendientesPorValidar = storage.loadChallenges();
        desafiosPendientes = storage.loadPendingChallenges();

        //metemos el operador por defecto solo si no lo hemos metido antes
        boolean encontrado = false;
        Usuario user = null;
        int i = 0;
        if (i < usuarios.size()) {
            user = usuarios.get(i);
        }

        while (i < usuarios.size() && (!encontrado)) {

            if (user.getName().equals(operador.getNombre())) {
                encontrado = true;
            }
            i++;

        }


        //Si no esta en la lista de usuarios lo metemos
        if (!encontrado) {
            usuarios.add(operador); // registrar operador por defecto
        }

    }

    /**
     * Inicia el juego y gestiona los menús de interacción con el usuario.
     */
    public void IniciarJuego() {
        String colorBienvenida="\u001B[38;5;114m";
        String reset = "\u001B[0m";
        String rojo = "\u001B[91m";

        System.out.println(colorBienvenida+"¡Bienvenido!"+reset);
        IniciarProcesoRegistro();

        //Si se ha registrado un jugador nuevo mostramos el menu
        while (jugador1!=null && jugador1.isBloqueado()){
            System.out.println("Este usuario está "+rojo+"bloqueado"+reset+" y no puede acceder al videojuego hasta que sea desbloqueado");
            System.out.println("Por favor prueba a iniciar sesión con otro usuario");
            IniciarProcesoRegistro();

        }

        if ((jugador1 != null) &&(!jugador1.isBloqueado())){
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
                case 2 -> MenuBloqueoDesbloqueo(true);
                case 3 -> MenuBloqueoDesbloqueo(false);
                case 4 -> MenuEdicionPersonaje();//Debe permitirse editar cualquier cosa de un personaje o añadir armas, armaduras, etc
                case 5 -> {
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }
    public void MenuEdicionPersonaje() {

        ArrayList<Jugador> jugadores = storage.getPlayers();
        ArrayList<Personaje> personajes = new ArrayList<>();
        Set<String> personajeSet = new HashSet<>();

        String reset = "\u001B[0m";
        String rojo = "\u001B[91m";
        String verde = "\u001B[32m";
        String dorado = "\u001B[93m";

        System.out.println("Escribe el nombre del personaje que desea editar");
        int i = 1;
        for (Jugador jugador : jugadores) {
            System.out.println(i + ". " + jugador.getPersonaje().getNombre());
            personajes.add(jugador.getPersonaje());
            personajeSet.add(jugador.getPersonaje().getNombre());
            i++;
        }
        //Si hay personajes (i>1) entonces continuamos
        if (i > 1) {
            Scanner sc = new Scanner(System.in);
            String nombrePersonaje = sc.nextLine();
            Personaje personajeEditable = null;
            Personaje personajeSinEditar = null;
            while (!personajeSet.contains(nombrePersonaje)) {
                System.out.println("El nombre del personaje buscado no existe, por favor escribe un nombre válido");
                nombrePersonaje = sc.nextLine();

            }
            int pos = 0;
            while ((personajeEditable == null) && (pos < personajes.size())) {
                Personaje personajeActual = personajes.get(pos);
                if (nombrePersonaje.equals(personajeActual.getNombre())) {
                    personajeEditable = personajeActual.clone();
                    personajeSinEditar = personajeActual.clone();
                }
                pos++;
            }

            System.out.println("Seleccione la característica que desea modificar del personaje: " + nombrePersonaje);
            System.out.println("1. Cambiar nombre");
            System.out.println("2. Modificar habilidad especial");
            System.out.println("3. Modificar conjunto de armas");
            System.out.println("4. Modificar conjunto de armas activas");
            System.out.println("5. Modificar conjunto de armaduras");
            System.out.println("6. Modificar armadura activa");
            System.out.println("7. Modificar cantidad de "+dorado+"oro"+reset);
            System.out.println("8. Modificar "+verde+"salud"+reset+" del personaje");
            System.out.println("9. Modificar el valor de poder");
            System.out.println("10. Modificar conjunto de debilidades");
            System.out.println("11. Modificar conjunto de fortalezas");
            System.out.println("12. Modificar característica específica del tipo de personaje");
            System.out.println("13. Salir sin modificar");

            int opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1: {
                    System.out.println("Escribe nuevo nombre que le desea poner al personaje");
                    String nuevoNombre = sc.nextLine();
                    personajeEditable.setNombre(nuevoNombre);
                    break;
                }
                case 2:
                    System.out.println("\uD83D\uDD2E Habilidad especial de: " + personajeEditable.getNombre());


                    Habilidad_Especial habilidad = personajeEditable.getHabilidad();
                    if (habilidad!=null){

                        System.out.println("● Nombre: " + habilidad.getNombre());
                        System.out.println("● Valor de ataque: " + habilidad.getAtaque());
                        System.out.println("● Valor de defensa: " + habilidad.getDefensa());
                        System.out.println();

                        System.out.println("Seleccione la característica que desea modificar de la habilidad: ");
                        System.out.println("1. Cambiar nombre");
                        System.out.println("2. Modificar valor de ataque");
                        System.out.println("3. Modificar valor de defensa");

                        //ahora mostramos las opciones de modificar de las disciplinas y dones en el respectivo caso
                        if (habilidad instanceof Disciplina) {
                            System.out.println("4. Modificar puntos de sangre");

                        } else if (habilidad instanceof Don) {
                            System.out.println("4. Modificar valor de rabia mínimo");

                        }

                        boolean valida = false;
                        while (!valida) {
                            String opcion2 = sc.nextLine();
                            switch (opcion2) {
                                case "1":
                                    valida = true;
                                    System.out.println("Escribe el nuevo nombre que le desee poner a la habilidad");
                                    String nuevoNombre = sc.nextLine();

                                    //modificamos el nombre de la habilidad
                                    personajeEditable.getHabilidad().setNombre(nuevoNombre);

                                    break;
                                case "2":
                                    valida = true;
                                    System.out.println("Escribe el nuevo valor de ataque que le desee poner a la habilidad (Entre 1 y 3)");
                                    int valorAtaque = sc.nextInt();
                                    sc.nextLine();

                                    //Si el valor de ataque esta fuera del rango [1,3] , entonces:
                                    while ((valorAtaque <= 0) || (valorAtaque >= 4)) {
                                        System.out.println("El valor introducido no es válido tiene que estar entre 1 y 3, por favor escribe un valor válido");
                                        valorAtaque = sc.nextInt();
                                        sc.nextLine();

                                    }

                                    //modificamos el valor de ataque de la habilidad
                                    personajeEditable.getHabilidad().setValorAtaque(valorAtaque);

                                    break;
                                case "3":
                                    valida = true;

                                    System.out.println("Escribe el nuevo valor de defensa que le desee poner a la habilidad (entre 1 y 3)");
                                    int valorDefensa = sc.nextInt();
                                    sc.nextLine();

                                    //Si el valor de ataque esta fuera del rango [1,3] , entonces:
                                    while ((valorDefensa <= 0) || (valorDefensa >= 4)) {
                                        System.out.println("El valor introducido no es válido tiene que estar entre 1 y 3, por favor escribe un valor válido");
                                        valorDefensa = sc.nextInt();
                                        sc.nextLine();

                                    }

                                    //modificamos el valor de ataque de la habilidad
                                    personajeEditable.getHabilidad().setValorDefensa(valorDefensa);

                                    break;
                                default:
                                    if (habilidad instanceof Disciplina) {
                                        int coste = ((Disciplina) habilidad).getCoste();

                                        System.out.println("● Puntos de sangre: " + coste);
                                        System.out.println("Escriba el nuevo valor de puntos de sangre que le desee poner a la habilidad (entre 1 y 3)");

                                        int valorPuntos = sc.nextInt();
                                        sc.nextLine();
                                        while ((valorPuntos <= 0) || (valorPuntos >= 4)) {
                                            System.out.println("El valor introducido no es válido tiene que estar entre 1 y 3, por favor escribe un valor válido");
                                            valorPuntos = sc.nextInt();
                                            sc.nextLine();
                                        }

                                        //Actualizamos la habilidad
                                        ((Disciplina) habilidad).setCoste(valorPuntos);
                                        personajeEditable.setHabilidad(habilidad);

                                    } else if (habilidad instanceof Don) {
                                        int rabia = ((Don) habilidad).getRabia();
                                        System.out.println("● Valor de rabía minimo: " + rabia);
                                        System.out.println("Escriba el nuevo valor de rabia mínimo que le desee poner a la habilidad ");
                                        int valorRabia = sc.nextInt();
                                        sc.nextLine();

                                        //OJO SE TIENE QUE COMPROBAR EN ALGUN LADO QUE Si la rabia del licántropo es inferior al valor de rabia minima de la habilidad,
                                        // no se puede usar ese don.
                                        ((Don) habilidad).setRabia(valorRabia);
                                        personajeEditable.setHabilidad(habilidad);

                                    } else {

                                        System.out.println("La opción seleccionada no es válida");
                                        System.out.println("Seleccione una opción valida: ");

                                    }

                            }
                        }

                    } else{
                        System.out.println("Este personaje no tiene asignada ninguna habilidad todavía");
                        //return; //esto lo he puesto de forma provisional, ya lo revisare para evitar el return en una funcion con void
                    }

                    break;
                case 3:
                    System.out.println("Sin implementar");
                    // Lógica para modificar armas
                    break;
                case 4:
                    System.out.println("Armas activas del personaje: ");
                    if (personajeEditable.getArmaActiva1()==null){

                        System.out.println("Arma 1: Sin seleccionar");
                    }else{

                        System.out.println("Arma 1: "+personajeEditable.getArmaActiva1());
                    }
                    if (personajeEditable.getArmaActiva1()==null){

                        System.out.println("Arma 2: Sin seleccionar");
                    }else{

                        System.out.println("Arma 2: "+personajeEditable.getArmaActiva2());
                    }


                    List<Arma> armas= personajeEditable.getArmas();
                    if (armas.isEmpty()){
                        System.out.println("No hay armas para seleccionar como activas");
                    }else{
                        System.out.println("Seleccione una de las armas que tiene en el inventario para ponerla como activa: ");
                        int k=1;
                        for(Arma arma : armas){
                            System.out.println(k+". "+arma);
                            k++;
                        }
                        int armaSeleccionada= sc.nextInt();
                        sc.nextLine();
                        Arma nuevaArma =armas.get(armaSeleccionada-1);
                        if (nuevaArma.getManos()==2){
                            personajeEditable.setArmaActiva1(nuevaArma);
                            personajeEditable.setArmaActiva2(null);
                        }
                        else{

                            System.out.println("¿Desea sustituir el Arma activa 1 o el Arma activa 2 (1/2) ? Si quiere salir sin modificar escriba cualquier otro caracter");
                            int armaActiva= sc.nextInt();
                            sc.nextLine();

                            if (armaActiva==1){

                                personajeEditable.setArmaActiva1(armas.get(armaSeleccionada));
                            }
                            else if (armaActiva==2){

                                personajeEditable.setArmaActiva2(armas.get(armaSeleccionada));
                            }

                        }
                    }
                    break;
                case 5:
                    System.out.println("Sin implementar");
                    // Lógica para modificar armaduras
                    break;
                case 6:
                    System.out.println("Armadura activa del personaje: ");
                    Armadura armaduraAct= personajeEditable.getArmaduraActiva();
                    System.out.println("Armadura Activa: "+armaduraAct);

                    System.out.println("Seleccione la armadura que desee ponerle como activa al personaje: ");
                    List<Armadura> armaduras= personajeEditable.getArmaduras();
                    int k=1;
                    for (Armadura armadura:armaduras){
                        System.out.println(k+". "+armadura);
                        k++;
                    }
                    int armaduraSeleccionada= sc.nextInt();
                    sc.nextLine();
                    personajeEditable.setArmaduraActiva(armaduras.get(armaduraSeleccionada-1));

                    // Lógica para modificar armadura activa
                    break;
                case 7:
                    System.out.println("Cantidad de "+dorado+"oro"+reset+" del personaje actualmente: "+personajeEditable.getOro());
                    System.out.println("Escriba la nueva cantidad de "+dorado+"oro"+reset+": ");
                    int valorOro = sc.nextInt();
                    sc.nextLine();
                    while(valorOro < 0) {
                        System.out.println("El valor de oro introducido "+rojo+"no es válido"+reset+", por favor escribe un valor válido (Positivo): ");
                        valorOro = sc.nextInt();
                        sc.nextLine();
                    }

                    personajeEditable.setOro(valorOro);
                    break;
                case 8:
                    System.out.println(verde+"Salud "+reset+"del personaje actualmente: "+personajeEditable.getSalud());
                    System.out.println("Escribe la nueva "+verde+"salud"+reset+" que le desee poner al personaje (0-5): ");

                    int valorSalud = sc.nextInt();
                    sc.nextLine();
                    while (!(valorSalud<5)||!(valorSalud>0)){
                        System.out.println("El valor introducido de "+verde+"salud"+reset+" no es válido, por favor escribe un valor válido (0-5): ");
                        valorSalud = sc.nextInt();
                        sc.nextLine();
                    }

                    personajeEditable.setSalud(valorSalud);
                    break;
                case 9:
                    System.out.println("Escribe el nuevo valor de poder que le desee poner al personaje (1-5): ");
                    int valorPoder = sc.nextInt();
                    sc.nextLine();
                    while (!(valorPoder<1)||!(valorPoder>5)){
                        System.out.println("El valor de poder introducido "+rojo+"no es válido"+reset+", por favor escribe un valor válido (1-5): ");
                        valorPoder = sc.nextInt();
                        sc.nextLine();
                    }
                    personajeEditable.setPoder(valorPoder);

                    break;
                case 10:
                    System.out.println("Sin implementar");
                    // Lógica para modificar debilidades
                    break;
                case 11:
                    System.out.println("Sin implementar");
                    // Lógica para modificar fortalezas
                    break;
                case 12:
                    System.out.println("Elije la característica específica a modificar: ");
                    if (personajeEditable instanceof Vampiro){
                        System.out.println("1. Modificar puntos de sangre del Vampiro");
                        System.out.println("2. Modificar pacto del Vampiro con el Esbirro");
                        int opc= sc.nextInt();
                        sc.nextLine();
                        switch (opc){
                            case 1:
                                int puntosDeSangre= ((Vampiro) personajeEditable).getSangre();
                                System.out.println("Puntos de sangre en este momento: "+puntosDeSangre);
                                System.out.println("Escribe el nuevo valor de puntos de sangre para el personaje: ");
                                int valorSangre = sc.nextInt();
                                sc.nextLine();
                                ((Vampiro) personajeEditable).setSangre(valorSangre);

                                break;
                            case 2:
                                String pactoActual= ((Vampiro) personajeEditable).getPacto();
                                System.out.println("Pacto descrito actualmente: "+pactoActual);
                                System.out.println("Describe el nuevo pacto que tiene su amo con el esbirro: ");
                                String pacto =sc.nextLine();
                                ((Vampiro) personajeEditable).setPacto(pacto);

                                break;
                        }

                    }else if (personajeEditable instanceof Licantropo){
                        System.out.println("1. Modificar puntos de rabia del Licántropo");
                        int opc=sc.nextInt();
                        sc.nextLine();
                        if (opc == 1) {
                            int rabiaActual= ((Licantropo) personajeEditable).getRabia();
                            System.out.println("Valor de rabia en este momento: "+rabiaActual);
                            System.out.println("Escribe el nuevo valor de rabia para el personaje (0-3): ");
                            int rabia = sc.nextInt();
                            sc.nextLine();
                            while ((rabia<0)||(rabia>3)){
                                System.out.println("El valor introducido de rabia "+rojo+"no es válido"+reset+", por favor escribe un valor válido (0-3): ");
                                rabia = sc.nextInt();
                                sc.nextLine();
                            }
                            ((Licantropo) personajeEditable).setRabia(rabia);
                        }else{
                            System.out.println("Opción seleccionada no válida ");
                        }


                    }else if (personajeEditable instanceof Cazador) {
                        System.out.println("1. Modificar puntos de Voluntad del Cazador");
                        int opc=sc.nextInt();
                        sc.nextLine();
                        if (opc == 1) {
                            int puntosDeVoluntad= ((Cazador) personajeEditable).getVoluntad();
                            System.out.println("Puntos de voluntad en este momento: "+puntosDeVoluntad);
                            System.out.println("Escriba el nuevo valor de Voluntad para el personaje: ");
                            int voluntad = sc.nextInt();
                            sc.nextLine();
                            while ((voluntad<0)||(voluntad>3)){
                                System.out.println("El valor introducido "+rojo+"no es válido"+reset+", por favor escribe un valor de voluntad válido (0-3): ");
                                voluntad = sc.nextInt();
                                sc.nextLine();
                            }
                            ((Cazador) personajeEditable).setVoluntad(voluntad);
                        }
                    }

                    break;
                case 13:
                    System.out.println("Saliendo del menú de edición del personaje...");
                    break;
                default:
                    System.out.println("⚠️ Opción inválida. Intenta de nuevo.");
            }

            //Ahora buscamos el jugador que tenía ese personaje
            int p = 0;
            Jugador jugador = jugadores.get(p);
            p++;
            while ((p < jugadores.size())&&(!personajeSinEditar.equals(jugador.getPersonaje()))) {

                jugador = jugadores.get(p);
                p++;
            }
            //Si hemos salido del while porque hemos encontrado el jugador con ese personaje
            ArrayList<Usuario> usuarios = storage.loadUsers();
            if (personajeSinEditar.equals(jugador.getPersonaje())&&!(personajeSinEditar.equals(personajeEditable))) { //si encontramos el personaje original y lo hemos editado, entonces lo actualizamos
                //actualizamos el jugador

                usuarios.remove(jugador);
                jugador.setPersonaje(personajeEditable);
                usuarios.add(jugador);

                //ahora actualizamos la lista de usuarios en el xml
                storage.saveList(usuarios, "src/main/java/sistemaDeGuardado/Persistencia/Usuarios.xml");
            }

        } else {
            System.out.println(rojo+"No hay personajes disponibles actualmente"+reset);
        }

    }

    /**
     * Bloquea o desbloquea a un jugador según la opción seleccionada.
     */
    private void MenuBloqueoDesbloqueo(Boolean mode) {

        ArrayList<Jugador> jugadores = storage.getPlayers();
        Scanner sc = new Scanner(System.in);
        String reset = "\u001B[0m";
        String rojo = "\u001B[91m";
        String verde = "\u001B[32m";

        int i;
        if (mode) {
            System.out.println("Jugadores "+verde+"no bloqueados"+reset+": ");
            i = mostrarJugadoresNoBloqueados();
            if(i>0) System.out.println("Escribe el nombre del jugador que deseas "+rojo+"bloquear"+reset+": ");

        } else {

            System.out.println("Jugadores "+rojo+"bloqueados"+reset+": ");

            i=mostrarJugadoresBloqueados();
            if(i>0) System.out.println("Escribe el nombre del jugador que deseas "+verde+"desbloquear"+reset+": ");
        }


        if (i>0) {//Si se han mostrado jugadores que esten baneados o desbaneados (la opción seleccionada), entonces:
            String nombreJugador = sc.nextLine();

            Jugador jugador = buscarJugador(nombreJugador);
            while (jugador == null) {
                System.out.println("El jugador buscado " + rojo + "no existe" + reset + ", porfavor escribe un nombre de jugador válido");
                sc.nextLine();
                jugador = buscarJugador(nombreJugador);
            }
            jugadores.remove(jugador);
            if (mode) {
                operador.bloquearJugador(jugador);
                System.out.println("El jugador " + jugador.getNombre() + " ha sido Bloqueado");
            } else {
                operador.desbloquearJugador(jugador);
                System.out.println("El jugador " + jugador.getNombre() + " ha sido desbloqueado.");
            }
            jugadores.add(jugador);
            //actualizamos el jugador y el archivo xml
            updateUser(jugador);
            storage.saveList(usuarios, "src/main/java/sistemaDeGuardado/Persistencia/Usuarios.xml");
        }
        else if (mode){ //Si no se ha mostrado ningún usuario que este bloqueado o desbloqueado(la opción seleccionada), entonces:
            System.out.println("No hay jugadores para "+rojo+"bloquear"+reset);
        }
        else{
            System.out.println("No hay jugadores para "+verde+"desbloquear"+reset);
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
            File desafiosJugador = new File("src/main/java/sistemaDeGuardado/Persistencia/DesafiosPendientes.xml");
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
                Desafio d = jugador1.getDesafiosPendientes().getFirst();
                notifier.notifySubscriber(jugador1);
                System.out.println("¡Te ha desafiado " + d.getUsuarioOrigen() + "!");
                int opc;
                int opcCombate = 0;
                do{
                    System.out.println("¿Que quieres hacer?");
                    System.out.println("1. Aceptar el desafio y disputar un combate.");
                    System.out.println("2. Rechazar el desafio y repartir el oro.");
                    jugador2 = (Jugador) usuarios.get(getUserIndexByName(d.getUsuarioOrigen()));
                    opc = sc.nextInt();
                    switch (opc){
                        case 1:{
                            System.out.println("Puedes editar tu personaje antes de comenzar el combate: ");
                            System.out.println("1. Comenzar el combate contra " + jugador2.getName());
                            System.out.println("2. Editar personaje");
                            opcCombate = sc.nextInt();
                            switch (opcCombate){
                                case 1:
                                    Jugador ganador = IniciarCombate();
                                    ganador.setOro(ganador.getOro() + d.getOroApostado());
                                    if(ganador.equals(jugador1)){
                                        jugador2.setOro(jugador2.getOro() - d.getOroApostado());
                                    }
                                    else if(ganador.equals(jugador2)){
                                        jugador1.setOro(jugador1.getOro() - d.getOroApostado());
                                    }
                                    System.out.println(jugador1.getName() + " se queda con " + jugador1.getOro() + " de oro.");
                                    System.out.println(jugador2.getName() + " se queda con " + jugador2.getOro() + " de oro.");

                                    //Guardamos los cambios de los jugadores en el XML
                                    updateUser(jugador1);
                                    updateUser(jugador2);
                                    storage.saveList(usuarios, "src/main/java/sistemaDeGuardado/Persistencia/Usuarios.xml");
                                    break;
                                case 2:{
                                    registrarPersonaje(jugador1);
                                    break;
                                }
                            }
                            break;
                        }
                        case 2:{
                            int oroPerdido = ((d.getOroApostado() * 10) / 100);
                            if (jugador1.getOro() - oroPerdido < 0){
                                System.out.println("Debes pagar " + oroPerdido + " a " + jugador2.getNombre());
                                System.out.println("Como no tienes oro suficiente, debes disputar el combate.");
                            }
                            else{
                                jugador1.setOro(jugador1.getOro() - oroPerdido);
                                jugador2.setOro(jugador2.getOro() + oroPerdido);
                                System.out.println("Has pagado " + oroPerdido + " monedas de oro a " + jugador2.getNombre() + ".");
                            }
                            break;
                        }
                    }
                }while (opcCombate != 1);

                //Eliminamos el desafio pendiente de la lista y lo actualizamos en el XML
                jugador1.getDesafiosPendientes().removeFirst();
                desafiosPendientes.remove(d);
                storage.saveList(desafiosPendientes,"src/main/java/sistemaDeGuardado/Persistencia/DesafiosPendientes.xml");
                notifier.unSuscribe(jugador1);

                //Actualizamos también los jugadores.
                updateUser(jugador1);
                updateUser(jugador2);
                storage.saveList(usuarios, "src/main/java/sistemaDeGuardado/Persistencia/Usuarios.xml");
            }

            boolean correctOpt = true;
            do{
                System.out.println("\nMenú Principal:");
                System.out.println("1. Desafiar a otro usuario");
                System.out.println("2. Consultar Ranking global");
                System.out.println("3. Cambiar personaje");
                System.out.println("4. Gestionar equipo del personaje");
                System.out.println("5. Consultar oro en posesión");
                System.out.println("6. Volver");
                int opcion = sc.nextInt();
                sc.nextLine();  // Limpiar el buffer de entrada
                switch (opcion) {
                    case 1 -> {
                        iniciarDesafio();
                        correctOpt = true;
                    }
                    case 2 -> {
                        SingleRanking ranking= SingleRanking.getInstance();
                        ranking.showRanking();
                        correctOpt = true;
                    }
                    case 3 -> {
                        darDeBajaPersonaje(jugador1);
                        registrarPersonaje(jugador1);
                        correctOpt = true;
                    }
                    case 4 -> {
                        System.out.println("¿Qué quieres hacer?");
                        System.out.println("1. " + "🏪​" + "Acceder a la tienda de equipo");
                        System.out.println("2. " + "⚔️​🛡️​" + "Utilizar equipo en posesión");
                        System.out.println("3. " + "\uD83D\uDD19\u200B" + " Volver al menú principal.");
                        int equipoOpt = sc.nextInt();
                        switch (equipoOpt) {
                            case 1: {
                                elegirEquipoPersonalizado(jugador1);
                                break;
                            }
                            case 2: {
                                elegirEquipoPersonajes();
                                break;
                            }
                        }
                        correctOpt = true;
                    }
                    case 5 -> {//De momento devuelve solo la cantidad de oro que tiene el jugador que inicia sesion
                        //Incluso podemos dejar esto cuando implementemos esta opción entera.
                        System.out.println("Tienes " + jugador1.getOro() + " monedas de oro.");
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

        String reset = "\u001B[0m";
        String azul= "\u001B[38;5;153m";
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
                            System.out.println("Bienvenido"+"\u001B[38;5;166m"+" Operador"+reset+": "+ u.getName());
                            MostrarMenuOperador();
                            setJugador1(null);

                        } else if (u instanceof Jugador j) {
                            if ((jugador1 == null) ||(jugador1.isBloqueado())) setJugador1(j);
                                //jugador1.isBloqueado() esto ocurre cuando hemos intentado acceder al usuario de un jugador bloqueado y despues accedemos a otro usuario
                            else setJugador2(j);

                            //Si el jugador no esta bloqueado le damos la bienvenida
                            if (!j.isBloqueado()) {
                                System.out.println("Bienvenido"+azul+" Jugador"+reset+": " + u.getName());
                            }

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
                else if (jugador1.isBloqueado()) setJugador1(nuevo);
                else setJugador2(nuevo);

                registrarUsuario(nuevo);
                //registrarPersonaje(nuevo);

            }
        }
    }

    public Jugador IniciarCombate() {
        if (jugador1 != null && jugador2 != null) {
            //Creamos el combate entre el jugador 1 y 2
            Combate combate = new Combate(jugador1, jugador2);
            Jugador ganador = combate.IniciarCombate();
            combate.registrar();
            combate.mostrarResultado();
            return ganador;
        } else {
            System.out.println("No se han registrado suficientes jugadores.");
            return null;
        }
    }

    public void darDeBajaUsuario(Usuario user) {
        if (usuarios.contains(user)) {
            usuarios.remove(user);
            System.out.println("Usuario dado de baja: " + user.getNombre());
        }
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
            String ans;
            boolean correctAns;

            do{
                ans = sc.nextLine();
                if (!ans.equals("s") ^ (ans.equals("n"))){ //^ = XOR
                    System.out.println("No es una respuesta valida. Escribe s (Si) o n (No)");
                    correctAns = false;
                }
                else{
                    correctAns = true;
                }
            }while(!correctAns);

            if (ans.equals("s")) {
                destino.getDesafiosPendientes().add(d);
                //El desafio se valida y ahora pasa a ser un desafio pendiente
                desafiosPendientes.add(d);

                boolean found = updateUser(destino);
                if (found) {
                    storage.saveList(desafiosPendientes, "src/main/java/sistemaDeGuardado/Persistencia/DesafiosPendientes.xml");
                    System.out.println("El desafio de " + origen.getNombre() + " a " + destino.getNombre() + " ha sido validado.");
                }
            }
            iterator.remove();//Eliminamos el desafio de desafiosPendientesPorValidar
            storage.saveList(desafiosPendientesPorValidar, "src/main/java/sistemaDeGuardado/Persistencia/DesafiosPorValidar.XML");
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

            if(TipoPersonaje == 1){
                factory= new FactoryVampiros();
            }
            else if(TipoPersonaje == 2){
                factory = new FactoryLicantropos();
            }else{
                factory = new FactoryCazadores();
            }

            jugador1.registrarPersonaje(factory, characterName);
            updateUser(jugador1);
            storage.saveList(usuarios, "src/main/java/sistemaDeGuardado/Persistencia/Usuarios.xml");
            System.out.println("Personaje registrado para el jugador: " + jugador.getNombre());

        }
    }

    public void darDeBajaPersonaje(Jugador jugador) {
        if (jugador != null) {
            System.out.println("Personaje "+jugador.getPersonaje().getNombre()+" dado de baja para el jugador: " + jugador.getNombre());
            jugador.darDeBajaPersonaje();
        }
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
            storage.saveList(usuarios, "src/main/java/sistemaDeGuardado/Persistencia/Usuarios.xml");
        }
    }

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
        String azul ="\u001B[38;5;117m";
        String reset = "\u001B[0m";
        System.out.println("Se muestran los jugadores que pueden ser "+azul+"desafiados"+reset+": ");

        mostrarJugadoresNoBloqueados(); //Los jugadores que no estan bloqueados son los que se pueden desafiar

        //cargamos los jugadores del videojuego
        ArrayList<Jugador> totalplayers =storage.getPlayers();

        //metemos los jugadores no bloqueados y los bloqueados en conjuntos
        Set<String> jugadoresNoBloqueados= new HashSet<>();
        Set<String> jugadoresBloqueados= new HashSet<>();

        for (Jugador j : totalplayers) {
            if (!j.isBloqueado()){
                jugadoresNoBloqueados.add(j.getNombre());
            }else{
                jugadoresBloqueados.add(j.getNombre());
            }
        }

        System.out.println("Escribe el nombre del usuario al que quieres "+azul+"desafiar"+reset+": ");
        boolean CorrectPlayerName = false;
        String playerName;

        do{
            playerName = sc.nextLine();
            if (playerName.equals(jugador1.getName())){
                System.out.println("No puedes desafiarte a ti mismo. Escribe el nombre de usuario de otro jugador: ");
            }
            else if (playerName.isEmpty()){
                System.out.println("Por favor, escribe el nombre de otro jugador para desafiarle: ");
            }
            else if (jugadoresNoBloqueados.contains(playerName)){
                CorrectPlayerName = true;
            }
            else if (jugadoresBloqueados.contains(playerName)){
                System.out.println("El jugador "+playerName+" se encuentra "+"\u001B[91m"+"bloqueado"+"\u001B[0m"+" y no puede ser desafiado, por favor escribe otro jugador: ");
            }
            else{
                System.out.println("El jugador "+playerName+" no existe, escribe el nombre de un jugador válido: ");
            }

        } while(!CorrectPlayerName);

        System.out.println("¿Cuánto oro quieres apostar?");
        int apuesta = sc.nextInt();
        boolean isCorrect;
        do{
            if (jugador1.getOro() < apuesta){
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
            storage.saveList(desafiosPendientesPorValidar, "src/main/java/sistemaDeGuardado/Persistencia/DesafiosPorValidar.xml");
            System.out.println("¡Se ha enviado un desafio a " + playerName + "!");
            notifier.subscribe(destino);
            storage.saveList(notifier.getSubscribers(), "src/main/java/sistemaDeGuardado/Persistencia/Subscriptores.xml");
        }
        else{
            System.out.println("El usuario " + playerName + " no se ha encontrado.");
            System.out.println("Asegúrate de que el usuario está registrado e inténtalo de nuevo.");
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public int mostrarJugadoresNoBloqueados(){ //Devuelve el numero de jugadores no bloqueados
        ArrayList<Jugador> jugadores =storage.getPlayers();

        int i=1;

        if (jugador1 != null){
            for (Jugador jugador : jugadores) {
                if (!jugador.isBloqueado() && !jugador.getNombre().equals(jugador1.getNombre())) {
                    System.out.println(i+". " + jugador.getNombre());
                    i++;
                }
            }
        }
        else{
            for (Jugador jugador : jugadores) {
                if (!jugador.isBloqueado()) {
                    System.out.println(i+". " + jugador.getNombre());
                    i++;
                }
            }
        }

        return i-1;
    }


    public int mostrarJugadoresBloqueados(){ //Devuelve el numero de jugadores bloqueados
        ArrayList<Jugador> jugadores =storage.getPlayers();

        int i =1;

        for (Jugador jugador : jugadores) {
            if (jugador.isBloqueado()) {
                System.out.println(i+". " + jugador.getNombre());
                i++;
            }
        }
        return i-1;
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
        Usuario u;
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
        if (found) {
            return userIndex;
        }
        else{
            return -1;
        }
    }

    public void elegirEquipoPersonalizado(Jugador jugador) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Qué deseas crear?");
        System.out.println("1. Arma");
        System.out.println("2. Armadura");
        int tipoEquipo = sc.nextInt();
        sc.nextLine();
        boolean isFull = false;

        switch(tipoEquipo) {
            case 1 -> {
                factoryEquipo = new FabricaArmas();
                System.out.print("Nombre del arma: ");
                if (jugador.getPersonaje().getArmaActiva1() != null && jugador.getPersonaje().getArmaActiva2() != null){
                    System.out.println("Como tu personaje ya tiene armas en las dos manos, las armas que crees se sobreescribirán. ");
                    isFull = true;
                }
            }
            case 2 -> {
                factoryEquipo = new FabricaArmaduras();
                System.out.print("Nombre de la armadura: ");
            }
            default -> {
                System.out.println("Opción inválida.");
                return;
            }
        }

        String nombre = sc.nextLine();

        int valor;
        do {
            System.out.print("Valor del modificador (1-3): ");
            valor = sc.nextInt();
        } while (valor < 1 || valor > 3);

        int modType;
        do{
            System.out.println("¿Modificador de ataque (1) o de defensa (2)?");
            modType = sc.nextInt();
        }while(modType > 2 || modType < 1);

        int manos = 0;
        if (factoryEquipo instanceof FabricaArmas) {
            do {
                System.out.print("¿Cuántas manos requiere el arma? (1 o 2): ");
                manos = sc.nextInt();
            } while (manos != 1 && manos != 2);
        }

        // Crear equipo y aplicar propiedades personalizadas
        Equipo equipo = factoryEquipo.createEquipo();
        EquipoBase equipoBase = (EquipoBase) equipo;

        Modificador modificador = new Modificador();
        modificador.setValor(valor);
        equipoBase.setNombre(nombre);

        if (modType == 1){
            modificador.setTipo(Modificador.TipoModificador.Ataque);
        }
        else{
            modificador.setTipo(Modificador.TipoModificador.Defensa);
        }
        equipoBase.setModificador(modificador);

        if (equipo instanceof Arma) {
            ((Arma) equipo).setManos(manos);
        }

        int precio = calcularPrecio(valor);

        System.out.println("El precio del equipo es de " + precio + " de oro.");
        System.out.println("Tu oro actual: " + jugador.getOro());
        System.out.println("¿Quieres realizar la compra del arma? (s/n)");
        sc.nextLine();
        String buyConfirm = sc.nextLine();

        if (buyConfirm.equals("s")){
            if (jugador.getOro() < precio) {
                System.out.println("No tienes suficiente oro para adquirir este equipo.");
                return;
            }

            jugador.setOro(jugador.getOro() - precio);

            if (factoryEquipo instanceof FabricaArmas) {
                if (!isFull){
                    if (jugador.getPersonaje().getArmaActiva1() == null){
                        jugador.getPersonaje().setArmaActiva1((Arma) equipo);
                        jugador.getPersonaje().getArmas().add((Arma) equipo);
                    }
                    else{
                        jugador.getPersonaje().setArmaActiva2((Arma) equipo);
                        jugador.getPersonaje().getArmas().add((Arma) equipo);
                    }
                }
                else{
                    if (manos == 1){
                        jugador.getPersonaje().setArmaActiva1((Arma) equipo);
                        jugador.getPersonaje().getArmas().add((Arma) equipo);
                    }
                    else {
                        jugador.getPersonaje().setArmaActiva2((Arma) equipo);
                        jugador.getPersonaje().getArmas().add((Arma) equipo);
                    }
                }
                System.out.println("¡Arma equipada exitosamente!");
            } else {
                jugador.getPersonaje().setArmaduraActiva((Armadura) equipo);
                jugador.getPersonaje().getArmaduras().add((Armadura) equipo);
                System.out.println("¡Armadura equipada exitosamente!");
            }
            updateUser(jugador);
            storage.saveList(usuarios, "src/main/java/sistemaDeGuardado/Persistencia/Usuarios.xml");
        }
        else{
            System.out.println("Compra cancelada.");
        }
    }

    private int calcularPrecio(int valor) {
        return switch (valor) {
            case 1 -> 100;
            case 2 -> 200;
            case 3 -> 350;
            default -> 0;
        };
    }

    public void elegirEquipoPersonajes(){
        Scanner sc = new Scanner(System.in);
        boolean equiped = false;
        System.out.println("\u001B[91m" + "⚔\uFE0F\u200B" + "ELIGE TU ARMA: " + "\u001B[0m");
        PersonajeBase personaje = (PersonajeBase) jugador1.getPersonaje();
        ArrayList<Arma> listaArmas = (ArrayList<Arma>) personaje.getArmas();
        if (!listaArmas.isEmpty()){
            int i = 0;
            for(Arma a: listaArmas){
                System.out.println(i + ". " + a.getNombre());
                i++;
            }
            System.out.println("Escribe el nombre del arma que deseas equipar: ");
            String nombreArma = sc.nextLine();
            Arma arma = getArmaByName(nombreArma, listaArmas);
            if (arma.getManos() == 1) {
                personaje.setArmaActiva1(arma);
            }
            else{
                personaje.setArmaActiva2(arma);
            }
            System.out.println(nombreArma + " equipada.");
            equiped = true;
        }
        else{
            System.out.println("No posees armas. Puedes ir a la tienda y adquirir alguna utilizando tu oro.");
        }

        System.out.println("\u001B[94m" + "\uD83D\uDEE1\uFE0F" + " ELIGE TU ARMADURA: " + "\u001B[0m");
        ArrayList <Armadura> listaArmaduras = (ArrayList<Armadura>) personaje.getArmaduras();
        if (!listaArmaduras.isEmpty()){
            int j = 0;
            for (Armadura arm : listaArmaduras) {
                System.out.println(j + ". " + arm.getNombre());
                j++;
            }
            System.out.println("Escribe el nombre de la armadura que deseas equipar: ");
            String nombreArm = sc.nextLine();
            Armadura arm = getArmaduraByName(nombreArm, listaArmaduras);
            personaje.setArmaduraActiva(arm);
            System.out.println(nombreArm + " equipada");
            equiped = true;
        }
        else{
            System.out.println("No posees armaduras. Puedes ir a la tienda y adquirir alguna utilizando tu oro.");
        }

        if (equiped){ //Solo se actualiza si se han producido cambios.
            updateUser(jugador1);
            storage.saveList(usuarios, "src/main/java/sistemaDeGuardado/Persistencia/Usuarios.xml");
        }

    }

    private Arma getArmaByName(String name, ArrayList<Arma> listaArmas){
        for (Arma a : listaArmas) {
            if (a.getNombre().equalsIgnoreCase(name)) {
                return a;
            }
        }
        return null;
    }

    private Armadura getArmaduraByName(String name, ArrayList<Armadura> listaArmaduras) {
        for (Armadura arm : listaArmaduras) {
            if (arm.getNombre().equalsIgnoreCase(name)) {
                return arm;
            }
        }
        return null;
    }

}