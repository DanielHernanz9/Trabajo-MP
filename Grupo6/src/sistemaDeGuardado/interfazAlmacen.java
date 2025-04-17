package Grupo6.src.sistemaDeGuardado;
import Grupo6.src.App.Jugador;
import Grupo6.src.Combate.Combate;
import Grupo6.src.Desafio.Desafio;
import Grupo6.src.Personajes.PatronFactoryPersonajes.Personaje;

import java.util.ArrayList;


public interface interfazAlmacen {

    public abstract void registrarJugador(Jugador jugador);

    public abstract void saveList(ArrayList list, String route);

    public abstract ArrayList<Jugador> loadRanking();

    public abstract ArrayList<Combate>  loadCombatesFromXML();

    public  abstract ArrayList<Desafio> loadPendingChallenges();

    public abstract ArrayList<Desafio> loadChallenges();

    public abstract ArrayList<Jugador> getPlayers();
}