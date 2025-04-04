package Grupo6.src.Personajes.PatronFactoryPersonajes;

import Grupo6.src.Desafio.DebilidadHandler;
import Grupo6.src.Desafio.FortalezaHandler;
import Grupo6.src.Equipo.*;
import Grupo6.src.Esbirros.Esbirro;
import Grupo6.src.COSAS.Habilidad_Especial;

import java.util.List;

/**
 * 
 */
public abstract class PersonajeBase implements Personaje {

    protected String Nombre;

    protected Habilidad_Especial Habilidad;

    protected List<Arma> Armas;

    protected Arma ArmaActiva1;

    protected Arma ArmaActiva2;

    protected List<Armadura> Armaduras;

    protected Armadura ArmaduraActiva;

    protected List<Esbirro> Esbirros;

    protected Integer Oro;

    protected Integer Health;

    protected Integer Poder;

    protected List<DebilidadHandler> Debilidades;

    protected List<FortalezaHandler> Fortalezas;




    public abstract void hacerHabilidadEspecial();

    public abstract void atacar();

}