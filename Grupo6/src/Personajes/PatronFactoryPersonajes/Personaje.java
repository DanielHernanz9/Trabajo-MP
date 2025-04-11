package Grupo6.src.Personajes.PatronFactoryPersonajes;

import Grupo6.src.COSAS.*;
import Grupo6.src.Desafio.*;
import Grupo6.src.Equipo.*;
import Grupo6.src.Esbirros.PatronFactoryEsbirros.Esbirro;

import java.util.List;

/**
 * 
 */
public interface Personaje {



    // Getters
    Habilidad_Especial getHabilidad();
    String getNombre();
    List<Arma> getArmas();
    Arma getArmaActiva1();
    Arma getArmaActiva2();
    List<Armadura> getArmaduras();
    Armadura getArmaduraActiva();
    List<Esbirro> getEsbirros();
    int getOro();
    int getPoder();
    int getSalud();
    List<DebilidadHandler> getDebilidades();
    List<FortalezaHandler> getFortalezas();
    boolean hasEsbirros();

    // Setters
    void setNombre(String nombre);
    void setHabilidad(Habilidad_Especial habilidad);
    void setArmas(List<Arma> armas);
    void setArmaActiva1(Arma armaActiva1);
    void setArmaActiva2(Arma armaActiva2);
    void setArmaduras(List<Armadura> armaduras);
    void setArmaduraActiva(Armadura armaduraActiva);
    void setEsbirros(List<Esbirro> esbirros);
    void setOro(int oro);
    void setPoder(int poder);
    void setSalud(int salud);
    void setDebilidades(List<DebilidadHandler> debilidades);
    void setFortalezas(List<FortalezaHandler> fortalezas);

    // Métodos de comportamiento
    void hacerHabilidadEspecial();
    void atacar();
    void crearEsbirros();



}