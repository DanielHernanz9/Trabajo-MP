
import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class PersonajeBase extends Personaje {

    /**
     * Default constructor
     */
    public PersonajeBase() {
    }

    /**
     * 
     */
    private String Nombre;

    /**
     * 
     */
    private void Habilidad;

    /**
     * 
     */
    private ListaArmas Armas;

    /**
     * 
     */
    private Arma ArmaActiva1;

    /**
     * 
     */
    private Arma ArmaActiva2;

    /**
     * 
     */
    private ListaArmaduras Armaduras;

    /**
     * 
     */
    private Armadura ArmaduraActiva;

    /**
     * 
     */
    private ListaEsbirros Esbirros;

    /**
     * 
     */
    private Integer Oro;

    /**
     * 
     */
    private Integer Health;

    /**
     * 
     */
    private Integer Poder;

    /**
     * 
     */
    private ListaDebilidades Debilidades;

    /**
     * 
     */
    private ListaFortalezas Fortalezas;

    /**
     * 
     */
    public abstract void hacerHabilidadEspecial();

    /**
     * 
     */
    public abstract void atacar();

}