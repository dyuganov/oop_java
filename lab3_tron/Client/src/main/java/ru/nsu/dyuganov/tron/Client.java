package main.java.ru.nsu.dyuganov.tron;

import main.java.ru.nsu.dyuganov.tron.GUI.GameGUI;
import main.java.ru.nsu.dyuganov.tron.GameInitialiser.GameInitialiser;
import main.java.ru.nsu.dyuganov.tron.GameInitialiser.LocalGameInitialiser;
import main.java.ru.nsu.dyuganov.tron.KeyController.KeyController;

import java.util.concurrent.TimeUnit;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        KeyController keyController = new KeyController();

        GameGUI gameGUI = new GameGUI(keyController);
        gameGUI.run();


        GameInitialiser gameInitialiser;
        while(true){
            if(gameGUI.isLocalGame()){
                gameInitialiser = new LocalGameInitialiser(gameGUI, keyController);
                break;
            }
            if(gameGUI.isServerGame()){
                break;
            }
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
