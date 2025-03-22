package Grupo6.src.Desafio;

public interface Handler {
    public void setNext(Handler H);
    public void handle(Request request);
}
