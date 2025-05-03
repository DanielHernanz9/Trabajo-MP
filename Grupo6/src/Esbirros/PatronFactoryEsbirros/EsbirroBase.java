package Grupo6.src.Esbirros.PatronFactoryEsbirros;

public abstract class EsbirroBase implements Esbirro,Cloneable{

    protected String Nombre;
    private int Salud = 3;

    /**
     * Reduce un punto de salud
     * @return la salud resultante
     */
    @Override
    public int recibirDaño(){
        if(Salud - 1 >= 0){      //Vamos a cosiderar que la vida no puede ser negativa
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

    @Override
    public EsbirroBase clone() {
        try {
            EsbirroBase clone = (EsbirroBase) super.clone();

            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}