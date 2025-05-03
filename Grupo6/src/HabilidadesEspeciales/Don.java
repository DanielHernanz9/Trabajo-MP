package Grupo6.src.HabilidadesEspeciales;


import java.util.Objects;

public class Don extends Habilidad_Especial implements Cloneable {

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

    @Override
    public Don clone() {

        Don cloned = (Don) super.clone();  // Clonación superficial usando el método clone() de la superclase

        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Don don = (Don) o;
        return Rabia == don.Rabia;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Rabia);
    }
}