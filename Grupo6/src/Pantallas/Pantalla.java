package Grupo6.src.Pantallas;

/**
 * 
 */
public abstract class Pantalla {

    /**
     * Default constructor
     */
    public Pantalla() {
    }

    /**
     * 
     */
    public abstract void show();

    /**
     * @param int 
     * @return
     */
    public abstract Pantalla getNext(void int);

    /**
     * @param int
     */
    public abstract void executeOption(void int);

}