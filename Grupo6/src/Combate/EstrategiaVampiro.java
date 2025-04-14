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

public class EstrategiaVampiro extends EstrategiaPotencial {

    public EstrategiaVampiro() {
    }

    @Override
    public int calcularPotencialAtaque(Object o) {
        if (o instanceof Vampiro vampiro) {
            return vampiro.getPoder() + vampiro.getDisciplina().getAtaque() + vampiro.getValorEquipo();
        }
        throw new IllegalArgumentException("Objeto no es un Vampiro");
    }

    @Override
    public int calcularPotencialDefensa(Object o) {
        if (o instanceof Vampiro vampiro) {
            return vampiro.getPoder() + vampiro.getDisciplina().getDefensa() + vampiro.getValorEquipo();
        }
        throw new IllegalArgumentException("Objeto no es un Vampiro");
    }
}
