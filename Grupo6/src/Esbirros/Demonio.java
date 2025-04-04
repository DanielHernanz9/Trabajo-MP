package Grupo6.src.Esbirros;

/**
 * 
 */
public class Demonio extends EsbirroBase {

    /**
     * Default constructor
     */
    public Demonio(String Nombre, String Pacto) {
        super(Nombre);
        this.Pacto = Pacto;
    }

    /**
     * 
     */
    private String Pacto;

    /**
     * 
     */
    private EsbirrosComposite Subordinados;

}