package Grupo6.src.Esbirros;

public class FabricaGhouls extends FabricaEsbirros {

    public FabricaGhouls() {
    }

    @Override
    public Esbirro createEsbirro(String Nombre) {
        return new Ghoul(Nombre, 50); // 50 representa el nivel de dependencia
    }
}
