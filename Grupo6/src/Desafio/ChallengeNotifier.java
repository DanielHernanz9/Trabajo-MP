package Grupo6.src.Desafio;

import Grupo6.src.App.Jugador;
import Grupo6.src.App.Usuario;
import Grupo6.src.sistemaDeGuardado.SingleStorage;

import java.util.ArrayList;

public class ChallengeNotifier {

    private ArrayList<Usuario> subscribers;

    public ChallengeNotifier() {
        subscribers = new ArrayList<>();
    }

    public void subscribe(Usuario sub) {
        this.subscribers.add(sub);
    }

    public void unSuscribe(Usuario sub) {
        this.subscribers.remove(sub);
    }

    public void notifySubscriber(Jugador sub) {
        SingleStorage storage = SingleStorage.getInstance();
        subscribers = storage.loadSubscribers();
        Jugador jugador = null;
        boolean found = false;
        int i = 0;
        while (!found && i < subscribers.size()){
            jugador = (Jugador) subscribers.get(i);
            if (jugador.getRegNum().equals(sub.getRegNum())){
                found = true;
            }
            i++;
        }
        if (found){
            ArrayList<Desafio> listaDesafio = sub.getDesafiosPendientes();
            int length = listaDesafio.size();
            if (length == 1){
                System.out.println("¡Tienes " + length + " desafio pendiente!");
            }
            else{
                System.out.println("¡Tienes " + length + " desafios pendientes!");
            }
        }
    }

    public ArrayList<Usuario> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(ArrayList<Usuario> subscribers) {
        this.subscribers = subscribers;
    }
}