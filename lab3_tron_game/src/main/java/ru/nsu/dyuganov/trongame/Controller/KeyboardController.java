package ru.nsu.dyuganov.trongame.Controller;

import ru.nsu.dyuganov.trongame.Model.Direction.Direction;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController implements Controller, KeyListener {
    private Thread thread;

    private boolean isUP = false;
    private boolean isDOWN = false;
    private boolean isLEFT = false;
    private boolean isRIGHT = false;


    @Override
    public Direction getDirection() {
        thread = new MoveTread(this);
        thread.start();
        if(isDOWN) return Direction.DOWN;
        else if(isUP) return Direction.UP;
        else if(isLEFT) return Direction.LEFT;
        else if(isRIGHT) return Direction.RIGHT;
        else return null;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> isUP = true;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> isLEFT = true;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> isDOWN = true;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> isRIGHT = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        isUP = false;
        isLEFT = false;
        isDOWN = false;
        isRIGHT = false;
    }


    private class MoveTread extends Thread{
        KeyboardController keyboardController;

        public MoveTread(KeyboardController keyboardController){
            super("MoveThread");
            this.keyboardController = keyboardController;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


