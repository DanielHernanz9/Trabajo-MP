package Equipo;

public class FabricaArmaduras extends FabricaEquipo {


    public FabricaArmaduras() {
    }

    @Override
    public Equipo createEquipo() {
        return new Armadura();
    }

}