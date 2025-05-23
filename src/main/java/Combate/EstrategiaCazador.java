package Combate;
import Personajes.*;

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
