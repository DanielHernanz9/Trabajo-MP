package Grupo6.src.Esbirros;

import Grupo6.src.COSAS.*;
import Grupo6.src.App.*;
import Grupo6.src.Combate.*;
import Grupo6.src.Desafio.*;
import Grupo6.src.DesafioNotify.*;
import Grupo6.src.Equipo.*;
import Grupo6.src.Esbirros.*;
import Grupo6.src.Personajes.*;
import Grupo6.src.sistemaDeGuardado.*;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;

public class FabricaGhouls extends FabricaEsbirros {

    public FabricaGhouls() {
    }

    @Override
    public EsbirroBase createEsbirro(String Nombre) {
        return new Ghoul(Nombre, 50); // 50 representa el nivel de dependencia
    }
}
