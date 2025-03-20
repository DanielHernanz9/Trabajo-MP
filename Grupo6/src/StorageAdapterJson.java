
import java.io.*;
import java.util.*;

/**
 * El cliente a través de la interfaz no sabe que esta usando un adaptador que traduce de xml a json por ejemplo
 * 
 * SingleStorageAdapter es una clase para gestionar la inserción al archivo xml y además, se pueden agregar más clases de este estilo en el caso en que queramos traducir de xml a json o otras cosas
 */
public class StorageAdapterJson extends interfazAlmacen {

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
    public void registrarUsuario(void UserInfo user) {
        // TODO implement here
    }

    /**
     * @param Combate combate
     */
    public void addFight(void Combate combate) {
        // TODO implement here
    }

    /**
     * @param Usuario User 
     * @return
     */
    public Personaje loadCharacterFromUser(void Usuario User) {
        // TODO implement here
        return null;
    }

    /**
     * @param UserInfo user
     */
    private void registrarUsuarioDesdeJson(void UserInfo user) {
        // TODO implement here
    }

    /**
     * @param Combate combate
     */
    private void addFightFromJson(void Combate combate) {
        // TODO implement here
    }

    /**
     * @param UserInfo user
     */
    public abstract void registrarUsuario(void UserInfo user);

    /**
     * @param Combate combate
     */
    public abstract void addFight(void Combate combate);

    /**
     * @param Usuario User 
     * @return
     */
    public abstract Personaje loadCharacterFromUser(void Usuario User);

}