package Grupo6.src.sistemaDeGuardado;
import Grupo6.src.App.Jugador;
import Grupo6.src.Combate.Combate;

/**
 * El cliente a través de la interfaz no sabe que esta usando un adaptador que traduce de xml a json por ejemplo
 * 
 * SingleStorageAdapter es una clase para gestionar la inserción al archivo xml y además, se pueden agregar más clases de este estilo en el caso en que queramos traducir de xml a json o otras cosas
 */
public class StorageAdapterJson implements interfazAlmacen {

    /**
     * Default constructor
     */
    public StorageAdapterJson() {
    }

    /**
     * 
     */
    private AlmacenXML Adapter;

    /**
     * @param UserInfo user
     */
    public void registrarUsuario( Jugador jugador) {
        // TODO implement here
    }

    /**
     * @param Combate combate
     */
    public void addFight( Combate combate) {
        // TODO implement here
    }

    /**
     * @param Usuario User 
     * @return
     */



}