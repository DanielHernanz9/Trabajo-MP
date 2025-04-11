package Grupo6.src.Esbirros.PatronFactoryEsbirros;

/**
 * 
 */
public abstract class FabricaEsbirros {

    /**
     * Default constructor
     */
    public FabricaEsbirros() {
    }

    /**
     * @return
     */

    public abstract Esbirro createEsbirro(String Nombre);

}