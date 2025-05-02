package Grupo6.src.HabilidadesEspeciales;


public class Don extends Habilidad_Especial {

    private int Rabia;

    public Don(){

    }

    public Don(int rabia, int ataque) {
        this.Rabia = rabia;
        ValorAtaque = ataque;
    }

    public int getRabia() {
        return Rabia;
    }

    public void setRabia(int rabia) {
        Rabia = rabia;
    }
}