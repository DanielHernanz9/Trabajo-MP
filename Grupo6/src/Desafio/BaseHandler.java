package Grupo6.src.Desafio;

import Grupo6.src.COSAS.*;
import Grupo6.src.App.*;
import Grupo6.src.Combate.*;
import Grupo6.src.Desafio.*;
import Grupo6.src.Equipo.*;
import Grupo6.src.Esbirros.*;
import Grupo6.src.Personajes.*;
import Grupo6.src.sistemaDeGuardado.*;
import Grupo6.src.Personajes.PatronFactoryPersonajes.*;

public abstract class BaseHandler {
    private Handler next;
    public void setNext(Handler handler){
        //TODO logic here
    }
    public abstract void handle(Request request);
}
