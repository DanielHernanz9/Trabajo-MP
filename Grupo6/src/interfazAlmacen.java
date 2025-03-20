
import java.io.*;
import java.util.*;

/**
 * 
 */
public abstract class interfazAlmacen {

    /**
     * Default constructor
     */
    public interfazAlmacen() {
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