package Grupo6.src.Combate;

import Grupo6.src.App.*;
import Grupo6.src.sistemaDeGuardado.SingleStorage;

import java.util.ArrayList;
import java.util.Collections;
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
    public void updateRanking(){
        //cargamos los jugadores del XML y reordenamos el ranking
        ranking=storage.getPlayers();
        Collections.sort(ranking);

        //lo guardamos en el XML del ranking
        SaveRanking();
    }

    private void SaveRanking() {

        storage.saveList(ranking,"Grupo6/src/sistemaDeGuardado/Persistencia/Ranking.xml");
    }

    public List<Jugador> getRanking() {

        return ranking;
    }
    public void showRanking(){

        System.out.println("RANKING GLOBAL ACTUALMENTE: ");
        System.out.println();
        int i=1;
        for (Jugador jugador:ranking){
            int combatesDisputados=jugador.getNumCombatesGanados()+jugador.getNumCombatesPerdidos();
            System.out.println(i+"º "+jugador.getNombre()+", ha ganado el "+jugador.getPorcentajeCombatesGanados() +"% total de los "+combatesDisputados+" combates que ha disputado");
            i++;
        }
    }

}