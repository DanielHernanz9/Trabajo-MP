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

import java.util.ArrayList;
import java.util.Random;

/**
 *
 */
public class Vampiro extends PersonajeBase {

    private Integer Sangre;
    private String Pacto; //DESCRIPCION DEL PACTO ENTRE EL ESBIRRO Y SU AMO
    public Disciplina Disciplina;

    public Vampiro() {
        Random rand = new Random();

        Esbirros= new ArrayList<>();

        //Creacion de los esbirros de los Vampiros

    }

    @Override
    public void crearEsbirros() {
        Random rand = new Random();

        Esbirros = new ArrayList<>();

        int num;
        for (int i=0;i<20;i++){
            num= rand.nextInt(2);
            FabricaEsbirros actualFactory;
            if (num==0){
                actualFactory= new FabricaGhouls();



            }else{
                actualFactory= new FabricaDemonios();

            }

            Esbirros.add(actualFactory.createEsbirro("Esbirro_"+i));

        }
    }

    public void setPacto(String pacto) {
        Pacto = pacto;
    }

    public void setSangre(Integer sangre) {
        Sangre = sangre;
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

    public int getValorEquipo(){
        return 0;
    }
}