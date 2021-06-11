package main.java.ru.nsu.dyuganov.server;

import main.java.ru.nsu.dyuganov.server.Model.Game.GameModel;
import main.java.ru.nsu.dyuganov.server.Model.User.UserList;

public class Server {
    public static void main(String[] args) {

        UserList userList= new UserList();
        GameModel gameModel = new GameModel(userList);



    }
}
