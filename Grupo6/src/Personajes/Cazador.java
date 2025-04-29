package Grupo6.src.Personajes;

import Grupo6.src.Equipo.Modificador;
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
    public void initializePersonaje(){
        Salud = 5;
        Voluntad = 0;
        Poder = 5;
        calcularValorEquipo();
        crearEsbirros();
    }

    /**
     * El enunciado no especifica como aumenta la voluntad de los cazadores.
     *  le he puesto el mismo método que a los licántropos
     * @param atacado
     */
    @Override
    public void gestionarRecursosHabilidad(boolean atacado){
        if(!atacado){
            Voluntad += 4;
        }
    }

    /**
     * En el enunciado no se describe cómo gasta la voluntad un cazador para hacer un talento.
     * @return valor booleano false.
     */
    @Override
    public boolean habilidadPosible(){
        return false;
    }
}