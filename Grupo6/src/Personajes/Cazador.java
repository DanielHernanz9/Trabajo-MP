package Grupo6.src.Personajes;

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

import java.util.ArrayList;
import java.util.Random;
/**
 *
 */
public class Cazador extends PersonajeBase {

    private int Voluntad;
    private Talento Talento;

    public Cazador() {
        //Nombre: Cazador, puede que se tenga q cambiar en el futuro
        setNombre("Cazador");
        //Creacion de los esbirros de los cazadores
        crearEsbirros();
    }

    public void setVoluntad(Integer voluntad) {
        Voluntad = voluntad;
    }

    /**
     * 
     */

    @Override
    public void hacerHabilidadEspecial() {

    }

    @Override
    public void atacar() {

    }

    public Talento getTalento(){
        return this.Talento;
    }

    public int getVoluntad(){
        return this.Voluntad;
    }

    public void setTalento(Talento talento) {
        Talento = talento;
    }
}