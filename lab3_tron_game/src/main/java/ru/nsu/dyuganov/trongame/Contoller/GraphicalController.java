package ru.nsu.dyuganov.trongame.Contoller;

import ru.nsu.dyuganov.trongame.Model.Direction.Direction;
import ru.nsu.dyuganov.trongame.Model.GameModel.GameModel;

import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Changes game model
 * */
public class GraphicalController implements Controller, Runnable {
    GameModel gameModel = null;
    Map<Integer, Direction> actualDirections = new HashMap<>();

    public GraphicalController(GameModel gameModel){
        this.gameModel = gameModel;
    }

    @Override
    public void run() {
        // ... gets info from GUI and changes model
    }

    @Override
    public void handleKey(KeyEvent e, int userId) {
        Direction actualDirection = getDirectionByKey(e);
        actualDirections.put(userId, actualDirection);
    }

    private Direction getDirectionByKey(KeyEvent e){
        return switch (e.getKeyCode()) {
            case KeyEvent.VK_W -> Direction.UP;
            case KeyEvent.VK_S -> Direction.DOWN;
            case KeyEvent.VK_A -> Direction.LEFT;
            case KeyEvent.VK_D -> Direction.RIGHT;
            default -> null;
        };
    }
}
