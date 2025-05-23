package Personajes.PatronFactoryPersonajes;

import Desafio.*;
import Equipo.*;
import Esbirros.PatronFactoryEsbirros.Esbirro;
import HabilidadesEspeciales.Habilidad_Especial;
import java.util.List;

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
    int getSalud();
    boolean hasEsbirros();
    int getPoder();

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
    void setSalud(int salud);
    void setPoder(int poder);

    // Métodos de comportamiento
    void hacerHabilidadEspecial();
    void atacar();
    void crearEsbirros();
    void reducirSalud();
    void initializePersonaje();
    void gestionarRecursosHabilidad(boolean atacado);
    boolean habilidadPosible();

    PersonajeBase clone();
}