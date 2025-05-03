package HabilidadesEspeciales;

public class Talento extends Habilidad_Especial implements Cloneable {

    public Talento(){

    }

    public Talento(int Ataque) {
        this.ValorAtaque = Ataque;
    }
    @Override
    public Talento clone() {

        Talento cloned = (Talento) super.clone();  // Llamamos al método clone() de la superclase (Habilidad_Especial)
        return cloned;
    }
}