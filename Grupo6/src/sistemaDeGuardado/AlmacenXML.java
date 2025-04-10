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

    private File XMLCombates = new File("src/sistemaDeGuardado/Combates.xml");
    private File XMLjugadores = new File("src/sistemaDeGuardado/Jugadores.xml");
    private File XMLUsuarios = new File("Grupo6/src/sistemaDeGuardado/Usuarios.xml");
    private File XMLDesafios = new File("Grupo6/src/sistemaDeGuardado/Desafios.xml");
    /**
     * Default constructor
     */
    public AlmacenXML() {
    }


    public void registrarUsuario(Usuario user) {
        // TODO implement here
        try(XMLEncoder encoder = new XMLEncoder
                (new BufferedOutputStream(new FileOutputStream(XMLjugadores)))) {
            encoder.writeObject(user);
        }
        catch(FileNotFoundException ignorar){

        }
    }

    @Override
    public void registrarJugador(Jugador jugador) {

    }

    /**
     * @param
     */
    public void addFight( Combate combate) {
        // TODO implement here
            try(XMLEncoder encoder = new XMLEncoder
                    (new BufferedOutputStream(new FileOutputStream(XMLCombates)))) {
                encoder.writeObject(combate);
            }
            catch(FileNotFoundException ignorar){

        }


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
                FileOutputStream output = new FileOutputStream("Grupo6/src/sistemaDeGuardado/Usuarios.xml");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return usuarios;
    }

    public ArrayList<Desafio>  loadChallengesFromXML(){
        ArrayList<Desafio> desafios = new ArrayList<>();
        try {
            XMLDecoder decoder = new XMLDecoder(
                    new BufferedInputStream(new FileInputStream(XMLDesafios))
            );
            if (XMLDesafios.length() > 0){
                //Sacamos los usuarios del archivo XML
                desafios = (ArrayList<Desafio>) decoder.readObject();

                //Cerramos el decoder
                decoder.close();
            }
            //Si no encontramos un archivo lo creamos
            else{
                FileOutputStream output = new FileOutputStream("Grupo6/src/sistemaDeGuardado/Desafios.xml");
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return desafios;
    }

    //Metodo para guardar usuarios en el archivo XML
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