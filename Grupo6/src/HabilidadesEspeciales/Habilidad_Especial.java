package Grupo6.src.HabilidadesEspeciales;

/**
 * 
 */
public abstract class Habilidad_Especial {

    protected String Nombre;
    protected int ValorAtaque;
    protected int ValorDefensa;

    public int getAtaque(){
        return this.ValorAtaque;
    }

    public int getDefensa(){
        return this.ValorDefensa;
    }

    public abstract void ejecutarHabilidad();

    public int getValorAtaque() {
        return ValorAtaque;
    }

    public String getNombre() {
        return Nombre;
    }

    public int getValorDefensa() {
        return ValorDefensa;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public void setValorAtaque(int valorAtaque) {
        ValorAtaque = valorAtaque;
    }

    public void setValorDefensa(int valorDefensa) {
        ValorDefensa = valorDefensa;
    }
}