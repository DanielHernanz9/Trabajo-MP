package Grupo6.src.Equipo;

import Grupo6.src.COSAS.*;
import Grupo6.src.App.*;
import Grupo6.src.Combate.*;
import Grupo6.src.Desafio.*;
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
    protected int Precio;


    public Modificador getModificador() {
        return modificador;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setModificador(Modificador modificador) {
        this.modificador = modificador;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }
}