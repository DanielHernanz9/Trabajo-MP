package Grupo6.src.App;

import Grupo6.src.COSAS.*;
import Grupo6.src.App.*;
import Grupo6.src.Combate.*;
import Grupo6.src.Desafio.*;
import Grupo6.src.DesafioNotify.*;
import Grupo6.src.Equipo.*;
import Grupo6.src.Esbirros.*;
import Grupo6.src.Personajes.*;
import Grupo6.src.sistemaDeGuardado.*;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;

/**
 * 
 */
public abstract class Usuario {

    private String Nombre;
    private String Nick;
    private String Password;

    // Interfaz Constructor
    public Usuario() {
    }

    public String getNombre() {
        return "";
    }

    public Object getPassword() {
        return null;
    }
}