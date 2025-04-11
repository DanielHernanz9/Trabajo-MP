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


    public static SingleStorage getInstance() {
        // TODO implement here
        if (Instance==null) {
            Instance = new SingleStorage();
        }
            return Instance;

    }

    public Personaje loadCharacterFromUser(Usuario User) {
        // TODO implement here
        return null;
    }

    public ArrayList<Usuario> loadUsers(){
        return ((StorageAdapter) almacenAdapter).loadUsers();
    }

    public ArrayList<Desafio> loadChallenges(){

        return ((StorageAdapter) almacenAdapter).loadChallenges();
    }

    public void saveList(ArrayList Users, String route) {
        ((StorageAdapter) almacenAdapter).saveList(Users, route);

    }
    public ArrayList<Jugador> loadFromXML(String ruta){
        return ((StorageAdapter) almacenAdapter).loadFromXML(ruta);
    }

}