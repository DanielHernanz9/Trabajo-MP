package Grupo6.src.Personajes.PatronFactoryPersonajes;

import Grupo6.src.Desafio.DebilidadHandler;
import Grupo6.src.Desafio.FortalezaHandler;
import Grupo6.src.Equipo.*;
import Grupo6.src.Esbirros.Demonio;
import Grupo6.src.Esbirros.EsbirrosComposite;
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
    protected int ValorAtaque = 0;
    protected int ValorDefensa = 0;

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

    public void setDebilidades(List<DebilidadHandler> debilidades) {
        Debilidades = debilidades;
    }

    public void setFortalezas(List<FortalezaHandler> fortalezas) {
        Fortalezas = fortalezas;
    }

    protected List<FortalezaHandler> Fortalezas;

    public abstract void hacerHabilidadEspecial();

    public abstract void atacar();

    /**
     * Creación de los esbirros de los personajes.
     */
    public void crearEsbirros() {
        Random rand = new Random();
        Esbirros = new ArrayList<>();
        String nombre;
        int num;
        for (int i = 0; i < 5; i++) {
            num = rand.nextInt(3);
            FabricaEsbirros currentFactory;
            if (num == 0) {
                currentFactory = new FabricaGhouls();
                nombre = "Ghoul_";
            } else if (num == 1) {
                currentFactory = new FabricaHumanos();
                nombre = "Humano_";
            } else {
                currentFactory = new FabricaDemonios();
                nombre = "Demonio_";
            }
            if (currentFactory instanceof FabricaDemonios){
                Demonio nuevoDemonio = (Demonio) currentFactory.createEsbirro(nombre + i);
                List<Esbirro> subordinados = new ArrayList<>();
                for (int j = 0; j < 3; j++){
                    FabricaEsbirros subFactory = null;
                    int subType = rand.nextInt(3);
                    if (subType == 0){
                        subFactory = new FabricaGhouls();
                        nombre = "GhoulSub_";
                    }
                    if (subType == 1){
                        subFactory = new FabricaHumanos();
                        nombre = "HumanoSub_";
                    }
                    if (subType == 2){
                        subFactory = new FabricaDemonios();
                        nombre = "DemonioSub_";
                    }
                    subordinados.add(subFactory.createEsbirro(nombre + i));
                }
                    EsbirrosComposite composite = new EsbirrosComposite(subordinados);
                    nuevoDemonio.setSubordinados(composite);
                    Esbirros.add(nuevoDemonio);
            }else{
                Esbirros.add(currentFactory.createEsbirro(nombre + i));
            }
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
    public abstract void initializePersonaje();

    public Modificador getDebilidad() {
        return debilidad;
    }

    public Modificador getFortaleza() {
        return fortaleza;
    }

    public void setDebilidad(Modificador debilidad) {
        this.debilidad = debilidad;
    }

    public void setFortaleza(Modificador fortaleza) {
        this.fortaleza = fortaleza;
    }

    /**
     * Calcula los poderes de ataque y defensa del personaje segun el quipo que lleva.
     * Notar que se tiene en cuenta la posibilidad de que las armas otorguen defensa y las armaduras ataque,
     * pues el enunciado dice que esto es posible.
     */
    public void calcularValorEquipo(){
        Modificador modAtaque1;
        Modificador modAtaque2;
        Modificador modDefensa;

        if (ArmaActiva1 != null){
            modAtaque1 = ArmaActiva1.getModificador();
            if (modAtaque1.getTipo() == Modificador.TipoModificador.Ataque){
                ValorAtaque += modAtaque1.getValor();
            }
            else if(modAtaque1.getTipo() == Modificador.TipoModificador.Defensa){
                ValorDefensa += modAtaque1.getValor();
            }
        }

        if (ArmaActiva2 != null){
            modAtaque2 = ArmaActiva2.getModificador();
            if (modAtaque2.getTipo() == Modificador.TipoModificador.Ataque){
                ValorAtaque += modAtaque2.getValor();
            }
            else if(modAtaque2.getTipo() == Modificador.TipoModificador.Defensa){
                ValorDefensa += modAtaque2.getValor();
            }
        }

        if (ArmaduraActiva != null){
            modDefensa = ArmaduraActiva.getModificador();
            if (modDefensa.getTipo() == Modificador.TipoModificador.Ataque){
                ValorAtaque += modDefensa.getValor();
            }
            else if(modDefensa.getTipo() == Modificador.TipoModificador.Defensa){
                ValorDefensa += modDefensa.getValor();
            }
        }

    }

    public int getPoder() {
        return Poder;
    }

    public void setPoder(int poder) {
        Poder = poder;
    }

    public int getValorAtaque() {
        return ValorAtaque;
    }

    public int getValorDefensa() {
        return ValorDefensa;
    }

    public void setValorAtaque(int valorAtaque) {
        ValorAtaque = valorAtaque;
    }

    public void setValorDefensa(int valorDefensa) {
        ValorDefensa = valorDefensa;
    }
}