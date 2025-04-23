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
/**
 * 
 */
public class EstrategiaCazador extends EstrategiaPotencial {

    public EstrategiaCazador() {
    }

    @Override
    public int calcularPotencialAtaque(Object o) {
        if (o instanceof Cazador cazador) {
            return cazador.getPoder() + cazador.getTalento().getAtaque() + cazador.getVoluntad() + cazador.getValorAtaque();
        }
        throw new IllegalArgumentException("Objeto no es un Cazador");
    }

    @Override
    public int calcularPotencialDefensa(Object o) {
        if (o instanceof Cazador cazador) {
            return cazador.getPoder() + cazador.getTalento().getDefensa() + cazador.getVoluntad() + cazador.getValorDefensa();
        }
        throw new IllegalArgumentException("Objeto no es un Cazador");
    }
}
