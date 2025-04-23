package Grupo6.src.Combate;

import Grupo6.src.COSAS.*;
import Grupo6.src.App.*;
import Grupo6.src.Combate.*;
import Grupo6.src.Desafio.*;
import Grupo6.src.Equipo.*;
import Grupo6.src.Esbirros.*;
import Grupo6.src.Personajes.*;
import Grupo6.src.sistemaDeGuardado.*;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;

public abstract class EstrategiaPotencial {

    public EstrategiaPotencial() {
    }

    public abstract int calcularPotencialAtaque(Object o);

    public abstract int calcularPotencialDefensa(Object o);

}
