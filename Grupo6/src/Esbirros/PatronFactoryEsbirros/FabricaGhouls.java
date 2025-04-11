package Grupo6.src.Esbirros.PatronFactoryEsbirros;

import Grupo6.src.Esbirros.Ghoul;

public class FabricaGhouls extends FabricaEsbirros {

    public FabricaGhouls() {
    }

    @Override
    public EsbirroBase createEsbirro(String Nombre) {
        Ghoul ghoul = new Ghoul();
        ghoul.setNombre(Nombre);
        ghoul.setDependencia(50);
        return ghoul;
    }
}
