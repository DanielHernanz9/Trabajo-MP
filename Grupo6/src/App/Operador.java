package Grupo6.src.App;

import Grupo6.src.Desafio.*;

/**
 * 
 */
public class Operador extends Usuario {

    private Handler ValidadorDesafio;

    /**
     * Default constructor
     */
    public Operador() {
        super();

    }

    public void registrarDatos(String nick, String nombre, String password){
        this.Nombre = nombre;
        this.Nick = String.valueOf(this.hashCode());
        this.Password = password;
    }

    public String getNombre(){
        return this.Nombre;
    }

    public String getNick(){
        return this.Nick;
    }

    public String getPassword(){
        return this.Password;
    }

    public void setNombre(String name){
        this.Nombre = name;
    }

    public void setPassword(String password){
        this.Password = password;
    }

    public void setNick(String nick){
        this.Nick = nick;
    }

    public Boolean validarDesafio(Desafio Desafio) {
        // TODO implement here
        return null;
    }

    /**
     * @param Jugador
     */
    public void editarPersonaje(Jugador Jugador) {
        // TODO implement here
    }

    /**
     * @param Jugador
     */
    public void bloquearUsuario(Jugador Jugador) {
        // TODO implement here
    }

    /**
     * @param Jugador
     */
    public void desbloquearUsuario(Jugador Jugador) {
        // TODO implement here
    }


}