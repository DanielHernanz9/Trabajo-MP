package Esbirros.PatronFactoryEsbirros;

import Esbirros.Humano;

public class FabricaHumanos extends FabricaEsbirros {

    public FabricaHumanos() {
    }

    @Override
    public EsbirroBase createEsbirro(String Nombre) {
        Humano humano = new Humano();
        humano.setNombre(Nombre);
        return humano;
    }
}
