package Grupo6.src.Esbirros;

import Grupo6.src.COSAS.*;
import Grupo6.src.App.*;
import Grupo6.src.Combate.*;
import Grupo6.src.Desafio.*;
import Grupo6.src.DesafioNotify.*;
import Grupo6.src.Equipo.*;
import Grupo6.src.Esbirros.*;
import Grupo6.src.Personajes.*;
import Grupo6.src.sistemaDeGuardado.*;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EsbirrosComposite extends EsbirroBase {
    private List<EsbirroBase> childrenComposite = new ArrayList<>();

    public EsbirrosComposite() {
        super();
    }

    public void add(EsbirroBase esbirro) {
        childrenComposite.add(esbirro);
    }

    public void remove(Esbirro esbirro) {
        childrenComposite.remove(esbirro);
    }

    public List<EsbirroBase> getChildren() {
        return childrenComposite;
    }

    @Override
    public int recibirDaño() {
        if (!childrenComposite.isEmpty()) {
            EsbirroBase lastEsbirro = childrenComposite.get(childrenComposite.size() - 1);
            lastEsbirro.setSalud(lastEsbirro.getSalud() - 1);
            System.out.println("La salud de " + lastEsbirro + " ahora es de " + lastEsbirro.getSalud());
            if (lastEsbirro.getSalud() <= 0) {
                childrenComposite.remove(lastEsbirro);
            }
        }

        return childrenComposite.size();
    }

    public List<EsbirroBase> getChildrenComposite() {
        return childrenComposite;
    }

    public void setChildrenComposite(List<EsbirroBase> childrenComposite) {
        this.childrenComposite = childrenComposite;
    }
}