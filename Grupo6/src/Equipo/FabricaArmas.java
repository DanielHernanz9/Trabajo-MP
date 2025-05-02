package Grupo6.src.Equipo;

public class FabricaArmas extends FabricaEquipo {

    public FabricaArmas() {
    }

    @Override
    public Equipo createEquipo() {
        return new Arma();
    }

}