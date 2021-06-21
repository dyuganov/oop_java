package main.java.ru.nsu.dyuganov.tron;

import main.java.ru.nsu.dyuganov.tron.GUI.GameGUI;
import main.java.ru.nsu.dyuganov.tron.GameController.GameController;
import main.java.ru.nsu.dyuganov.tron.KeyController.KeyController;
import main.java.ru.nsu.dyuganov.tron.Model.Game.GameModel;
import main.java.ru.nsu.dyuganov.tron.Model.UserController.BotController;
import main.java.ru.nsu.dyuganov.tron.Model.UserController.UserLocalController;
import main.java.ru.nsu.dyuganov.tron.Model.UserList;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        KeyController keyController = new KeyController();

        GameGUI gameGUI = new GameGUI(keyController);
        gameGUI.run();

        UserList userList = new UserList();

        initUserList(userList, 3, keyController);

        Thread controllerThread = new Thread(new GameController(new GameModel(userList), gameGUI));
        controllerThread.start();
        controllerThread.join();
    }

    private static synchronized void initUserList(UserList userList, int botsNum, KeyController keyController){
        userList.clearAll();
        userList.add(new UserLocalController(keyController));
        for (int i = 0; i < botsNum; ++i){
            userList.add(new BotController());
        }
    }
}
