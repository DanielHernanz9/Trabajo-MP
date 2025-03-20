
import java.io.*;
import java.util.*;

/**
 * 
 */
public class AlmacenXML extends interfazAlmacen {

    /**
     * Default constructor
     */
    public AlmacenXML() {
    }

    /**
     * 
     */
    private String RutaXMLUsuario;

    /**
     * 
     */
    private String RutaXMLCombate;

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