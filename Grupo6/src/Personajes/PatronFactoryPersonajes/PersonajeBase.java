package Grupo6.src.Personajes.PatronFactoryPersonajes;

import Grupo6.src.Desafio.DebilidadHandler;
import Grupo6.src.Desafio.FortalezaHandler;
import Grupo6.src.Equipo.*;
import Grupo6.src.HabilidadesEspeciales.Habilidad_Especial;
import Grupo6.src.Esbirros.PatronFactoryEsbirros.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class PersonajeBase implements Personaje {

    protected String Nombre;
    protected Habilidad_Especial Habilidad;
    protected List<Arma> Armas;
    protected Arma ArmaActiva1;
    protected Arma ArmaActiva2;
    protected List<Armadura> Armaduras;
    protected Armadura ArmaduraActiva;
    protected List<Esbirro> Esbirros;
    protected int Oro;
    protected int Salud;
    protected int Poder;

    protected Modificador debilidad;
    protected Modificador fortaleza;

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

    public int getOro() {
        return Oro;
    }

    public int getPoder() {
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

    public void setOro(int oro) {
        Oro = oro;
    }

    public void setSalud(int salud) {
        Salud = salud;
    }

    public void setPoder(int poder) {
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

        //Creacion de los esbirros de los personajes
        int num;
        for (int i = 0; i < 20; i++) {
            num = rand.nextInt(3);
            FabricaEsbirros currentFactory;
            if (num == 0) {
                currentFactory = new FabricaGhouls();
            } else if (num == 1) {

                currentFactory = new FabricaHumanos();
            } else {

                currentFactory = new FabricaDemonios();

            }
            Esbirros.add(currentFactory.createEsbirro("Esbirro_" + i));
        }
    }

    public int getSalud(){
        return this.Salud;
    }
    public boolean hasEsbirros(){
        return !this.Esbirros.isEmpty();
    }

    public void setSalud(Integer salud) {
        Salud = salud;
    }

    public abstract void reducirSalud();

    /**
     * Sirve para inicializar las estadísticas de los personajes al inicio de los combates.
     */
    public abstract void initialicePersonaje();
}