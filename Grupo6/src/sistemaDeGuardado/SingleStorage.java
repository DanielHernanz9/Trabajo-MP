package Grupo6.src.sistemaDeGuardado;
import Grupo6.src.Personajes.PatronFactoryPersonajes.Personaje;

/**
 * 
 */
public class SingleStorage {

    /**
     * Default constructor
     */
    public SingleStorage() {
    }

    /**
     * 
     */
    private static SingleStorage Instance;

    /**
     * 
     */
    private SingleStorage() {
        // TODO implement here
    }

    /**
     * @return
     */
    public static SingleStorage getInstance() {
        // TODO implement here
        return null;
    }

    /**
     * @param UserInfo user
     */
    public void registrarUsuario(UserInfo user) {
        // TODO implement here
    }

    /**
     * @param Usuario User 
     * @return
     */
    public Personaje loadCharacterFromUser(Usuario User) {
        // TODO implement here
        return null;
    }

}