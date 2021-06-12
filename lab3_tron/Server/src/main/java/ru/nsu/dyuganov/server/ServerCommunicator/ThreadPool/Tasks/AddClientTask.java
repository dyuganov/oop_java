package main.java.ru.nsu.dyuganov.server.ServerCommunicator.ThreadPool.Tasks;

import main.java.ru.nsu.dyuganov.server.User.UserHandler;
import main.java.ru.nsu.dyuganov.server.User.UserList;

import java.io.*;
import java.net.Socket;

public class AddClientTask implements ThreadPoolTask{
    private Socket clientSocket;
    private UserList userList;

    AddClientTask(Socket clientSocket, UserList userList){
        this.clientSocket = clientSocket;
        this.userList = userList;
    }

    @Override
    public void execute() throws IOException {
        int userId = userList.add(new UserHandler(clientSocket));
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

        out.write(userId);

    }
}
