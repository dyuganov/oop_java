package main.java.ru.nsu.dyuganov.tron.GameController;

import main.java.ru.nsu.dyuganov.tron.GUI.GameGUI;
import main.java.ru.nsu.dyuganov.tron.Model.Game.GameModel;

import java.util.concurrent.TimeUnit;

public class GameController implements Runnable { // implements Runnable
    private final GameModel gameModel;
    private final GameGUI GUI;
    private int TIMEOUT_MILS = 500;

    public GameController(GameModel gameModel, GameGUI gui) {
        this.gameModel = gameModel;
        this.GUI = gui;
    }

    @Override
    public void run() {
        gameModel.registerObserver(GUI);
        gameModel.resetGame();
        gameModel.notifyObservers();
        try {
            waitForUsersConnected();
            while (!gameModel.isGameEnd()) {
                gameModel.makeStep();
                gameModel.notifyObservers();
                TimeUnit.MILLISECONDS.sleep(TIMEOUT_MILS); // can be used timer
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        gameModel.resetGame();
        gameModel.resetScores();
    }

    private void waitForUsersConnected() throws InterruptedException {
        while(gameModel.getUserList().getSize() < 2){
            wait();
        }
    }
}
