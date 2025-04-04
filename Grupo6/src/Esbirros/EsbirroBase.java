package Grupo6.src.Esbirros;

/**
 * 
 */
public abstract class EsbirroBase extends Esbirro {

    /**
     * 
     */
    private String Nombre;

    /**
     * 
     */
    private int Salud = 3;

    /**
     * Default constructor, no se deberia instanciar este
     */
    public EsbirroBase(String Nombre) {
        this.Nombre = Nombre;
    }

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