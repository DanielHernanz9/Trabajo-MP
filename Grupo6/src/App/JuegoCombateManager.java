package Grupo6.src.App;

import Grupo6.src.Combate.Combate;
import Grupo6.src.Personajes.FactoryPersonaje;
import Grupo6.src.Desafio.Desafio;

import java.util.ArrayList;

public class JuegoCombateManager {

    final private FactoryPersonaje factory;
    private ArrayList<Usuario> usuarios;
    private Jugador jugador1;
    private Jugador jugador2;
    final private Operador operador;

    // Constructor
    public JuegoCombateManager() {
        this.usuarios = new ArrayList<>();
        this.factory = new FactoryPersonaje();  // Supongamos que se inicializa aquí
        this.operador = new Operador();
    }

    // Métodos para manejar usuarios
    public void registrarUsuario(Usuario user) {
        if (!usuarios.contains(user)) {
            usuarios.add(user);
            System.out.println("Usuario registrado: " + user);
        } else {
            System.out.println("El usuario ya está registrado.");
        }
    }

    public void darDeBajaUsuario(Usuario user) {
        if (usuarios.contains(user)) {
            usuarios.remove(user);
            System.out.println("Usuario dado de baja: " + user);
        } else {
            System.out.println("El usuario no está registrado.");
        }
    }

    // Method para manejar combates
    public void registrarCombate(Combate combate) {
        // Aquí, se podría guardar el combate en una lista de combates o procesarlo
        System.out.println("Combate registrado entre: " + combate.getJugador1() + " y " + combate.getJugador2());
    }

    // Méthod para iniciar el juego y gestionar los combates
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

    // Métodos de interacción con los jugadores
    public void mostrarNotificacionDesafio(Desafio desafio) {
        // Mostrar una notificación cuando un desafío sea enviado o aceptado
        System.out.println("¡Nuevo desafío de: " + desafio.getDesafiante() + " a " + desafio.getDesafiado());
    }

    public void mostrarResultado(Combate combate) {
        // Mostrar los resultados del combate, por ejemplo, quién ganó y el puntaje
        System.out.println("Resultado del combate: " + combate.getResultado());
    }

    // Métodos para manejar los desafíos entre jugadores
    public void gestionarDesafios() {
        // Método para manejar la lógica de aceptar/desafiar rechazar, etc.
        for (Usuario usuario : usuarios) {
            if (usuario instanceof Jugador) {
                Jugador jugador = (Jugador) usuario;
                if (jugador.getDesafiosPendientes().size() > 0) {
                    for (Desafio desafio : jugador.getDesafiosPendientes()) {
                        mostrarNotificacionDesafio(desafio);
                        // Aquí podrías permitir que el jugador acepte o rechace el desafío
                    }
                }
            }
        }
    }

    // Métodos de manejo de personajes para los jugadores
    public void registrarPersonaje(Jugador jugador) {
        if (jugador != null) {
            jugador.registrarPersonaje(factory);
            System.out.println("Personaje registrado para el jugador: " + jugador);
        }
    }

    public void darDeBajaPersonaje(Jugador jugador) {
        if (jugador != null) {
            jugador.darDeBajaPersonaje();
            System.out.println("Personaje dado de baja para el jugador: " + jugador);
        }
    }

    // Método para que el operador valide desafíos
    public void validarDesafio(Desafio desafio) {
        if (operador.validarDesafio(desafio)) {
            System.out.println("Desafío validado por el operador.");
        } else {
            System.out.println("Desafío no válido.");
        }
    }

    // Métodos para bloquear/desbloquear jugadores
    public void bloquearUsuario(Jugador jugador) {
        operador.bloquearUsuario(jugador);
        System.out.println("Jugador bloqueado: " + jugador);
    }

    public void desbloquearUsuario(Jugador jugador) {
        operador.desbloquearUsuario(jugador);
        System.out.println("Jugador desbloqueado: " + jugador);
    }

    // Métodos para obtener jugadores y usuarios
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
}
