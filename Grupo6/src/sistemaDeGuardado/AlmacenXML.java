package Grupo6.src.sistemaDeGuardado;
import Grupo6.src.App.Jugador;
import Grupo6.src.App.Usuario;
import Grupo6.src.Combate.Combate;
import Grupo6.src.Desafio.Desafio;

import java.beans.XMLDecoder;
import java.io.*;
import java.beans.XMLEncoder;
import java.util.ArrayList;

/**
 *
 */
public class AlmacenXML implements interfazAlmacen {

    private File XMLCombates = new File("Grupo6/src/sistemaDeGuardado/Persistencia/Combates.xml");
    private File XMLUsuarios = new File("Grupo6/src/sistemaDeGuardado/Persistencia/Usuarios.xml");
    private File XMLDesafiosPendientes = new File("Grupo6/src/sistemaDeGuardado/Persistencia/DesafiosPendientes.xml");
    private File XMLDesafios = new File("Grupo6/src/sistemaDeGuardado/Persistencia/DesafiosPorValidar.xml");
    private File XMLRanking= new File("Grupo6/src/sistemaDeGuardado/Persistencia/Ranking.xml");
    private File XMLSubscribers = new File("Grupo6/src/sistemaDeGuardado/Persistencia/Subscriptores.xml");

    /**
     * Default constructor
     */
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
                FileOutputStream output = new FileOutputStream("Grupo6/src/sistemaDeGuardado/Persistencia/Usuarios.xml");
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
        ArrayList<Jugador> jugador = new ArrayList<>();
        try {
            XMLDecoder decoder = new XMLDecoder(
                    new BufferedInputStream(new FileInputStream(XMLRanking)
                    ));
            if (XMLRanking.length() > 0){
                //Sacamos los usuarios del archivo XML
                jugador = (ArrayList<Jugador>) decoder.readObject();

                //Cerramos el decoder
                decoder.close();
            }
            //Si no encontramos un archivo lo creamos
            else{
                FileOutputStream output = new FileOutputStream(XMLRanking);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return jugador;
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

}