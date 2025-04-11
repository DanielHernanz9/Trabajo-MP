package Grupo6.src.Esbirros;

import Grupo6.src.Esbirros.PatronFactoryEsbirros.Esbirro;
import Grupo6.src.Esbirros.PatronFactoryEsbirros.EsbirroBase;

import java.util.ArrayList;
import java.util.List;

public class EsbirrosComposite extends EsbirroBase {
    private List<Esbirro> childrenComposite = new ArrayList<>();

    public EsbirrosComposite() {
        super();
    }

    public void add(EsbirroBase esbirro) {
        childrenComposite.add(esbirro);
    }

    public void remove(Esbirro esbirro) {
        childrenComposite.remove(esbirro);
    }

    public List<Esbirro> getChildren() {
        return childrenComposite;
    }

    @Override
    public int recibirDaño() {
        if (!childrenComposite.isEmpty()) {
            Esbirro lastEsbirro = childrenComposite.get(childrenComposite.size() - 1);
            lastEsbirro.setSalud(lastEsbirro.getSalud() - 1);
            System.out.println("La salud de " + lastEsbirro + " ahora es de " + lastEsbirro.getSalud());
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
}