package Grupo6.src.Esbirros;

import Grupo6.src.Esbirros.PatronFactoryEsbirros.EsbirroBase;

import java.util.Objects;

public class Ghoul extends EsbirroBase implements Cloneable {
    private int dependencia;

    public Ghoul() {
        super();
    }

   public int getDependencia() {return dependencia;}

    public void setDependencia(int dependencia) {
        this.dependencia = dependencia;
    }

    @Override
    public Ghoul clone() {

        Ghoul cloned = (Ghoul) super.clone();
        // La dependencia es un tipo primitivo, por lo que no necesita clonación profunda. Si fuese un objeto, lo clonaríamos también.
        // Retornamos el clon de tipo Ghoul
        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Ghoul ghoul = (Ghoul) o;
        return dependencia == ghoul.dependencia;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dependencia);
    }
}
