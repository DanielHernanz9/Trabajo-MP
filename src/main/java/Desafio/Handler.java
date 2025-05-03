package Desafio;

public interface Handler {
    public void setNext(Handler H);
    public void handle(Request request);
}
