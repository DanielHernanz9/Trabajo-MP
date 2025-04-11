package Grupo6.src.sistemaDeGuardado;
import Grupo6.src.App.Jugador;
import Grupo6.src.App.Usuario;
import Grupo6.src.Combate.Combate;
import Grupo6.src.Desafio.Desafio;

import java.util.ArrayList;

/**
 * El cliente a través de la interfaz no sabe que esta usando un adaptador que traduce de xml a json por ejemplo
 * 
 * SingleStorageAdapter es una clase para gestionar la inserción al archivo xml y además, se pueden agregar más clases de este estilo o metodos en el caso en que queramos traducir de xml a json o otras cosas
 */
public class StorageAdapter implements interfazAlmacen {


    private AlmacenXML Adapter;

    /**
     * Default constructor
     */
    public StorageAdapter() {
        Adapter = new AlmacenXML();
    }


    /**
     *
     */
    public void registrarJugador(Jugador jugador) {
        Adapter.registrarJugador(jugador);
    }

    /**
     *
     */
    public void addFight( Combate combate) {
        // TODO implement here
    }

    public ArrayList<Usuario> loadUsers(){
       return Adapter.loadUsersFromXML();
    }

    public ArrayList<Desafio> loadChallenges(){
        return Adapter.loadChallengesFromXML();
    }

    public void saveList(ArrayList list, String route) {
        Adapter.saveList(list,route);
    }



}