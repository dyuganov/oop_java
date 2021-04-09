package ru.nsu.dyuganov.trongame.Contoller;

import ru.nsu.dyuganov.trongame.Model.GameModel.GameModel;

/**
 * Changes game model
 * */
public class GraphicalController implements Controller, Runnable {
    GameModel gameModel = null;

    public GraphicalController(GameModel gameModel){
        this.gameModel = gameModel;
    }

    @Override
    public void run() {
        // ... gets info from GUI and changes model
    }
}
