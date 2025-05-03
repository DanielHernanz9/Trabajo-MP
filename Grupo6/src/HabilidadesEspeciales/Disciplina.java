package Grupo6.src.HabilidadesEspeciales;

import java.util.Objects;

public class Disciplina extends Habilidad_Especial implements Cloneable {
    private int Coste;

    public Disciplina(int ataque, int coste) {
        this.ValorAtaque = ataque;
        this.Coste = coste;
    }

    public Disciplina(){

    }

    public int getCoste() {
        return Coste;
    }

    public void setCoste(int coste) {
        Coste = coste;
    }

    @Override
    public Disciplina clone() {

        Disciplina clone = (Disciplina) super.clone();

        return clone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Disciplina that = (Disciplina) o;
        return Coste == that.Coste;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Coste);
    }
}