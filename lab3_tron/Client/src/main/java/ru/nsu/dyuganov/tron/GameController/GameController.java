package main.java.ru.nsu.dyuganov.tron.GameController;

import main.java.ru.nsu.dyuganov.tron.GUI.GameGUI;
import main.java.ru.nsu.dyuganov.tron.Model.Game.GameModel;

import java.util.concurrent.TimeUnit;

public class GameController { // implements Runnable
    private GameModel gameModel;
    private GameGUI GUI;

    GameController(GameModel gameModel, GameGUI gui){
        this.gameModel = gameModel;
        this.GUI = gui;
    }

    public void run() throws InterruptedException {
        gameModel.registerObserver(GUI);
        gameModel.resetGame();
        while(!gameModel.isGameEnd()){
            gameModel.makeStep();
            gameModel.notifyObservers();
            TimeUnit.MILLISECONDS.sleep(500); // can be used timer
        }

        gameModel.resetGame();
    }

    private void pauseGame(){

    }


}
