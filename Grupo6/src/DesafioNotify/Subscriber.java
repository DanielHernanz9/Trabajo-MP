package Grupo6.src.DesafioNotify;

/**
 * 
 */
public abstract class Subscriber {

    /**
     * Default constructor
     */
    public Subscriber() {
    }

    /**
     * @param Context
     */
    public abstract void mostrarResultado(void Context);

    /**
     * @param Context
     */
    public abstract void mostrarNotificacionDesafio(void Context);

}