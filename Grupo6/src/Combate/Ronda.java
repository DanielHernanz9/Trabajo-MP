package Grupo6.src.Combate;

import Grupo6.src.Personajes.PersonajeBase;

/**
 * 
 */
public class Ronda {

    /**
     * Default constructor
     */
    public Ronda() {
    }

    /**
     * 
     */
    private PersonajeBase Atacante;

    /**
     * 
     */
    private PersonajeBase Atacado;

    /**
     * 
     */
    private int PotencialAtaqueJ1;

    /**
     * 
     */
    private int PotencialAtaqueJ2;

    /**
     * 
     */
    private EstrategiaPotencial EstrategiaAtacante;

    /**
     * 
     */
    private EstrategiaPotencial EstrategiaAtacado;

    /**
     * 
     */
    public void reducirSalud() {
        // TODO implement here
    }

    /**
     * @param
     * @return
     */
    public int calcularValorDeAtaque(int potencial) {
        // TODO implement here
        return 0;
    }

    /**
     * @param
     * @return
     */
    public int calcularValorDeDefensa(int potencial) {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public boolean verificarFinCombate() {
        // TODO implement here
        return false;
    }

    /**
     * @param
     */
    public void setEstrategia(EstrategiaPotencial startegy) {
        // TODO implement here
    }
}