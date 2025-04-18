package Grupo6.src.sistemaDeGuardado;

import Grupo6.src.COSAS.*;
import Grupo6.src.App.*;
import Grupo6.src.Combate.*;
import Grupo6.src.Desafio.*;
import Grupo6.src.Equipo.*;
import Grupo6.src.Esbirros.*;
import Grupo6.src.Personajes.*;
import Grupo6.src.sistemaDeGuardado.*;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;

import java.util.ArrayList;

/**
 *
 */
public class SingleStorage {

    private static SingleStorage Instance;
    private interfazAlmacen almacenAdapter;

    private SingleStorage() {
        almacenAdapter= new StorageAdapter();
    }

    //Patron singleton
    public static SingleStorage getInstance() {
        // TODO implement here
        if (Instance==null) {
            Instance = new SingleStorage();
        }
            return Instance;

    }

    public ArrayList<Usuario> loadUsers(){
        return ((StorageAdapter) almacenAdapter).loadUsers();
    }

    public ArrayList<Desafio> loadChallenges(){
        return ((StorageAdapter) almacenAdapter).loadChallenges();
    }
    public ArrayList<Desafio> loadPendingChallenges(){
        return  almacenAdapter.loadPendingChallenges();
    }

    public void saveList(ArrayList list, String route) {
         almacenAdapter.saveList(list, route);

    }

    public  ArrayList<Jugador> loadRanking(){
        return almacenAdapter.loadRanking();
    }

    public  ArrayList<Combate>  loadCombatesFromXML(){
        return  almacenAdapter.loadCombatesFromXML();
    }

    public  ArrayList<Usuario>  loadSubscribers(){
        return ((StorageAdapter) almacenAdapter).loadSubscribers();
    }

    public ArrayList<Jugador> getPlayers(){
        return almacenAdapter.getPlayers();
    }

}