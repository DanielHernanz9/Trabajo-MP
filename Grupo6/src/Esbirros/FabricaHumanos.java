package Grupo6.src.Esbirros;

public class FabricaHumanos extends FabricaEsbirros {

    public FabricaHumanos() {
    }

    @Override
    public Esbirro createEsbirro(String Nombre) {
        return new Humano(Nombre);
    }
}
