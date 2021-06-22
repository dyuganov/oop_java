package main.java.ru.nsu.dyuganov.tron.GameController;

import main.java.ru.nsu.dyuganov.tron.GUI.GameGUI;
import main.java.ru.nsu.dyuganov.tron.Model.Game.GameModel;

import java.util.concurrent.TimeUnit;

public class GameController implements Runnable { // implements Runnable
    private final GameModel gameModel;
    private final int TIMEOUT_MILS = 500;

    public GameController(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    @Override
    public void run() {
        gameModel.resetGame();
        gameModel.resetScores();
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
            TimeUnit.SECONDS.sleep(1);
        }
    }
}
