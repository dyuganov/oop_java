package main.java.ru.nsu.dyuganov.tron.KeyController;

import main.java.ru.nsu.dyuganov.tron.Model.Direction.Direction;

import java.awt.event.KeyEvent;

public class KeyController {
    private Direction currentDirection = Direction.RIGHT;

    public KeyController(){}

    public KeyController(Direction defaultDirection){
        this.currentDirection = defaultDirection;
    }

    public synchronized void handleKey(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_D -> currentDirection = Direction.RIGHT;
            case KeyEvent.VK_A -> currentDirection = Direction.LEFT;
            case KeyEvent.VK_S -> currentDirection = Direction.DOWN;
            case KeyEvent.VK_W -> currentDirection = Direction.UP;
        }
    }

    public synchronized Direction getCurrentDirection(){
        return currentDirection;
    }
}
