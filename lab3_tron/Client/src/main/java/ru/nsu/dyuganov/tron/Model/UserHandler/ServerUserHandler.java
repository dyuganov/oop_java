package main.java.ru.nsu.dyuganov.tron.Model.UserHandler;

import java.net.Socket;
import java.util.Objects;

public class ServerUserHandler {
    private Socket clientSocket;

    public ServerUserHandler(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    public void setClientSocket(Socket clientSocket){
        this.clientSocket = clientSocket;
    }

    public Socket getClientSocket() {
        return clientSocket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServerUserHandler user = (ServerUserHandler) o;
        return clientSocket == user.clientSocket ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientSocket);
    }

}
