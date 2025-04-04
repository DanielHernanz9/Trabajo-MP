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