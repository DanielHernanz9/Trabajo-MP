package Grupo6.src.sistemaDeGuardado;
import Grupo6.src.App.Jugador;
import Grupo6.src.App.Usuario;
import Grupo6.src.Combate.Combate;

import java.util.ArrayList;


public interface interfazAlmacen {

    public abstract void registrarJugador(Jugador jugador);

    public abstract void addFight(Combate combate);

    public  abstract void saveList(ArrayList list, String route);

    public abstract ArrayList<Jugador> loadFromXML(String ruta);


}