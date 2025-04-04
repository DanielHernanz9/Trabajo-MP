package Grupo6.src.Combate;

import Grupo6.src.COSAS.*;
import Grupo6.src.App.*;
import Grupo6.src.Combate.*;
import Grupo6.src.Desafio.*;
import Grupo6.src.DesafioNotify.*;
import Grupo6.src.Equipo.*;
import Grupo6.src.Esbirros.*;
import Grupo6.src.Personajes.*;

/**
 * 
 */
public class EstrategiaLicántropo {

    public EstrategiaLicántropo() {

    }

    public int calcularPotencial(Licantropo licantropo) {
        return licantropo.getPoder() + licantropo.getDon().getAtaque() + licantropo.getRabia();
    }

}