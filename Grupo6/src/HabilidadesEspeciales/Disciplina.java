package Grupo6.src.HabilidadesEspeciales;

public class Disciplina extends Habilidad_Especial {
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
}