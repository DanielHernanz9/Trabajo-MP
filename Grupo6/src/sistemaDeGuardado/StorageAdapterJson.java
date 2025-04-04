package Grupo6.src.sistemaDeGuardado;

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


    public void registrarUsuario( Usuario user) {
        // TODO implement here
    }


    public void addFight( Combate combate) {
        // TODO implement here
    }


    public Personaje loadCharacterFromUser(Usuario User) {
        // TODO implement here
        return null;
    }


    private void registrarUsuarioDesdeJson(Usuario user) {
        // TODO implement here
    }


    private void addFightFromJson(Combate combate) {
        // TODO implement here
    }




}