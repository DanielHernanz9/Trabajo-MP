package Grupo6.src.Personajes;

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
public class Vampiro extends PersonajeBase {

    private Integer Sangre;
    private String Pacto; //DESCRIPCION DEL PACTO ENTRE EL ESBIRRO Y SU AMO
    public Disciplina Disciplina;

    public Vampiro() {
    }

    @Override
    public void hacerHabilidadEspecial() {


    }

    @Override
    public void atacar() {

    }

    public Disciplina getDisciplina(){
        return this.Disciplina;
    }

    public int getValorequipo(){
        return 0;
    }
}