package Personajes.PatronFactoryPersonajes;

import Desafio.DebilidadHandler;
import Desafio.FortalezaHandler;
import Equipo.*;
import Esbirros.Demonio;
import Esbirros.EsbirrosComposite;
import HabilidadesEspeciales.Habilidad_Especial;
import Esbirros.PatronFactoryEsbirros.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public abstract class PersonajeBase implements Personaje,Cloneable {

    protected String Nombre;
    protected Habilidad_Especial Habilidad;
    protected List<Arma> Armas = new ArrayList<>();
    protected Arma ArmaActiva1;
    protected Arma ArmaActiva2;
    protected List<Armadura> Armaduras = new ArrayList<>();
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

    public abstract void gestionarRecursosHabilidad(boolean atacado);

    public abstract boolean habilidadPosible();

    public PersonajeBase clone() {
        try {
            // Clonación superficial del objeto base
            PersonajeBase clon = (PersonajeBase) super.clone();

            // Clonación profunda de las listas y sus elementos
            clon.Armas = new ArrayList<>();
            for (Arma arma : this.Armas) {
                clon.Armas.add(arma.clone());  // Asumiendo que Arma tiene su propio método clone()
            }

            clon.Armaduras = new ArrayList<>();
            for (Armadura armadura : this.Armaduras) {
                clon.Armaduras.add(armadura.clone());  // Asumiendo que Armadura tiene su propio método clone()
            }

            clon.Esbirros = new ArrayList<>();
            for (Esbirro esbirro : this.Esbirros) {
                clon.Esbirros.add(esbirro.clone());  // Asumiendo que Esbirro tiene su propio método clone()
            }

            //clon.Debilidades = new ArrayList<>(this.Debilidades);
            //clon.Fortalezas = new ArrayList<>(this.Fortalezas);


            return clon;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError("Clonación no soportada en PersonajeBase", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PersonajeBase that = (PersonajeBase) o;
        return Oro == that.Oro && Salud == that.Salud && Poder == that.Poder && ValorAtaque == that.ValorAtaque && ValorDefensa == that.ValorDefensa && Objects.equals(Nombre, that.Nombre) && Objects.equals(Habilidad, that.Habilidad) && Objects.equals(Armas, that.Armas) && Objects.equals(ArmaActiva1, that.ArmaActiva1) && Objects.equals(ArmaActiva2, that.ArmaActiva2) && Objects.equals(Armaduras, that.Armaduras) && Objects.equals(ArmaduraActiva, that.ArmaduraActiva) && Objects.equals(Esbirros, that.Esbirros) && Objects.equals(debilidad, that.debilidad) && Objects.equals(fortaleza, that.fortaleza) && Objects.equals(Debilidades, that.Debilidades) && Objects.equals(Fortalezas, that.Fortalezas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Nombre, Habilidad, Armas, ArmaActiva1, ArmaActiva2, Armaduras, ArmaduraActiva, Esbirros, Oro, Salud, Poder, ValorAtaque, ValorDefensa, debilidad, fortaleza, Debilidades, Fortalezas);
    }
}