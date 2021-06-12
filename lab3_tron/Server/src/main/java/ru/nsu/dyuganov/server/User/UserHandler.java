package main.java.ru.nsu.dyuganov.server.User;

import java.net.Socket;
import java.util.Objects;


public class UserHandler {
    private Socket clientSocket;
    // user info

    public UserHandler(Socket clientSocket){
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
        UserHandler user = (UserHandler) o;
        return clientSocket == user.clientSocket;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientSocket);
    }

}
