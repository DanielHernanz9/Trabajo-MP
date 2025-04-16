package Grupo6.src.Combate;

import Grupo6.src.App.*;
import Grupo6.src.sistemaDeGuardado.SingleStorage;

import java.util.ArrayList;
import java.util.List;

/**
 * //HE PUESTO QUE SOLO HAYA UN OBJETO RANKING, YA QUE DEBERIA DE SER ÚNICO, SE LO PODEMOS INDICAR QUE HEMOS USADO EL PATRON SINGLETON
 */
public class SingleRanking {

    private SingleStorage storage;
    private ArrayList<Jugador> ranking;
    private static SingleRanking instance;

    private SingleRanking() {

        storage=SingleStorage.getInstance();
        LoadRanking();

    }
    //Patron singleton
    public static SingleRanking getInstance() {
        // TODO implement here
        if (instance==null) {
            instance = new SingleRanking();
        }
        return instance;

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