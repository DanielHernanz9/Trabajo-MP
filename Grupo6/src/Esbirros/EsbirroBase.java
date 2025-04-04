package Grupo6.src.Esbirros;

import Grupo6.src.COSAS.*;
import Grupo6.src.App.*;
import Grupo6.src.Combate.*;
import Grupo6.src.Desafio.*;
import Grupo6.src.DesafioNotify.*;
import Grupo6.src.Equipo.*;
import Grupo6.src.Esbirros.*;
import Grupo6.src.Personajes.*;
import Grupo6.src.sistemaDeGuardado.*;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;
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