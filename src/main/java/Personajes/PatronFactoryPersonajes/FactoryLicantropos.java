package Personajes.PatronFactoryPersonajes;

import Personajes.*;

public class FactoryLicantropos extends FactoryPersonaje {

    /**
     * Default constructor
     */
    public FactoryLicantropos() {
    }

    @Override
    public PersonajeBase createPersonaje(String name) {
        return new Licantropo(name);
    }

}