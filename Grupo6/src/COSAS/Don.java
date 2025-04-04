package Grupo6.src.COSAS;

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

/**
 * 
 */
public class Don extends Habilidad_Especial {
    private int Rabia;
    private int Ataque;
    /**
     * Default constructor
     */
    public Don(int rabia, int ataque) {
        this.Rabia = rabia;
        this.Ataque = ataque;
    }

    public int getAtaque(){
        return this.Ataque;
    }

}