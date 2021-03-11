package ru.nsu.dyuganov.trongame.Controller;

import ru.nsu.dyuganov.trongame.Model.Direction.Direction;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController extends JFrame implements Controller, KeyListener {
    private Thread thread;

    private KeysHandler keysHandler = new KeysHandler();



    @Override
    public Direction getDirection() {
/*        JFrame frame = new KeyboardController();
        this.setSize(1,1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        this.addKeyListener(this);
        thread = new MoveTread(this);
        thread.start();
        if(isDOWN) return Direction.DOWN;
        else if(isUP) return Direction.UP;
        else if(isLEFT) return Direction.LEFT;
        else if(isRIGHT) return Direction.RIGHT;
        else return null;*/
        return null;
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        keysHandler.pressedKey(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keysHandler.releasedKey(e);
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


