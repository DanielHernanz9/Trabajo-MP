package Personajes;

import HabilidadesEspeciales.Talento;
import Personajes.PatronFactoryPersonajes.*;

import java.util.Objects;

public class Cazador extends PersonajeBase implements Cloneable {

    private int Voluntad;
    private Talento Talento;

    public Cazador(){

    }

    public Cazador(String nombre) {
        this.Nombre = nombre;
        this.Talento = new Talento(100);
        this.crearEsbirros(); //revisar si hace falta aqui

    }

    public void setVoluntad(Integer voluntad) {
        Voluntad = voluntad;
    }

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

    @Override
    public Cazador clone() {
        Cazador clon = (Cazador) super.clone();

        // Clonación profunda de atributos propios de Cazador
        clon.Voluntad = this.Voluntad;

        if (this.Talento != null) {
            clon.Talento = this.Talento.clone();
        }

        return clon;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cazador cazador = (Cazador) o;
        return Voluntad == cazador.Voluntad && Objects.equals(Talento, cazador.Talento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Voluntad, Talento);
    }
}