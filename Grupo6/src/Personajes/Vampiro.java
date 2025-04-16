package Grupo6.src.Personajes;

import Grupo6.src.Esbirros.PatronFactoryEsbirros.FabricaDemonios;
import Grupo6.src.Esbirros.PatronFactoryEsbirros.FabricaEsbirros;
import Grupo6.src.Esbirros.PatronFactoryEsbirros.FabricaGhouls;
import Grupo6.src.HabilidadesEspeciales.Disciplina;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 */
public class Vampiro extends PersonajeBase {

    private int Sangre;
    private String Pacto; //DESCRIPCION DEL PACTO ENTRE EL ESBIRRO Y SU AMO
    public Disciplina Disciplina;

    public Vampiro(){

    }
    public Vampiro(String name) {
        Random rand = new Random();
        Esbirros= new ArrayList<>();
        this.Disciplina = new Disciplina(100, 100);
        this.Nombre = name;
        this.Sangre = rand.nextInt(5) + 1;
        //Creacion de los esbirros de los Vampiros
        crearEsbirros();
    }

    @Override
    //Este metodo sobreescribe al original ya que los vampiros no pueden tener esbirros humanos
    public void crearEsbirros() {
        Random rand = new Random();

        Esbirros = new ArrayList<>();

        int num;
        for (int i = 0; i < 20; i++){
            num = rand.nextInt(2);
            FabricaEsbirros actualFactory;
            if (num == 0){
                actualFactory = new FabricaGhouls();

            }else{
                actualFactory = new FabricaDemonios();

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

    public Integer getSangre() {
        return Sangre;
    }

    public String getPacto() {
        return Pacto;
    }

    public void setDisciplina(Disciplina disciplina) {
        Disciplina = disciplina;
    }

    @Override
    public void reducirSalud(){
        if(Salud > 0) {
            Salud--;
        }
    }

    @Override
    public void initializePersonaje(){
        Salud = 5;
        Sangre = 10; //No entiendo cómo deberían sacar puntos de sangre los vampiros.
    }
}