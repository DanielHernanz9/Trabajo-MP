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

    private SingleStorage() {

    }


    public static SingleStorage getInstance() {
        // TODO implement here
        if (Instance==null) {
            Instance = new SingleStorage();
        }
            return Instance;

    }


    public void registrarUsuario(Usuario user) {
       interfazAlmacen almacenAdapter= new StorageAdapter();
       almacenAdapter.registrarUsuario(user);
    }

    public Personaje loadCharacterFromUser(Usuario User) {
        // TODO implement here
        return null;
    }

    public ArrayList<Usuario> loadUsers(){
        interfazAlmacen almacenAdapter= new StorageAdapter();

        return ((StorageAdapter) almacenAdapter).loadUsers();
    }
    public void saveUsers(ArrayList<Usuario> Users) {
        interfazAlmacen almacenAdapter= new StorageAdapter();
        ((StorageAdapter) almacenAdapter).saveUsers(Users);

    }

}