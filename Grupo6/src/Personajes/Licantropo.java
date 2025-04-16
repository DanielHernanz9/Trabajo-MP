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
    public Licantropo(String name) {
        this.Nombre = name;
        this.Don = new Don(100, 100);
        crearEsbirros();
    }

    public Licantropo(){

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

    @Override
    public void reducirSalud(){
        if(Salud > 0){
            Salud--;
        }
        if (Rabia < 3){
            Rabia++;
        }
    }

    @Override
    public void initializePersonaje(){
        Salud = 5;
        Rabia = 3;
    }
}