package Grupo6.src.Personajes.PatronFactoryPersonajes;

import Grupo6.src.App.*;
import Grupo6.src.Combate.*;
import Grupo6.src.Desafio.*;
import Grupo6.src.Equipo.*;
import Grupo6.src.Esbirros.*;
import Grupo6.src.Personajes.*;
import Grupo6.src.sistemaDeGuardado.*;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;
/**
 * 
 */
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