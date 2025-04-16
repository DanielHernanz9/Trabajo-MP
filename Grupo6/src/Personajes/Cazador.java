package Grupo6.src.Personajes;

import Grupo6.src.HabilidadesEspeciales.Talento;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;

/**
 *
 */
public class Cazador extends PersonajeBase {

    private int Voluntad;
    private Talento Talento;

    public Cazador(){

    }

    public Cazador(String nombre) {
        this.Nombre = nombre;
        this.Talento = new Talento(100);
        //Creacion de los esbirros de los cazadores
        crearEsbirros();
    }

    public void setVoluntad(Integer voluntad) {
        Voluntad = voluntad;
    }

    /**
     * 
     */

    @Override
    public void hacerHabilidadEspecial() {

    }

    @Override
    public void atacar() {

    }

    public Talento getTalento(){
        return this.Talento;
    }

    public int getVoluntad(){
        return this.Voluntad;
    }

    public void setTalento(Talento talento) {
        Talento = talento;
    }

    public void setVoluntad(int voluntad) {
        Voluntad = voluntad;
    }

    @Override
    public void reducirSalud(){
        if (Salud > 0){
            Salud--;
        }
        if (Voluntad > 0){
            Voluntad--;
        }
    }

    @Override
    public void initialicePersonaje(){
        Salud = 5;
        Voluntad = 0;
    }

}