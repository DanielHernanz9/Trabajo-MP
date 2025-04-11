package Grupo6.src.Esbirros.PatronFactoryEsbirros;

import Grupo6.src.Esbirros.Demonio;

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