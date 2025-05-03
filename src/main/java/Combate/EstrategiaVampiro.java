package Combate;
import Personajes.*;

public class EstrategiaVampiro extends EstrategiaPotencial {

    public EstrategiaVampiro() {
    }

    @Override
    public int calcularPotencialAtaque(Object o) {
        if (o instanceof Vampiro vampiro) {
            return vampiro.getPoder() + vampiro.getDisciplina().getAtaque() + vampiro.getValorAtaque();
        }
        throw new IllegalArgumentException("Objeto no es un Vampiro");
    }

    @Override
    public int calcularPotencialDefensa(Object o) {
        if (o instanceof Vampiro vampiro) {
            return vampiro.getPoder() + vampiro.getDisciplina().getDefensa() + vampiro.getValorDefensa();
        }
        throw new IllegalArgumentException("Objeto no es un Vampiro");
    }
}
