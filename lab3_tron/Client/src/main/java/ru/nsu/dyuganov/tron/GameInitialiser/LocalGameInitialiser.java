package main.java.ru.nsu.dyuganov.tron.GameInitialiser;

import main.java.ru.nsu.dyuganov.tron.GUI.GameGUI;
import main.java.ru.nsu.dyuganov.tron.GameController.GameController;
import main.java.ru.nsu.dyuganov.tron.KeyController.KeyController;
import main.java.ru.nsu.dyuganov.tron.Model.Game.GameModel;
import main.java.ru.nsu.dyuganov.tron.Model.UserController.BotController;
import main.java.ru.nsu.dyuganov.tron.Model.UserController.UserLocalController;
import main.java.ru.nsu.dyuganov.tron.Model.UserList;

public class LocalGameInitialiser implements GameInitialiser {
    private final GameGUI gameGUI;
    private final KeyController keyController;

    public LocalGameInitialiser(GameGUI gameGUI, KeyController keyController){
        this.gameGUI = gameGUI;
        this.keyController = keyController;
    }

    @Override
    public void start() {
        UserList userList = new UserList();
        initUserList(userList, gameGUI.getBotsNum(), keyController);
        GameModel gameModel = new GameModel(userList);
        gameModel.registerObserver(gameGUI);
        gameModel.notifyObservers();
        notify();

        Thread controllerThread = new Thread(new GameController(gameModel));
        controllerThread.start();
        try {
            controllerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private synchronized void initUserList(UserList userList, int botsNum, KeyController keyController) {
        userList.clearAll();
        userList.add(new UserLocalController(keyController));
        for (int i = 0; i < botsNum; ++i) {
            userList.add(new BotController());
        }
    }
}
