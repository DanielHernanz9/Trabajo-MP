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

import java.util.Random;

/**
 * 
 */
public abstract class Usuario {

    private final String Nombre;
    private final String Nick;
    private final String Password;

    // Interfaz Constructor
    public Usuario(String nombre,String nick,String password) {

        Nombre=nombre;
        Nick=nick;
        Password=password;


    }



    public String getNombre() {
        return Nombre;
    }

    public String getPassword() {

        return Password;
    }
    public String getNick() {

        return Nick;
    }
}