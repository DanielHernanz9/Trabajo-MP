package sistemaDeGuardado;

import Personajes.Personaje;

/**
 * 
 */
public interface interfazAlmacen {



    /**
     * @param UserInfo user
     */
    public abstract void registrarUsuario( UserInfo user);

    /**
     * @param Combate combate
     */
    public abstract void addFight( Combate combate);

    /**
     * @param Usuario User 
     * @return
     */
    public Personaje loadCharacterFromUser(Usuario User);

}

/**LOS ERRORES QUE SE MUESTRAN EN ESTA CLASE SE DEBEN A QUE HAY QUE IMPORTAR CLASES COMO USUARIO,COMBATE, ETC...
 *
 * CREAR PAQUETES EN LOS QUE ORGANIZAR LA ESTRUCTURA DEL SISTEMA
 */