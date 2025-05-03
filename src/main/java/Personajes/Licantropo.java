package Personajes;

import HabilidadesEspeciales.Don;
import Personajes.PatronFactoryPersonajes.*;

public class Licantropo extends PersonajeBase {

    private int Rabia;
    private Don Don;

    public Licantropo(String name) {
        this.Nombre = name;
        this.Don = new Don(10, 2);
    }

    public Licantropo(){

    }

    @Override
    public void hacerHabilidadEspecial() {

    }

    @Override
    public void atacar() {

    }

    public Don getDon(){
        return this.Don;
    }

    public int getRabia(){
        return this.Rabia;
    }

    public void setRabia(int rabia) {
        Rabia = rabia;
    }

    public void setDon(Don don) {
        Don = don;
    }

    @Override
    public void reducirSalud(){
        if(Salud > 0){
            Salud--;
        }
        if (Rabia < 3){
            Rabia++;
        }
    }

    @Override
    public void initializePersonaje(){
        Salud = 5;
        Rabia = 0;
        Poder = 10;
        calcularValorEquipo();
        crearEsbirros();
    }

    @Override
    public void gestionarRecursosHabilidad(boolean atacado){
        String amarillo = "\u001B[33m";
        String reset = "\u001B[0m";
        if(atacado){
            Rabia += 4;
        }
        System.out.println("¡A " + amarillo + Nombre + reset + " le da mucha Rabia (4 puntos) haber sido atacado!");
        System.out.println(amarillo + Nombre + reset + " ahora tiene " + Rabia + " puntos de Rabia, y necesita " + Don.getRabia() + " para hacer su Don." );
    }

    @Override
    public boolean habilidadPosible(){
        return Don.getRabia() <= Rabia;
    }
}