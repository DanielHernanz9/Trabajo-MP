package Grupo6.src.App;

import Grupo6.src.Desafio.*;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;

import java.util.ArrayList;
import java.util.Random;

public class Jugador extends Usuario {

    private int NumeroRegistro;
    private FactoryPersonaje FabricaPersonaje;
    private ArrayList<Desafio> DesafiosPendientes;
    private int [] HistorialOro;
    private Personaje Personaje;

    //Numero de registro, solo lo tienen los jugadores y es unico para cada jugador
    private String RegNum;

    /**
     * Default constructor
     */
    public Jugador() {

    }

    public void registrarDatos(String nick, String nombre, String password, int regsitro){
        this.Nombre = nombre;
        this.Nick = String.valueOf(this.hashCode());
        this.Password = password;
        this.NumeroRegistro = 0;
    }

    private String setRegNumber(){
        Random random= new Random();
        StringBuilder regnum= new StringBuilder();

        //construimos el formato LNNLL
        regnum.append((char) ('A' + random.nextInt(26)));
        regnum.append(random.nextInt(10));
        regnum.append(random.nextInt(10));
        regnum.append((char) ('A' + random.nextInt(26)));
        regnum.append((char) ('A' + random.nextInt(26)));

        return regnum.toString();


    }

    public String getNombre(){
        return this.Nombre;
    }

    public String getRegNum(){
        return this.RegNum;
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

    public Personaje getPersonaje(){
        return this.Personaje;
    }

    public void setPersonaje(Personaje p){
        this.Personaje = p;
    }

    public void setNick(String nick){
        this.Nick = nick;
    }

    /**
     * @param
     */
    public void registrarPersonaje(FactoryPersonaje factory) {
        Personaje = factory.createPersonaje();
    }

    /**
     * 
     */
    public void darDeBajaPersonaje() {
        Personaje = null;
    }

    /**
     * @param
     */
    public void desafiarUsuario(Desafio desafio) {
        // TODO implement here
    }

    /**
     * @param
     */
    public void aceptarDesafio(Desafio desafio) {
        // TODO implement here
    }

    /**
     * @param
     */
    public void rechazarDesafio(Desafio desafio) {
        // TODO implement here
    }

    /**
     * 
     */
    public void consultarHistorial() {
        // TODO implement here
    }

    /**
     * @param
     */
    public void mostrarNotificacionDesafio() {
        // TODO implement here
        // De momento he quitado el contexto que se le pasaba a estos metodos porque no sabemos exactamente qué
        //datos necesitamos pasar a este metodo.
    }

    /**
     * @param
     */
    public void mostrarResultado() {
        // TODO implement here
    }

    /**
     * 
     */
    public void mostrarNotificacionBloqueo() {
        // TODO implement here
    }

    /**
     * 
     */
    public void mostrarNotificacionDesbloqueo() {
        // TODO implement here
    }

    // Getter para DesafiosPendientes
    public ArrayList<Desafio> getDesafiosPendientes() {
        return this.DesafiosPendientes;
    }
}