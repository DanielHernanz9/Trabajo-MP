package Grupo6.src.App;

import Grupo6.src.Combate.Combate;
import Grupo6.src.Personajes.PatronFactoryPersonajes.FactoryPersonaje;
import Grupo6.src.Desafio.Desafio;
import Grupo6.src.Personajes.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class JuegoCombateManager {

    private FactoryPersonaje factory;
    private final ArrayList<Usuario> usuarios;
    private Jugador jugador1;
    private Jugador jugador2;
    private final Operador operador;
    private final ArrayList<Combate> combates;

    public JuegoCombateManager() {
        this.combates = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.operador = new Operador("admin", "admin123"); // operador por defecto
        usuarios.add(operador); // registrar operador
    }

    public void IniciarJuego() {
        IniciarProcesoRegistro();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n¿Menú de quién deseas ver?");
            System.out.println("1. Jugador\n2. Operador\n3. Salir");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> MostrarMenuJugador();
                case 2 -> MostrarMenuOperador();
                case 3 -> {
                    System.out.println("Saliendo del juego...");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    public void MostrarMenuOperador() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenú Operador:");
            System.out.println("1. Validar Desafíos");
            System.out.println("2. Bloquear Jugador");
            System.out.println("3. Desbloquear Jugador");
            System.out.println("4. Volver");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> gestionarDesafios();
                case 2 -> {
                    System.out.print("Nombre del jugador a bloquear: ");
                    String nombre = sc.nextLine();
                    Jugador j = buscarJugador(nombre);
                    if (j != null) bloquearJugadores(j);
                }
                case 3 -> {
                    System.out.print("Nombre del jugador a desbloquear: ");
                    String nombre = sc.nextLine();
                    Jugador j = buscarJugador(nombre);
                    if (j != null) desbloquearJugadores(j);
                }
                case 4 -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    public void MostrarMenuJugador() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenú Jugador:");
            System.out.println("1. Desafiar y Combatir");
            System.out.println("2. Ver Ranking");
            System.out.println("3. Cambiar Personaje");
            System.out.println("4. Volver");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> {
                    if (jugador1 != null && jugador2 != null) {
                        Desafio d = new Desafio(jugador1, jugador2);
                        //jugador2.agregarDesafio(d);
                        validarDesafio(d);
                        IniciarCombate();
                    } else {
                        System.out.println("Debe haber 2 jugadores registrados.");
                    }
                }
                case 2 -> System.out.println("Ranking: (funcionalidad pendiente)");
                case 3 -> {
                    darDeBajaPersonaje(jugador1);
                    registrarPersonaje(jugador1);
                }
                case 4 -> { return; }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    //crear numero determinado de operadores y que ya no haya más
    public void IniciarProcesoRegistro() {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Tienes cuenta? (s/n):");
        String tieneCuenta = sc.nextLine();

        System.out.print("Usuario: ");
        String nombre = sc.nextLine();
        System.out.print("Contraseña: ");
        String pass = sc.nextLine();

        if (tieneCuenta.equalsIgnoreCase("s")) {
            for (Usuario u : usuarios) {
                if (u.getNombre().equals(nombre) && u.getPassword().equals(pass)) {
                    if (u instanceof Operador) {
                        System.out.println("Bienvenido Operador.");
                    } else if (u instanceof Jugador j) {
                        System.out.println("Bienvenido Jugador.");
                        if (jugador1 == null) setJugador1(j);
                        else setJugador2(j);
                    }
                    return;
                }
            }
            System.out.println("Usuario no encontrado o contraseña incorrecta.");
        } else {
            Jugador nuevo = new Jugador();
            registrarUsuario(nuevo);
            registrarPersonaje(nuevo);
            if (jugador1 == null) setJugador1(nuevo);
            else setJugador2(nuevo);
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

    public void registrarUsuario(Usuario user) {
        if (!usuarios.contains(user)) {
            usuarios.add(user);
            System.out.println("Usuario registrado: " + user.getNombre());
        } else {
            System.out.println("El usuario ya está registrado.");
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

    public void registrarPersonaje(Jugador jugador) {
        if (jugador != null) {
            jugador.registrarPersonaje(factory);
            System.out.println("Personaje registrado para el jugador: " + jugador.getNombre());
        }
    }

    public void darDeBajaPersonaje(Jugador jugador) {
        if (jugador != null) {
            jugador.darDeBajaPersonaje();
            System.out.println("Personaje dado de baja para el jugador: " + jugador.getNombre());
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

    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    private Jugador buscarJugador(String nombre) {
        for (Usuario u : usuarios) {
            if (u instanceof Jugador j && j.getNombre().equals(nombre)) {
                return j;
            }
        }
        System.out.println("Jugador no encontrado.");
        return null;
    }
}