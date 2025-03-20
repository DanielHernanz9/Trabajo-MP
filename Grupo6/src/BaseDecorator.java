
import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class BaseDecorator extends Pantalla {

    /**
     * Default constructor
     */
    public BaseDecorator() {
    }

    /**
     * 
     */
    private Pantalla wraped;

    /**
     * 
     */
    public void show() {
        // TODO implement here
    }

    /**
     * @param int 
     * @return
     */
    public Pantalla getNext(void int) {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void executeOption() {
        // TODO implement here
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