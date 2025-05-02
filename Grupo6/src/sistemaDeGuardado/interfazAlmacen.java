package Grupo6.src.sistemaDeGuardado;
import Grupo6.src.App.Jugador;
import Grupo6.src.Combate.Combate;
import Grupo6.src.Desafio.Desafio;

import java.util.ArrayList;


public interface interfazAlmacen {

    void registrarJugador(Jugador jugador);

    void saveList(ArrayList list, String route);

    ArrayList<Jugador> loadRanking();

    ArrayList<Combate>  loadCombatesFromXML();

    ArrayList<Desafio> loadPendingChallenges();

    ArrayList<Desafio> loadChallenges();

    ArrayList<Jugador> getPlayers();
}