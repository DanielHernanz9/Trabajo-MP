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

}