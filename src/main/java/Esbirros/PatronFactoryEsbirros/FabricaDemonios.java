package Esbirros.PatronFactoryEsbirros;

import Esbirros.Demonio;

public class FabricaDemonios extends FabricaEsbirros {

    public FabricaDemonios() {
    }

    @Override
    public EsbirroBase createEsbirro(String Nombre) {
        Demonio demonio = new Demonio();
        demonio.registrarDemonio(Nombre, "Pacto Normal");
        return demonio;
    }
}