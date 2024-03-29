package main.java.ru.nsu.dyuganov.server.ServerCommunicator.ServerHandler;

import main.java.ru.nsu.dyuganov.server.User.UserList;
import main.java.ru.nsu.dyuganov.server.ServerCommunicator.ThreadPool.ThreadPool;

import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;

public class ServerHandler implements Runnable{
    private UserList userList;

    public ServerHandler(UserList userList){
        this.userList = userList;
    }

    @Override
    public void run() {
        ThreadPool threadPool = new ThreadPool(getThreadPoolSize());
        threadPool.start();

        ServerSocket serverSocket;
        //
        threadPool.shutdown();
    }

    private int getThreadPoolSize(){
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/main/resources/gamesettings.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Integer.parseInt(properties.getProperty("threadPoolSize"));
    }


}
