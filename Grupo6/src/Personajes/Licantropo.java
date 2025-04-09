package Grupo6.src.Personajes;

import Grupo6.src.COSAS.Don;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;

/**
 * 
 */
public class Licantropo extends PersonajeBase {

    private Integer Rabia;
    private Don Don;

    /**
     * Default constructor
     */
    public Licantropo() {
        setNombre("Licantropo");

        crearEsbirros();
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

    public Don getDon(){
        return this.Don;
    }

    public int getRabia(){
        return this.Rabia;
    }
}