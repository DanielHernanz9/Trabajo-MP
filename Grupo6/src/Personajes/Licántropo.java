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

/**
 * 
 */
public class Licántropo extends PersonajeBase {

    private Integer Rabia;

    /**
     * Default constructor
     */
    public Licántropo() {

        crearEsbirros();

    }

    public void setRabia(Integer rabia) {
        Rabia = rabia;
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
}