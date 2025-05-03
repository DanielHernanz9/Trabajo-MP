package Personajes.PatronFactoryPersonajes;

import Personajes.*;

public class FactoryCazadores extends FactoryPersonaje {

    /**
     * Default constructor
     */
    public FactoryCazadores() {
    }

    @Override
    public PersonajeBase createPersonaje(String nombre) {
        return new Cazador(nombre);
    }

}