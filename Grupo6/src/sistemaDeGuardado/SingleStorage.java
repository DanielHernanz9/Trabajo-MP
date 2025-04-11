package Grupo6.src.sistemaDeGuardado;

import Grupo6.src.App.*;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;

import java.util.ArrayList;

/**
 *
 */
public class SingleStorage {

    private static SingleStorage Instance;

    private SingleStorage() {

    }


    public static SingleStorage getInstance() {
        // TODO implement here
        if (Instance==null) {
            Instance = new SingleStorage();
        }
            return Instance;

    }

    //Este metodo de momento no se usa porque usamos el de saveUsers
    public void registrarUsuario(Jugador jugador) {
       interfazAlmacen almacenAdapter= new StorageAdapter();
       almacenAdapter.registrarJugador(jugador);
    }

    public Personaje loadCharacterFromUser(Usuario User) {
        // TODO implement here
        return null;
    }

    //Obtener usuarios de disco
    public ArrayList<Usuario> loadUsers(){
        interfazAlmacen almacenAdapter= new StorageAdapter();

        return ((StorageAdapter) almacenAdapter).loadUsers();
    }

    //guardar usuarios en disco
    public void saveUsers(ArrayList<Usuario> Users) {
        interfazAlmacen almacenAdapter= new StorageAdapter();
        ((StorageAdapter) almacenAdapter).saveUsers(Users);

    }

}