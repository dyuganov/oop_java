package main.java.ru.nsu.dyuganov.tron.GUI;

import main.java.ru.nsu.dyuganov.tron.KeyController.KeyController;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyListener implements KeyListener {
    KeyController keyController;
    GameKeyListener(KeyController keyController){
        this.keyController = keyController;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        keyController.handleKey(e);
    }
    @Override
    public void keyPressed(KeyEvent e) {
        keyController.handleKey(e);
    }
    @Override
    public void keyReleased(KeyEvent e) {}
}
