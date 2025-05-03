package Personajes.PatronFactoryPersonajes;

import Personajes.*;

public class FactoryVampiros extends FactoryPersonaje {

    public FactoryVampiros() {
    }

    @Override
    public PersonajeBase createPersonaje(String name) {
        return new Vampiro(name);
    }

}