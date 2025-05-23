package sistemaDeGuardado;

import App.Jugador;
import App.Usuario;
import Combate.Combate;
import Desafio.Desafio;
import java.beans.XMLDecoder;
import java.io.*;
import java.beans.XMLEncoder;
import java.util.ArrayList;
import java.util.Collections;

public class AlmacenXML implements interfazAlmacen {

    private final File XMLCombates = new File("src/main/java/sistemaDeGuardado/Persistencia/Combates.xml");
    private final File XMLUsuarios = new File("src/main/java/sistemaDeGuardado/Persistencia/Usuarios.xml");
    private final File XMLDesafiosPendientes = new File("src/main/java/sistemaDeGuardado/Persistencia/DesafiosPendientes.xml");
    private final File XMLDesafios = new File("src/main/java/sistemaDeGuardado/Persistencia/DesafiosPorValidar.xml");
    private final File XMLRanking= new File("src/main/java/sistemaDeGuardado/Persistencia/Ranking.xml");
    private final File XMLSubscribers = new File("src/main/java/sistemaDeGuardado/Persistencia/Subscriptores.xml");

    public AlmacenXML() {
    }

    @Override
    public void registrarJugador(Jugador jugador) {

    }

    public ArrayList<Usuario>  loadUsersFromXML(){
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            XMLDecoder decoder = new XMLDecoder(
                    new BufferedInputStream(new FileInputStream(XMLUsuarios))
            );
            if (XMLUsuarios.length() > 0){
                //Sacamos los usuarios del archivo XML
                usuarios = (ArrayList<Usuario>) decoder.readObject();

                //Cerramos el decoder
                decoder.close();
            }
            //Si no encontramos un archivo lo creamos
            else{
                FileOutputStream output = new FileOutputStream("src/main/java/sistemaDeGuardado/Persistencia/Usuarios.xml");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    @Override
    public ArrayList<Desafio> loadPendingChallenges() {
        ArrayList<Desafio> desafios = new ArrayList<>();
        try {
            XMLDecoder decoder = new XMLDecoder(
                    new BufferedInputStream(new FileInputStream(XMLDesafiosPendientes)
                    ));
            if (XMLDesafiosPendientes.length() > 0){
                //Sacamos los usuarios del archivo XML
                desafios = (ArrayList<Desafio>) decoder.readObject();

                //Cerramos el decoder
                decoder.close();
            }
            //Si no encontramos un archivo lo creamos
            else{
                FileOutputStream output = new FileOutputStream(XMLDesafiosPendientes);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return desafios;
    }

    @Override
    public ArrayList<Desafio> loadChallenges() {
        ArrayList<Desafio> desafios = new ArrayList<>();
        try {
            XMLDecoder decoder = new XMLDecoder(
                    new BufferedInputStream(new FileInputStream(XMLDesafios)
                    ));
            if (XMLDesafios.length() > 0){
                //Sacamos los usuarios del archivo XML
                desafios = (ArrayList<Desafio>) decoder.readObject();

                //Cerramos el decoder
                decoder.close();
            }
            //Si no encontramos un archivo lo creamos
            else{
                FileOutputStream output = new FileOutputStream(XMLDesafios);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return desafios;
    }

    public ArrayList<Jugador>  loadRanking(){
        ArrayList<Jugador> jugadores;
        try {
            XMLDecoder decoder = new XMLDecoder(
                    new BufferedInputStream(new FileInputStream(XMLRanking)
                    ));
            if (XMLRanking.length() > 0){
                //Sacamos los usuarios del archivo XML
                jugadores = (ArrayList<Jugador>) decoder.readObject();

                //Cerramos el decoder
                decoder.close();
            }
            //Si no encontramos un archivo lo creamos y creamos un ranking
            else{
                FileOutputStream output = new FileOutputStream(XMLRanking);

                //Filtramos los jugadores del archivo XML
                jugadores=getPlayers();

                //Con compareTo de la clase jugador se ordenan por el porcentaje de combates ganados
                Collections.sort(jugadores);

                //Guardamos el ranking actual en el archivo
                saveList(jugadores,"src/main/javasistemaDeGuardado/Persistencia/Ranking.xml");

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return jugadores;
    }

    public ArrayList<Combate> loadCombatesFromXML(){
        ArrayList<Combate> Combate = new ArrayList<>();
        try {
            XMLDecoder decoder = new XMLDecoder(
                    new BufferedInputStream(new FileInputStream(XMLCombates)
                    ));
            if (XMLCombates.length() > 0){
                //Sacamos los usuarios del archivo XML
                Combate = (ArrayList<Combate>) decoder.readObject();

                //Cerramos el decoder
                decoder.close();
            }
            //Si no encontramos un archivo lo creamos
            else{
                FileOutputStream output = new FileOutputStream(XMLCombates);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return Combate;
    }

    public ArrayList<Usuario> loadSubscribers(){
        ArrayList<Usuario> subs = new ArrayList<>();
        try {
            XMLDecoder decoder = new XMLDecoder(
                    new BufferedInputStream(new FileInputStream(XMLSubscribers)
                    ));
            if (XMLSubscribers.length() > 0){
                //Sacamos los usuarios del archivo XML
                subs = (ArrayList<Usuario>) decoder.readObject();

                //Cerramos el decoder
                decoder.close();
            }
            //Si no encontramos un archivo lo creamos
            else{
                FileOutputStream output = new FileOutputStream(XMLSubscribers);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return subs;
    }

    /**
     * METODO PARA GUARDAR LISTAS EN UN ARCHIVO XML
     */
    public void saveList(ArrayList list, String route) {
        //Vaciamos el fichero para evitar duplicados
        try{
            FileOutputStream fos = new FileOutputStream(route);

            XMLEncoder encoder = new XMLEncoder(
                    new BufferedOutputStream(fos));
            encoder.writeObject(list);
            encoder.close();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Jugador> getPlayers(){
        ArrayList<Jugador> jugadores = new ArrayList<>();
        ArrayList<Usuario> usuarios = loadUsersFromXML();
        //usuarios.remove(0); //Eliminamos el primer usuario de la lista, que es el administrador

        //agregamos los jugadores a la lista de jugadores
        for (Usuario usuario : usuarios){
            if (usuario instanceof Jugador){
                jugadores.add((Jugador) usuario);
            }
        }
        return jugadores;
    }

}