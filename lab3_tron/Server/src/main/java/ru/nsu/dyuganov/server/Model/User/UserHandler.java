package main.java.ru.nsu.dyuganov.server.Model.User;

import java.net.Socket;
import java.util.Objects;


public class UserHandler {
    private int id = 0;
    private Socket clientSocket;

    UserHandler(int id){
        this.id = id;
    }

    UserHandler(int id, Socket clientSocket){
        this.id = id;
        this.clientSocket = clientSocket;
    }

    public void setClientSocket(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserHandler user = (UserHandler) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "UserHandler (" + "id=" + id + "; Socket: " + clientSocket.toString() +')';
    }
}
