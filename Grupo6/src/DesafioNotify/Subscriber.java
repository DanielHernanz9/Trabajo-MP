package Grupo6.src.DesafioNotify;
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

import javax.naming.Context;

/**
 * 
 */
public abstract class Subscriber {

    /**
     * Default constructor
     */
    public Subscriber() {
    }

    /**
     * @param Context
     */
    public abstract void mostrarResultado(Context Context);

    /**
     * @param Context
     */
    public abstract void mostrarNotificacionDesafio(Context Context);

}