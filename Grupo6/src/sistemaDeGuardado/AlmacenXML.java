package Grupo6.src.sistemaDeGuardado;
import Grupo6.src.Combate.Combate;
import Grupo6.src.App.Jugador;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

/**
 * 
 */
public class AlmacenXML implements interfazAlmacen {

    /**
     * Default constructor
     */
    public AlmacenXML() {
    }

    /**
     * 
     */
    private File XMLCombates = new File("src/sistemaDeGuardado/Combates.xml");


    /**
     * 
     */
    private File XMLJugadores = new File("src/sistemaDeGuardado/Jugadores.xml");;


    public void registrarUsuario(Jugador jugador) {
        // TODO implement here
        try(XMLEncoder encoder = new XMLEncoder
                (new BufferedOutputStream(new FileOutputStream(XMLJugadores)))) {
            encoder.writeObject(jugador);
        }
        catch(FileNotFoundException ignorar){

        }
    }

    /**
     * @param
     */
    public void addFight( Combate combate) {
        // TODO implement here
            try(XMLEncoder encoder = new XMLEncoder
                    (new BufferedOutputStream(new FileOutputStream(XMLCombates)))) {
                encoder.writeObject(combate);
            }
            catch(FileNotFoundException ignorar){

        }


    }

    /**
     * @param Usuario User 
     * @return
     */


}
    /**
     * @param UserInfo user
     */
