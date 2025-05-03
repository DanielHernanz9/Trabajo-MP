package Esbirros;

import Esbirros.PatronFactoryEsbirros.EsbirroBase;

public class Ghoul extends EsbirroBase {
    private int dependencia;

    public Ghoul() {
        super();
    }

   public int getDependencia() {return dependencia;}

    public void setDependencia(int dependencia) {
        this.dependencia = dependencia;
    }
}