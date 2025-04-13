package Grupo6.src.Combate;

import Grupo6.src.App.*;
import Grupo6.src.sistemaDeGuardado.SingleStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Ranking {
    private SingleStorage storage;
    private ArrayList<Jugador> ranking;

    public Ranking() {
        storage=SingleStorage.getInstance();
    }


    private void LoadRanking() {

        ranking = storage.loadRanking();

    }

    public void SaveRanking() {
        storage.saveList(ranking,"Grupo6/src/sistemaDeGuardado/Persistencia/Ranking.xml");
    }

    public List<Jugador> getRanking() {

        return ranking;
    }
    public void showRanking(){
        //ArrayList<Usuario> r=storage.loadUsers();
        int i=1;
        for (Usuario jugador:ranking){
            System.out.println(i+". "+jugador.getNombre());
            i++;
        }
    }

}