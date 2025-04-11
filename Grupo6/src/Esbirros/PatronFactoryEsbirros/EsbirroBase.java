package Grupo6.src.Esbirros.PatronFactoryEsbirros;

public abstract class EsbirroBase implements Esbirro {

    protected String Nombre;
    private int Salud = 3;

    /**
     * Conviene implementar aquí el metodo recibir daño ya que es comun para todos
     * tambien conviene implementar los getters y setters de los atributos comunes
     * @return
     */

    public int recibirDaño(){
        if(Salud - 1 < 0){      //Vamos a cosiderar que la vida no puede ser negativa
            Salud--;
        }
        return Salud;
    }

    public int getSalud(){
        return Salud;
    }
    public void setSalud(int salud){
        Salud = salud;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }
}