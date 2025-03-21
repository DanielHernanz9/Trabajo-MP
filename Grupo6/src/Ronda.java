
import Personajes.PersonajeBase;

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
     * @param int potencial 
     * @return
     */
    public int calcularValorDeAtaque(void int potencial) {
        // TODO implement here
        return 0;
    }

    /**
     * @param int potencial 
     * @return
     */
    public int calcularValorDeDefensa(void int potencial) {
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
     * @param EstrategiaPotencial
     */
    public void setEstrategia(void EstrategiaPotencial) {
        // TODO implement here
    }

}