package Grupo6.src.Equipo;

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

import java.lang.ref.PhantomReference;

/**
 * 
 */
public abstract class EquipoBase implements Equipo {

    protected String Nombre;
    protected Modificador modificador;


    public Modificador getModificador() {
        return modificador;
    }
}