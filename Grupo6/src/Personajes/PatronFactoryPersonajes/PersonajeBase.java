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

    private String Nombre;

    private Habilidad_Especial Habilidad;

    private List<Arma> Armas;

    private Arma ArmaActiva1;

    private Arma ArmaActiva2;

    private List<Armadura> Armaduras;

    private Armadura ArmaduraActiva;

    private List<Esbirro> Esbirros;

    private Integer Oro;

    private Integer Health;

    private Integer Poder;

    private List<DebilidadHandler> Debilidades;

    private List<FortalezaHandler> Fortalezas;




    public abstract void hacerHabilidadEspecial();

    public abstract void atacar();

}