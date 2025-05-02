package Grupo6.src.Esbirros;

import Grupo6.src.Esbirros.PatronFactoryEsbirros.EsbirroBase;

import java.util.Objects;

public class Demonio extends EsbirroBase implements Cloneable {
    private String pacto;
    private EsbirrosComposite subordinados;

    public Demonio(){
        super();

    }

    public void registrarDemonio(String nombre, String pacto) {
        this.Nombre = nombre;
        this.pacto = pacto;
        EsbirrosComposite NewSubordinados = new EsbirrosComposite();
        NewSubordinados.setNombre(nombre + "_Subordinados");
        this.subordinados = NewSubordinados;
    }

    public EsbirrosComposite getSubordinados() {
        return subordinados;
    }

    @Override
    public int recibirDaño() {
        if (!subordinados.getChildren().isEmpty()) {
            // Aplica daño al último esbirro subordinado
            subordinados.recibirDaño();
        } else {
            // Si no hay subordinados, el demonio recibe el daño
            return super.recibirDaño();
        }
        return getSalud();
    }

    public String getPacto(){
        return this.pacto;
    }

    public void setSubordinados(EsbirrosComposite subordinados) {
        this.subordinados = subordinados;
    }

    public void setPacto(String pacto) {
        this.pacto = pacto;
    }

    @Override
    public Demonio clone() {
        // Realizamos la clonación superficial de los campos heredados (Nombre, Salud, etc.)
        Demonio cloned = (Demonio) super.clone();

        // Clonamos el campo subordinados de manera profunda (clonación profunda)
        if (this.subordinados != null) {
            cloned.subordinados = this.subordinados.clone();  // Suponiendo que EsbirrosComposite tiene un método clone()
        }

        // Si 'pacto' fuera un objeto mutable, lo clonaríamos aquí, pero String es inmutable, por lo que no es necesario.

        return cloned; // Retornamos el objeto clonado

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Demonio demonio = (Demonio) o;
        return Objects.equals(pacto, demonio.pacto) && Objects.equals(subordinados, demonio.subordinados);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pacto, subordinados);
    }
}
