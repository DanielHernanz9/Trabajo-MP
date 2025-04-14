package Grupo6.src.App;

import Grupo6.src.COSAS.*;
import Grupo6.src.App.*;
import Grupo6.src.Combate.*;
import Grupo6.src.Desafio.*;
import Grupo6.src.Equipo.*;
import Grupo6.src.Esbirros.*;
import Grupo6.src.Personajes.*;
import Grupo6.src.sistemaDeGuardado.*;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.Random;

/**
 * Clase base que representa a un usuario del sistema.
 * Contiene información básica como el nombre, el nick y la contraseña del usuario.
 * Esta clase será extendida por otras clases como Jugador y Operador.
 */
public abstract class Usuario implements Serializable {

    protected String Nombre;  // Nombre del usuario.
    protected String Nick;    // Nick del usuario (nombre de usuario en el sistema).
    protected String Password; // Contraseña del usuario.

    /**
     * Constructor vacío para la clase Usuario.
     * Este constructor se utiliza para inicializar los atributos de los usuarios.
     */
    public Usuario() {
        // Constructor vacío para permitir la inicialización sin parámetros.
    }

    /**
     * Retorna el nombre del usuario.
     *
     * @return El nombre del usuario.
     */
    public String getNombre() {
        return Nombre;
    }

    /**
     * Retorna la contraseña del usuario.
     *
     * @return La contraseña del usuario.
     */
    public String getPassword() {
        return Password;
    }

    /**
     * Retorna el nick del usuario.
     *
     * @return El nick del usuario.
     */
    public String getNick() {
        return Nick;
    }

    /**
     * Retorna el nombre del usuario.
     * Este es redundante, ya que getNombre() también devuelve el nombre.
     *
     * @return El nombre del usuario.
     */
    public String getName() {
        return this.Nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(Nombre, usuario.Nombre) && Objects.equals(Nick, usuario.Nick) && Objects.equals(Password, usuario.Password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nombre, Nick, Password);
    }
}