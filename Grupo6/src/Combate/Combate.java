package Grupo6.src.Combate;

import Grupo6.src.App.*;
import Grupo6.src.Esbirros.PatronFactoryEsbirros.Esbirro;
import Grupo6.src.Esbirros.EsbirrosComposite;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;
import Grupo6.src.sistemaDeGuardado.SingleStorage;

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * No he usado la estructura completa porque solo va a haber un tipo de combate, sino si que podriamos usar una interfaz como esta en el aula con el director, de todas formas hay que preguntar al profe si asi se puede usar
 * Grupo6.src.Combate.Combate tiene muchos atributos y he intentado con el patron builder evitar hacer un constructor muy grande
 */
public class Combate implements Serializable {
    private Jugador Desafiante;
    private Jugador Desafiado;
    private JuegoCombateManager manager;
    private int NumRondas;
    private Date FechaCombate;
    private Jugador Ganador;
    private int OroGanado;
    private ArrayList<Ronda> Rondas;
    private PersonajeBase PersonajeDesafiante;
    private PersonajeBase PersonajeDesafiado;

    public Combate(){

    }

    public Combate(Jugador desafiante, Jugador desafiado) {
        this.Desafiante = desafiante;
        this.Desafiado = desafiado;
        this.Rondas = new ArrayList<>();
        this.NumRondas = 0;
        this.Ganador = null;
    }

    public void configEsbirroSalud(List<Esbirro> listaEsbirros){
        for (Esbirro esbirro: listaEsbirros){
            esbirro.setSalud(3);
            if (esbirro instanceof EsbirrosComposite){
                List<Esbirro> listaSubordinados = ((EsbirrosComposite) esbirro).getChildren();
                for (Esbirro subordinado: listaSubordinados){
                    configEsbirroSalud(listaSubordinados);
                    //Si los esbirros tienen subordinados, se llama de manera recusriva al metodo
                    //para inicializar la salud de los subordinados y los subordinados de los subordinados, etc.
                }
            }
        }
    }

    public Jugador IniciarCombate() {
        if (Desafiante != null && Desafiado != null) {
            //manager.registrarCombate(this);

            System.out.println("Iniciando combate entre " + Desafiante.getNombre() + " y " + Desafiado.getNombre());

            Personaje personajeDesafiado = Desafiado.getPersonaje();
            Personaje personajeDesafiante = Desafiante.getPersonaje();

            //Por algún motivo se sobreescriben los datos de los personajes en el xml al registrarlos,
            //así que inicializo aquí su salud en lugar del constructor. De todos modos tiene más sentido hacerlo
            //así para que puedan tener el máxmimo de salud (5 según el enunciado) al comenzar el combate.

            personajeDesafiado.initializePersonaje();
            personajeDesafiante.initializePersonaje();

            if (personajeDesafiado.hasEsbirros()){
                configEsbirroSalud(personajeDesafiado.getEsbirros());
            }

            if (personajeDesafiante.hasEsbirros()){
                configEsbirroSalud(personajeDesafiante.getEsbirros());
            }

            Ronda newRonda = null;
            int numeroRonda = 1;
            boolean swapper = false; //Esta variable va alternando en cada ronda.

            //Segun sea true o false, el peronaje atacante sera uno u otro
            //Consideramos que el primero en atacar es el personaje del jugador desafiante.

            while (newRonda == null || !newRonda.verificarFinCombate()){

                if (swapper){
                    newRonda = new Ronda(personajeDesafiado, personajeDesafiante,numeroRonda);
                }
                else{
                    newRonda = new Ronda(personajeDesafiante, personajeDesafiado, numeroRonda);
                }

                Rondas.add(newRonda);
                newRonda.ejecutarRonda();
                swapper = !swapper;
                numeroRonda += 1;
            }
            if (personajeDesafiado.getSalud() == 0){
                Ganador = Desafiante;
                Ganador.increaseNumCombatesGanados();
                Desafiado.increaseNumCombatesPerdidos();
            }
            else if (personajeDesafiante.getSalud() == 0){
                Ganador = Desafiado;
                Ganador.increaseNumCombatesGanados();
                Desafiante.increaseNumCombatesPerdidos();

            }
            //Actualizamos los valores de los usuarios en el XML
            ArrayList<Usuario> usuarios = new ArrayList<>();
            SingleStorage storage=SingleStorage.getInstance();
            usuarios=storage.loadUsers();

            //actualizamos los campos de los usuarios que hayan combatido
            for (int i = 0; i < usuarios.size(); i++){

                Usuario actualUser = usuarios.get(i);

                if (actualUser instanceof Jugador) {
                    if (actualUser.getNombre().equals(Desafiado.getNombre())) {
                        usuarios.set(i, Desafiado);
                    } else if (actualUser.getNombre().equals(Desafiante.getNombre())) {
                        usuarios.set(i, Desafiante);
                    }
                }
            }
            //Actualizamos los valores de los usuarios en el XML
            storage.saveList(usuarios,"Grupo6/src/sistemaDeGuardado/Persistencia/Usuarios.xml");

            //Tras haber actualizado esos valores, se debe de actualizar el ranking
            SingleRanking ranking= SingleRanking.getInstance();
            ranking.updateRanking();

            return Ganador;

        } else {
            System.out.println("No se han registrado suficientes jugadores.");
            return null;
        }
    }

    /**
     * Guarda el combate en la lista y la serializa.
     */
    public void registrar(){
        SingleStorage storage = SingleStorage.getInstance();
        ArrayList <Combate> listaCombate = storage.loadCombatesFromXML();
        listaCombate.add(this);
        storage.saveList(listaCombate, "Grupo6/src/sistemaDeGuardado/Persistencia/Combates.xml");
        System.out.println("Combate entre "  + Desafiante.getNombre() + " y " + Desafiado.getNombre() + " registrado.");
    }

    public void mostrarResultado(){
        System.out.println("¡La victoria es para " + Ganador.getNombre() + "!");
    }

    public JuegoCombateManager getManager() {
        return manager;
    }

    public int getNumRondas() {
        return NumRondas;
    }

    public Date getFechaCombate() {
        return FechaCombate;
    }

    public Jugador getGanador() {
        return Ganador;
    }

    public int getOroGanado() {
        return OroGanado;
    }

    public ArrayList<Ronda> getRondas() {
        return Rondas;
    }

    public PersonajeBase getPersonajeDesafiante() {
        return PersonajeDesafiante;
    }

    public PersonajeBase getPersonajeDesafiado() {
        return PersonajeDesafiado;
    }

    public void setDesafiante(Jugador desafiante) {
        Desafiante = desafiante;
    }

    public void setDesafiado(Jugador desafiado) {
        Desafiado = desafiado;
    }

    public void setManager(JuegoCombateManager manager) {
        this.manager = manager;
    }

    public void setNumRondas(int numRondas) {
        NumRondas = numRondas;
    }

    public void setFechaCombate(Date fechaCombate) {
        FechaCombate = fechaCombate;
    }

    public void setOroGanado(int oroGanado) {
        OroGanado = oroGanado;
    }

    public void setGanador(Jugador ganador) {
        Ganador = ganador;
    }

    public void setRondas(ArrayList<Ronda> rondas) {
        Rondas = rondas;
    }

    public void setPersonajeDesafiante(PersonajeBase personajeDesafiante) {
        PersonajeDesafiante = personajeDesafiante;
    }

    public void setPersonajeDesafiado(PersonajeBase personajeDesafiado) {
        PersonajeDesafiado = personajeDesafiado;
    }

    public Jugador getDesafiante() {
        return Desafiante;
    }

    public Jugador getDesafiado() {
        return Desafiado;
    }

    public Jugador Ganador(){
        return Ganador;
    }
}