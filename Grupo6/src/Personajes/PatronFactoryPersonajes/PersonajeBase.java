package Grupo6.src.Personajes.PatronFactoryPersonajes;

import Grupo6.src.Desafio.DebilidadHandler;
import Grupo6.src.Desafio.FortalezaHandler;
import Grupo6.src.Equipo.*;
import Grupo6.src.Esbirros.*;
import Grupo6.src.COSAS.Habilidad_Especial;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

    public Habilidad_Especial getHabilidad() {
        return Habilidad;
    }

    public String getNombre() {
        return Nombre;
    }

    public List<Arma> getArmas() {
        return Armas;
    }

    public Arma getArmaActiva1() {
        return ArmaActiva1;
    }

    public Arma getArmaActiva2() {
        return ArmaActiva2;
    }

    public List<Armadura> getArmaduras() {
        return Armaduras;
    }

    public Armadura getArmaduraActiva() {
        return ArmaduraActiva;
    }

    public List<Esbirro> getEsbirros() {
        return Esbirros;
    }

    public Integer getOro() {
        return Oro;
    }

    public Integer getHealth() {
        return Health;
    }

    public Integer getPoder() {
        return Poder;
    }

    public List<DebilidadHandler> getDebilidades() {
        return Debilidades;
    }

    public List<FortalezaHandler> getFortalezas() {
        return Fortalezas;
    }

    protected List<DebilidadHandler> Debilidades;

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setHabilidad(Habilidad_Especial habilidad) {
        Habilidad = habilidad;
    }

    public void setArmas(List<Arma> armas) {
        Armas = armas;
    }

    public void setArmaActiva1(Arma armaActiva1) {
        ArmaActiva1 = armaActiva1;
    }

    public void setArmaActiva2(Arma armaActiva2) {
        ArmaActiva2 = armaActiva2;
    }

    public void setArmaduras(List<Armadura> armaduras) {
        Armaduras = armaduras;
    }

    public void setArmaduraActiva(Armadura armaduraActiva) {
        ArmaduraActiva = armaduraActiva;
    }

    public void setEsbirros(List<Esbirro> esbirros) {
        Esbirros = esbirros;
    }

    public void setOro(Integer oro) {
        Oro = oro;
    }

    public void setHealth(Integer health) {
        Health = health;
    }

    public void setPoder(Integer poder) {
        Poder = poder;
    }

    public void setDebilidades(List<DebilidadHandler> debilidades) {
        Debilidades = debilidades;
    }

    public void setFortalezas(List<FortalezaHandler> fortalezas) {
        Fortalezas = fortalezas;
    }

    protected List<FortalezaHandler> Fortalezas;




    public abstract void hacerHabilidadEspecial();

    public abstract void atacar();

    public void crearEsbirros() {
        Random rand = new Random();

        Esbirros = new ArrayList<>();

        //Creacion de los esbirros de los cazadores
        int num;
        for (int i = 0; i < 20; i++) {
            num = rand.nextInt(3);
            FabricaEsbirros actualFactory;
            if (num == 0) {
                actualFactory = new FabricaGhouls();


            } else if (num == 1) {

                actualFactory = new FabricaHumanos();
            } else {

                actualFactory = new FabricaDemonios();

            }
            Esbirros.add(actualFactory.createEsbirro("Esbirro_" + i));

        }
    }

}