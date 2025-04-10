package Grupo6.src.Personajes;

import Grupo6.src.HabilidadesEspeciales.Don;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;

/**
 * 
 */
public class Licantropo extends PersonajeBase {

    private int Rabia;
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

    public void setRabia(Integer rabia) {
        Rabia = rabia;
    }

    public void setDon(Don don) {
        Don = don;
    }
}