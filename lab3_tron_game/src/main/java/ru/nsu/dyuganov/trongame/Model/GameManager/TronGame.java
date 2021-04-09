package ru.nsu.dyuganov.trongame.Model.GameManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.nsu.dyuganov.trongame.Contoller.Controller;
import ru.nsu.dyuganov.trongame.Contoller.GraphicalController;
import ru.nsu.dyuganov.trongame.Model.GameModel.GameModel;
import ru.nsu.dyuganov.trongame.View.GUI;

// setup game params and run game
public class TronGame implements Runnable {
    private final static Logger logger = LogManager.getLogger(TronGame.class);
    public TronGame(){
        DOMConfigurator.configure("src/main/resources/ru.nsu.dyuganov.trongame/log4j/log4j.xml");
    }

    /**
     * Creates all game elements. Links them.
     * */
    @Override
    public void run() {
        final int fieldWidth = 100;
        final int fieldLength = 100;
        GameModel gameModel = new GameModel(fieldWidth, fieldLength);
        Controller controller = new GraphicalController(gameModel);
        GUI GUI = new GUI(controller);
        gameModel.subscribe(GUI);
        Thread window = new Thread(GUI);
        window.start();



    }
}
