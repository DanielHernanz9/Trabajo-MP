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
public class Talento extends Habilidad_Especial {
    private int Coste;
    private int Ataque;
    private int Defensa;

    public Talento(int Ataque, int Coste) {
        this.Ataque = Ataque;
        this.Coste = Coste;

    }

    public int getAtaque(){
        return this.Ataque;
    }

    public int getDefensa(){
        return this.Defensa;
    }

}