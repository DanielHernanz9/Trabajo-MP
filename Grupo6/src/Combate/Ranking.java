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
    private final String route="Grupo6/src/sistemaDeGuardado/Persistencia/Ranking.xml";

    public Ranking() {
        storage=SingleStorage.getInstance();
    }


    public void LoadRanking() {

        ranking = storage.loadFromXML(route);

    }

    public void SaveRanking() {
        storage.saveList(ranking,route);
    }

    public List<Jugador> getRanking() {

        return ranking;
    }

}