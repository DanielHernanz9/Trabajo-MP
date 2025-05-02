package Grupo6.src.Combate;

import Grupo6.src.Esbirros.PatronFactoryEsbirros.Esbirro;
import Grupo6.src.Personajes.Cazador;
import Grupo6.src.Personajes.Licantropo;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;
import Grupo6.src.Personajes.Vampiro;

import java.io.Serializable;
import java.util.Random;

public class Ronda implements Serializable {

    private Personaje Atacante;
    private Personaje Atacado;
    private int PotencialAtaqueP1;
    private int PotencialDefensaP2;
    private EstrategiaPotencial EstrategiaAtacante;
    private EstrategiaPotencial EstrategiaAtacado;
    private int NumeroRonda;
    private String nombreAtacante;
    private String nombreAtacado;

    public Ronda(){

    }

    public Ronda(Personaje atacante, Personaje atacado, int numeroRonda) {
        this.Atacante = atacante;
        this.Atacado = atacado;
        this.nombreAtacado = Atacado.getNombre();
        this.nombreAtacante = Atacante.getNombre();
        EstrategiaPotencial Estrategia1 = null;
        EstrategiaPotencial Estrategia2 = null;

        if (atacante instanceof Licantropo){
            Estrategia1 = new EstrategiaLicantropo();
        }
        else if (atacante instanceof Cazador){
            Estrategia1 = new EstrategiaCazador();
        }
        else if (atacante instanceof Vampiro){
            Estrategia1 = new EstrategiaVampiro();
        }

        if (atacado instanceof Licantropo){
            Estrategia2 = new EstrategiaLicantropo();
        }
        else if (atacado instanceof Cazador){
            Estrategia2 = new EstrategiaCazador();
        }
        else if (atacado instanceof Vampiro){
            Estrategia2 = new EstrategiaVampiro();
        }

        setEstrategia(Estrategia1, Estrategia2);
        this.NumeroRonda = numeroRonda;
    }

    private int calcularPotencialDeAtaque(Personaje personaje) {
        return EstrategiaAtacante.calcularPotencialAtaque(personaje);
    }

    private int calcularPotencialDeDefensa(Personaje personaje) {
        return EstrategiaAtacado.calcularPotencialDefensa(personaje);
    }

    //Como solo puede cambiar la salud del atacado, sera la que comprobemos para verificar si ha terminado el combate.
    //La del atacante no va a ser nunca 0 (o no deberia entrar a una ronda sin salud)
    public boolean verificarFinCombate() {
        return Atacado.getSalud() == 0;
    }

    private void setEstrategia(EstrategiaPotencial strategyAtacante, EstrategiaPotencial strategyAtacado ) {
        EstrategiaAtacante = strategyAtacante;
        EstrategiaAtacado = strategyAtacado;
    }

    public void reducirSalud(int damage) {
        String reset = "\u001B[0m";     //Restablece el color blanco
        String rojo = "\u001B[91m";     //Ataque
        String verde = "\u001B[32m";    //Defensa

        if (Atacante.hasEsbirros()) {
            Esbirro esbirro = Atacante.getEsbirros().getLast();
            System.out.println("¡" + "\u001B[35m" + nombreAtacante + reset + " ha infligido " +rojo+ "daño"+reset+" al esbirro " + esbirro.getNombre() + " de " + nombreAtacado + " !");

            for (int i = 0; i < damage; i++){
                esbirro.setSalud(esbirro.recibirDaño());
            }

            System.out.println("La "+ verde + "salud"+ reset +" de " + esbirro.getNombre() + " ahora es de " + esbirro.getSalud());

            if (esbirro.getSalud() == 0){
                Atacante.getEsbirros().removeLast();
            }
        } else {
            for (int i = 0; i < damage; i++){
                Atacado.reducirSalud();
            }

            if (damage == 1){
                System.out.println("¡" + "\u001B[35m" + nombreAtacante + reset +" ha infligido " + damage + " punto de "+ rojo +"daño"+reset+" a " + nombreAtacado + "!");
            }
            else{
                System.out.println("¡" + "\u001B[35m" + nombreAtacante + reset +" ha infligido " + damage + " puntos de "+ rojo +"daño"+reset+" a " + nombreAtacado + "!");
            }

            System.out.println("¡" + "\u001B[35m" + nombreAtacante + reset +" ha infligido " + damage + " punto de "+ rojo +"daño"+reset+" a " + nombreAtacado + "!");
            System.out.println("La "+ verde + "salud"+ reset +" de " + nombreAtacado + " ahora es de " + Atacado.getSalud());
        }
    }

    public void ejecutarRonda(){
        String colorAtaque = "\u001B[38;5;196m";
        String colorDefensa = "\u001B[36m";
        String reset = "\u001B[0m";
        String morado = "\u001B[35m";
        String amarillo = "\u001B[33m";

        System.out.println();
        System.out.println("¡Comienza la ronda " + NumeroRonda + "!");

        PotencialAtaqueP1 = calcularPotencialDeAtaque(Atacante);
        PotencialDefensaP2 = calcularPotencialDeDefensa(Atacado);

        if (Atacante.getArmaActiva1() != null || Atacante.getArmaActiva2() != null){
            System.out.println(morado + nombreAtacante + reset + " ataca a " + amarillo + nombreAtacado + reset + " con " + Atacante.getArmaActiva1().getNombre());
        } else {
            System.out.println(morado + nombreAtacante + reset + " ataca a " + amarillo + nombreAtacado + reset + " con un puñetazo.");
        }

        System.out.println("El " + colorAtaque + "potencial de ataque" + reset + " de " + morado + nombreAtacante + reset + " es de " + PotencialAtaqueP1);
        System.out.println("El " + colorDefensa + "potencial de defensa" + reset + " de " + amarillo + nombreAtacado + reset + " es de " + PotencialDefensaP2);

        Random random = new Random();
        int totalAtaque = 0;
        int totalDefensa = 0;
        int randomNumber;

        for (int i = 0; i < PotencialAtaqueP1; i++){
            randomNumber = random.nextInt(6) + 1;
            if (randomNumber == 5 || randomNumber == 6){
                totalAtaque += 1;
            }
        }

        for (int i = 0; i < PotencialDefensaP2; i++){
            randomNumber = random.nextInt(6) + 1;
            if (randomNumber == 5 || randomNumber == 6){
                totalDefensa += 1;
            }
        }

        System.out.println(morado + nombreAtacante + reset + " ha obtenido un ataque de " + totalAtaque);
        System.out.println(amarillo + nombreAtacado + reset + " ha obtenido una defensa de " + totalDefensa);

        //En el enunciado no se aclara qué hacen las habilidade una vez se ejecutan.
        //Por eso, he decidido que hagan el doble de daño.
        //Nos ayudará a que los combates no tengan tantas rondas.

        boolean atacado = false;
        if (totalAtaque >= totalDefensa){
            if (Atacante.habilidadPosible()){
                if (Atacante instanceof Vampiro){
                    ((Vampiro) Atacante).setSangre(((Vampiro) Atacante).getSangre() - ((Vampiro) Atacante).getDisciplina().getCoste());
                    System.out.println("¡" + "\u001B[35m" + nombreAtacante + reset + " utiliza una Disciplina!");
                }
                else if (Atacante instanceof Licantropo){
                    ((Licantropo) Atacante).setRabia(((Licantropo) Atacante).getRabia() - ((Licantropo) Atacante).getDon().getRabia());
                    System.out.println("¡" + "\u001B[35m" + nombreAtacante + reset + " utiliza un Don!");
                }
                else{
                    System.out.println("¡" + "\u001B[35m" + nombreAtacante + reset + " utiliza una Talento!");
                }
                reducirSalud(2);
            }
            else{
                reducirSalud(1);
                if(Atacante instanceof Vampiro){
                    Atacante.gestionarRecursosHabilidad(true);
                }
            }
        } else {
            if (Atacado.getArmaduraActiva() != null){
                System.out.println("¡" + amarillo + nombreAtacado + reset + " se defiende de " + morado + nombreAtacante + reset + " con " + Atacado.getArmaduraActiva().getNombre() + "!");
            } else {
                System.out.println("¡" + morado + nombreAtacante + reset + " no logra dañar a " + amarillo + nombreAtacado + reset + " en esta ronda!");
            }
        }

        if (verificarFinCombate()){
            System.out.println("¡" + amarillo + nombreAtacado + reset + " ha caido!");
        }
        else if (!(Atacado instanceof Vampiro)){
            Atacado.gestionarRecursosHabilidad(true);
        }
    }

    public Personaje getAtacante() {
        return Atacante;
    }

    public Personaje getAtacado() {
        return Atacado;
    }

    public int getPotencialAtaqueP1() {
        return PotencialAtaqueP1;
    }

    public int getPotencialDefensaP2() {
        return PotencialDefensaP2;
    }

    public EstrategiaPotencial getEstrategiaAtacante() {
        return EstrategiaAtacante;
    }

    public EstrategiaPotencial getEstrategiaAtacado() {
        return EstrategiaAtacado;
    }

    public int getNumeroRonda() {
        return NumeroRonda;
    }

    public String getNombreAtacante() {
        return nombreAtacante;
    }

    public String getNombreAtacado() {
        return nombreAtacado;
    }

    public void setAtacante(Personaje atacante) {
        Atacante = atacante;
    }

    public void setAtacado(Personaje atacado) {
        Atacado = atacado;
    }

    public void setPotencialAtaqueP1(int potencialAtaqueP1) {
        PotencialAtaqueP1 = potencialAtaqueP1;
    }

    public void setPotencialDefensaP2(int potencialDefensaP2) {
        PotencialDefensaP2 = potencialDefensaP2;
    }

    public void setEstrategiaAtacante(EstrategiaPotencial estrategiaAtacante) {
        EstrategiaAtacante = estrategiaAtacante;
    }

    public void setEstrategiaAtacado(EstrategiaPotencial estrategiaAtacado) {
        EstrategiaAtacado = estrategiaAtacado;
    }

    public void setNumeroRonda(int numeroRonda) {
        NumeroRonda = numeroRonda;
    }

    public void setNombreAtacante(String nombreAtacante) {
        this.nombreAtacante = nombreAtacante;
    }

    public void setNombreAtacado(String nombreAtacado) {
        this.nombreAtacado = nombreAtacado;
    }
}