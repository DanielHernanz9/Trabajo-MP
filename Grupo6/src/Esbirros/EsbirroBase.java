package Grupo6.src.Esbirros;

/**
 * 
 */
public abstract class EsbirroBase extends Esbirro {

    /**
     * Default constructor, no se deberia instanciar este
     */
    public EsbirroBase() {
    }

    /**
     * 
     */
    private String Nombre;

    /**
     * 
     */
    private int Salud;

    /**
     * Conviene implementar aquí el metodo recibir daño ya que es comun para todos
     * tambien conviene implementar los getters y setters de los atributos comunes
     * @return
     */
    public int recibirDaño(){
        Salud--;
        return Salud;
    }
    public int getSalud(){
        return Salud;
    }
    public void setSalud(int salud){
        Salud = salud;
    }
}