package Grupo6.src.Desafio;


public abstract class BaseHandler {
    private Handler next;
    public void setNext(Handler handler){
        //TODO logic here
    }
    public abstract void handle(Request request);
}
