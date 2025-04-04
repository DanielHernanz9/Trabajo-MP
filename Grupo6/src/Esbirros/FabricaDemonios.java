package Grupo6.src.Esbirros;

public class FabricaDemonios extends FabricaEsbirros {

    public FabricaDemonios() {
    }

    @Override
    public Esbirro createEsbirro(String Nombre) {
        return new Demonio(Nombre, "Pacto Normal");
    }
}