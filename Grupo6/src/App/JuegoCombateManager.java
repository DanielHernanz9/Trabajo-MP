package Grupo6.src.App;

import Grupo6.src.Combate.Combate;
import Grupo6.src.Personajes.PatronFactoryPersonajes.FactoryPersonaje;
import Grupo6.src.Desafio.Desafio;
import Grupo6.src.Personajes.*;

import java.util.ArrayList;

public class JuegoCombateManager {

    private FactoryPersonaje factory;
    private final ArrayList<Usuario> usuarios;
    private Jugador jugador1;
    private Jugador jugador2;
    private final Operador operador;
    private ArrayList<Combate> combates;

    // Constructor
    public JuegoCombateManager() {
        this.combates = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.operador = new Operador();
    }

    // TODO Method para iniciar el juego y gestionar los combates
    public void IniciarJuego() {
        if (jugador1 != null && jugador2 != null) {
            System.out.println("Iniciando combate entre " + jugador1 + " y " + jugador2);
            Combate combate = new Combate(jugador1, jugador2);
            registrarCombate(combate);
            // Aquí podrías implementar la lógica de combate, la determinación de ganador, etc.
        } else {
            System.out.println("No se han registrado suficientes jugadores.");
        }
    }

    // Method para registrar al usuario
    public void registrarUsuario(Usuario user) {
        if (!usuarios.contains(user)) {
            usuarios.add(user);
            System.out.println("Usuario registrado: " + user);
        } else {
            System.out.println("El usuario ya está registrado.");
        }
    }

    // Method para dar de baja al usuario
    public void darDeBajaUsuario(Usuario user) {
        if (usuarios.contains(user)) {
            usuarios.remove(user);
            System.out.println("Usuario dado de baja: " + user);
        } else {
            System.out.println("El usuario no está registrado.");
        }
    }

    // TODO Method para registrar los combates
    public void registrarCombate(Combate combate) {
        combates.add(combate);
        //hay que guardarlo en el almacen / fichero
        System.out.println("Combate registrado entre: " + combate.getJugador1() + " y " + combate.getJugador2());
    }

    // TODO Métodos de interacción con los jugadores
    public void mostrarNotificacionDesafio(Desafio desafio) {
        // Mostrar una notificación cuando un desafío sea enviado o aceptado
        System.out.println("¡Nuevo desafío de: " + desafio.getDesafiante() + " a " + desafio.getDesafiado());
    }

    // Method para mostrar el resultado
    public void mostrarResultado(Combate combate) {
        System.out.println("Resultado del combate: " + combate.getResultado());
    }

    // TODO Method para manejar los desafíos entre jugadores
    public void gestionarDesafios() {
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Jugador jugador) {
                if (!jugador.getDesafiosPendientes().isEmpty()) {
                    for (Desafio desafio : jugador.getDesafiosPendientes()) {
                        mostrarNotificacionDesafio(desafio);
                        // Aquí podrías permitir que el jugador acepte o rechace el desafío
                    }
                }
            }
        }
    }

    // Method de registro de personajes para los jugadores
    public void registrarPersonaje(Jugador jugador) {
        if (jugador != null) {
            jugador.registrarPersonaje(factory);
            System.out.println("Personaje registrado para el jugador: " + jugador);
        }
    }

    // Method para dar de baja personajes para los jugadores
    public void darDeBajaPersonaje(Jugador jugador) {
        if (jugador != null) {
            jugador.darDeBajaPersonaje();
            System.out.println("Personaje dado de baja para el jugador: " + jugador);
        }
    }

    // Method para que el operador valide desafíos
    public void validarDesafio(Desafio desafio) {
        if (operador.validarDesafio(desafio)) {
            System.out.println("Desafío validado por el operador.");
        } else {
            System.out.println("Desafío no válido.");
        }
    }

    // Method para bloquear jugadores
    public void bloquearJugadores(Jugador jugador) {
        operador.bloquearUsuario(jugador);
        System.out.println("Jugador bloqueado: " + jugador);
    }

    // Method para desbloquear jugadores
    public void desbloquearJugadores(Jugador jugador) {
        operador.desbloquearUsuario(jugador);
        System.out.println("Jugador desbloqueado: " + jugador);
    }

    // Method para obtener el jugador 1
    public Jugador getJugador1() {
        return jugador1;
    }

    // Method para establecer el jugador 1
    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    // Method para obtener el jugador 2
    public Jugador getJugador2() {
        return jugador2;
    }

    // Method para establecer el jugador 2
    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }
}
