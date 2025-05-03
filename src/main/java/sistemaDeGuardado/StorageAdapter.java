package sistemaDeGuardado;

import App.Jugador;
import App.Usuario;
import Combate.Combate;
import Desafio.Desafio;
import java.util.ArrayList;

/**
 * El cliente a través de la interfaz no sabe que esta usando un adaptador que traduce de xml a json por ejemplo
 * SingleStorageAdapter es una clase para gestionar la inserción al archivo xml y además, se pueden agregar más clases de este estilo o metodos en el caso en que queramos traducir de xml a json o otras cosas
 */
public class StorageAdapter implements interfazAlmacen {


    private final AlmacenXML Adapter;

    public StorageAdapter() {
        Adapter = new AlmacenXML();
    }

    public void registrarJugador(Jugador jugador) {
        Adapter.registrarJugador(jugador);
    }

    public ArrayList<Usuario> loadUsers(){
       return Adapter.loadUsersFromXML();
    }

    public ArrayList<Desafio> loadChallenges(){
        return Adapter.loadChallenges();
    }

    @Override
    public ArrayList<Jugador> getPlayers() {
        return Adapter.getPlayers();
    }

    public ArrayList<Desafio> loadPendingChallenges(){
        return Adapter.loadPendingChallenges();
    }

    public  ArrayList<Jugador> loadRanking(){
        return Adapter.loadRanking();
    }

    @Override
    public ArrayList<Combate> loadCombatesFromXML() {
        return Adapter.loadCombatesFromXML();
    }

    public void saveList(ArrayList list, String route) {

        Adapter.saveList(list,route);
    }

    public  ArrayList<Usuario> loadSubscribers(){
        return Adapter.loadSubscribers();
    }

}