package sistemaDeGuardado;

import App.Jugador;
import Combate.Combate;
import Desafio.Desafio;
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