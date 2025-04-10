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

public abstract class Usuario {

    protected String Nombre;
    protected String Nick;
    protected String Password;

    // Interfaz Constructor
    public Usuario() {

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

    public String getName() {
        return this.Nombre;
    }
}