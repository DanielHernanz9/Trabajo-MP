package Grupo6.src.sistemaDeGuardado;
import Grupo6.src.App.Jugador;
import Grupo6.src.App.Usuario;
import Grupo6.src.Combate.Combate;

/**
 * 
 */
public interface interfazAlmacen {
    /**
     * @param
     */
    public abstract void registrarUsuario(Usuario user);

    /**
     * @param
     */
    public abstract void addFight(Combate combate);

    /**
     * @param
     * @return
     */

}