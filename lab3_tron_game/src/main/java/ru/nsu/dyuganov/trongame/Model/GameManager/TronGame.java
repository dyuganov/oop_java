package ru.nsu.dyuganov.trongame.Model.GameManager;

import ru.nsu.dyuganov.trongame.Contoller.Controller;
import ru.nsu.dyuganov.trongame.Contoller.GraphicalController;
import ru.nsu.dyuganov.trongame.Model.GameModel.GameModel;
import ru.nsu.dyuganov.trongame.View.GUI;


// настройка
public class TronGame implements Runnable {
    public TronGame(){}

    /**
     * Creates all game elements. Links them.
     * */
    @Override
    public void run() {
        System.out.println("Running game thread");
        final int fieldWidth = 100;
        final int fieldLength = 100;
        GameModel game = new GameModel(fieldWidth, fieldLength);
        Controller controller = new GraphicalController();
        GUI GUI = new GUI();
        Thread window = new Thread(GUI);
        window.start();
        System.out.println("Game thread finished");
    }
}
