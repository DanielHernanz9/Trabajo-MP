package Grupo6.src.Desafio;

import javax.naming.Context;

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
    public abstract void mostrarResultado(Context Context);

    /**
     * @param Context
     */
    public abstract void mostrarNotificacionDesafio(Context Context);

    /*
    Para implementar todo el diseño que hicimos para las notificaciones de desafíos (Observer)
    hace falta que jugador implemente esta interfaz (que ni siquiera está definida como tal, si no como
    clase abstracta) y ya hereda de usuario. Podríamos hacer que la implementase Usuario,
    pero esa ya implementa Serializabale para la persistencia.
    Además, tampoco tengo claro la utilidad que se le puede sacar a esta clase,
    ya que solo heredaría de ella los jugadores (no tiene sentido que más clases se subscriban en nuestro caso)
    así que de momento se queda vacía,
    aunque yo opto más por quitarla directamente y decirlo en el documento.
    La clase ChallengeNotifier si que la he utilizado para quitar responsabilidad al manager
    e implemenatar el patrón.
     */




}