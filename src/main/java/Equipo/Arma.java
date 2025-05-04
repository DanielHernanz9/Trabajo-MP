package Equipo;

import java.util.Objects;

public class Arma extends EquipoBase implements Cloneable {

    private int Manos;

    public Arma() {
    }

    public int getManos() {
        return Manos;
    }

    public void setManos(int manos) {
        Manos = manos;
    }

    @Override
    public Arma clone() {
        Arma clon = (Arma) super.clone();  // Llama al clone() de EquipoBase
        return clon;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Arma arma = (Arma) o;
        return Manos == arma.Manos;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Manos);
    }
}