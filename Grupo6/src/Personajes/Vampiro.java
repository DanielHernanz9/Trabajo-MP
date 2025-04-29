package Grupo6.src.Personajes;

import Grupo6.src.Esbirros.Demonio;
import Grupo6.src.Esbirros.EsbirrosComposite;
import Grupo6.src.Esbirros.PatronFactoryEsbirros.*;
import Grupo6.src.HabilidadesEspeciales.Disciplina;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Vampiro extends PersonajeBase {

    private int Sangre;
    private String Pacto; //DESCRIPCION DEL PACTO ENTRE EL ESBIRRO Y SU AMO
    public Disciplina Disciplina;

    public Vampiro(){

    }

    public Vampiro(String name) {
        Random rand = new Random();
        Esbirros= new ArrayList<>();
        this.Disciplina = new Disciplina(3, 10);
        this.Nombre = name;
        this.Sangre = rand.nextInt(5) + 1;
        //Creacion de los esbirros de los Vampiros
        this.crearEsbirros();
    }

    /**
     * Este metodo sobreescribe al original ya que los vampiros no pueden tener esbirros humanos
     */
    @Override
    public void crearEsbirros() {
        Random rand = new Random();
        Esbirros = new ArrayList<>();
        int num;
        String nombre;
        for (int i = 0; i < 5; i++){
            num = rand.nextInt(2);
            FabricaEsbirros currentFactory;
            if (num == 0){
                currentFactory = new FabricaGhouls();
                nombre = "Ghoul_";
            }else{
                currentFactory = new FabricaDemonios();
                nombre = "Demonio_";
            }
            if (currentFactory instanceof FabricaDemonios){
                Demonio nuevoDemonio = (Demonio) currentFactory.createEsbirro(nombre + i);
                List<Esbirro> subordinados = new ArrayList<>();
                for (int j = 0; j < 3; j++){
                    FabricaEsbirros subFactory = null;
                    int subType = rand.nextInt(3);
                    if (subType == 0){
                        subFactory = new FabricaGhouls();
                        nombre = "GhoulSub_";
                    }
                    if (subType == 1){
                        subFactory = new FabricaHumanos();
                        nombre = "HumanoSub_";
                    }
                    if (subType == 2){
                        subFactory = new FabricaDemonios();
                        nombre = "DemonioSub_";
                    }
                    subordinados.add(subFactory.createEsbirro(nombre + i));
                }
                EsbirrosComposite composite = new EsbirrosComposite(subordinados);
                nuevoDemonio.setSubordinados(composite);
                Esbirros.add(nuevoDemonio);
            }else{
                Esbirros.add(currentFactory.createEsbirro(nombre + i));
            }
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

    public int getSangre() {
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
        Sangre = 0;
        Poder = 5; //Entiendo que el poder viene de serie con el personaje. He puesto uno diferente a cada uno.
        calcularValorEquipo();
        crearEsbirros();
    }

    @Override
    public void gestionarRecursosHabilidad(boolean atacado){
        String morado = "\u001B[35m";
        String reset = "\u001B[0m";
        if(atacado){
            Sangre += 4; //El enunciado dice que aumenta 4 si ataca
        }
        System.out.println("¡ " + morado + Nombre + reset + " roba 4 puntos de sangre a su rival!");
        System.out.println(morado + Nombre + reset + " ahora tiene " + Sangre + " puntos de Sangre y necesita " + Disciplina.getCoste() + " para hacer su Disciplina.");
    }

    @Override
    public boolean habilidadPosible(){
        return Disciplina.getCoste() <= Sangre;
    }
}