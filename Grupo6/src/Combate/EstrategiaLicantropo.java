package Grupo6.src.Combate;

import Grupo6.src.Personajes.*;

public class EstrategiaLicantropo extends EstrategiaPotencial {

    public EstrategiaLicantropo() {
    }

    @Override
    public int calcularPotencialAtaque(Object o) {
        if (o instanceof Licantropo licantropo) {
            return licantropo.getPoder() + licantropo.getDon().getAtaque() + licantropo.getRabia();
        }
        throw new IllegalArgumentException("Objeto no es un Licantropo");
    }

    @Override
    public int calcularPotencialDefensa(Object o) {
        if (o instanceof Licantropo licantropo) {
            return licantropo.getPoder() + licantropo.getDon().getDefensa() + licantropo.getRabia();
        }
        throw new IllegalArgumentException("Objeto no es un Licantropo");
    }
}
