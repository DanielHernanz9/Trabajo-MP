package Combate;

import App.*;
import sistemaDeGuardado.SingleStorage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * //HE PUESTO QUE SOLO HAYA UN OBJETO RANKING, YA QUE DEBERIA DE SER ÚNICO, SE LO PODEMOS INDICAR QUE HEMOS USADO EL PATRON SINGLETON
 */
public class SingleRanking {

    private final SingleStorage storage;
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
        ranking = storage.getPlayers();
        Collections.sort(ranking);

        //lo guardamos en el XML del ranking
        SaveRanking();
    }

    private void SaveRanking() {

        storage.saveList(ranking,"src/main/java/sistemaDeGuardado/Persistencia/Ranking.xml");
    }

    public List<Jugador> getRanking() {
        return ranking;
    }

    public void showRanking(){

        String dorado  = "\u001B[93m";
        String plata = "\u001B[38;5;252m";
        String bronce = "\u001B[38;5;208m";
        String azul = "\u001B[38;5;153m";
        String reset = "\u001B[0m";

        System.out.println("RANKING GLOBAL ACTUALMENTE: ");
        System.out.println();
        int i=1;
        for (Jugador jugador:ranking){
            int combatesDisputados=jugador.getNumCombatesGanados()+jugador.getNumCombatesPerdidos();

            if (i==1) System.out.println(dorado+i+"º "+"\uD83E\uDD47 "+jugador.getNombre()+", ha ganado el "+jugador.getPorcentajeCombatesGanados() +"% total de los "+combatesDisputados+" combates que ha disputado"+reset);

            else if(i==2) System.out.println(plata+i+"º "+"\uD83E\uDD48 "+jugador.getNombre()+", ha ganado el "+jugador.getPorcentajeCombatesGanados() +"% total de los "+combatesDisputados+" combates que ha disputado"+reset);

            else if (i==3) System.out.println(bronce+i+"º "+"\uD83E\uDD49 "+jugador.getNombre()+", ha ganado el "+jugador.getPorcentajeCombatesGanados() +"% total de los "+combatesDisputados+" combates que ha disputado"+reset);

            else System.out.println(azul+i+"º "+jugador.getNombre()+", ha ganado el "+jugador.getPorcentajeCombatesGanados() +"% total de los "+combatesDisputados+" combates que ha disputado"+reset);

            i++;
        }
    }

}