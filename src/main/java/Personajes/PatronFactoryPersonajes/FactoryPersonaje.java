package Personajes.PatronFactoryPersonajes;

public abstract class FactoryPersonaje {

    public FactoryPersonaje() {
    }

    public abstract PersonajeBase createPersonaje(String name);

}