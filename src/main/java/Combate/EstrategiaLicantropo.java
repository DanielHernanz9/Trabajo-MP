package Combate;

import Personajes.*;

public class EstrategiaLicantropo extends EstrategiaPotencial {

    public EstrategiaLicantropo() {
    }

    @Override
    public int calcularPotencialAtaque(Object o) {
        if (o instanceof Licantropo licantropo) {
            return licantropo.getPoder() + licantropo.getDon().getAtaque() + licantropo.getRabia() + licantropo.getValorAtaque();
        }
        throw new IllegalArgumentException("Objeto no es un Licantropo");
    }

    @Override
    public int calcularPotencialDefensa(Object o) {
        if (o instanceof Licantropo licantropo) {
            return licantropo.getPoder() + licantropo.getDon().getDefensa() + licantropo.getRabia() + licantropo.getValorDefensa();
        }
        throw new IllegalArgumentException("Objeto no es un Licantropo");
    }
}
