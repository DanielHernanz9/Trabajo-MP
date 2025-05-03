package Grupo6.src.Esbirros;

import Grupo6.src.Esbirros.PatronFactoryEsbirros.Esbirro;
import Grupo6.src.Esbirros.PatronFactoryEsbirros.EsbirroBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EsbirrosComposite extends EsbirroBase implements Cloneable {
    private List<Esbirro> childrenComposite = new ArrayList<>();

    public EsbirrosComposite() {
        super();
    }

    public EsbirrosComposite(List<Esbirro> subordinados) {
        childrenComposite = subordinados;
    }

    public void add(EsbirroBase esbirro) {
        childrenComposite.add(esbirro);
    }

    public List<Esbirro> getChildren() {
        return childrenComposite;
    }

    @Override
    public int recibirDaño() {
        String verde = "\u001B[32m";
        String reset = "\u001B[0m";
        if (!childrenComposite.isEmpty()) {
            Esbirro lastEsbirro = childrenComposite.get(childrenComposite.size() - 1);
            lastEsbirro.setSalud(lastEsbirro.getSalud() - 1);
            System.out.println("La" + verde + " salud " + reset + " de " + lastEsbirro.getNombre() + " ahora es de " + lastEsbirro.getSalud());
            if (lastEsbirro.getSalud() <= 0) {
                childrenComposite.remove(lastEsbirro);
            }
        }

        return childrenComposite.size();
    }

    public List<Esbirro> getChildrenComposite() {
        return childrenComposite;
    }

    public void setChildrenComposite(List<Esbirro> childrenComposite) {
        this.childrenComposite = childrenComposite;
    }

    public void agregarEsbirro(EsbirroBase esbirro) {
        childrenComposite.add(esbirro);
    }

    @Override
    public EsbirrosComposite clone() {
        EsbirrosComposite cloned = (EsbirrosComposite) super.clone();
        cloned.childrenComposite = new ArrayList<>(this.childrenComposite.size()); // Clonamos la lista de hijos (esbirros)
        for (Esbirro esbirro : this.childrenComposite) {
            cloned.agregarEsbirro(esbirro.clone());  // Clonamos cada esbirro de forma profunda
        }
        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        EsbirrosComposite that = (EsbirrosComposite) o;
        return Objects.equals(childrenComposite, that.childrenComposite);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(childrenComposite);
    }
}

