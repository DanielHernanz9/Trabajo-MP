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
    private int demonIndex;

    /**
     * Default constructor, no se deberia instanciar este
     *
     * @param Nombre
     */
    public EsbirrosComposite(String Nombre) {
        super(Nombre);
        this.demonIndex = 0;
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
            lastEsbirro.recibirDaño();

            if (lastEsbirro.getSalud() <= 0) {
                childrenComposite.remove(lastEsbirro);
            }
        }
        return childrenComposite.size();
    }
}