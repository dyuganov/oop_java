package ru.nsu.dyuganov.trongame.Controller;

import java.awt.event.KeyEvent;

public class KeysHandler {
    private boolean isUP = false;
    private boolean isDOWN = false;
    private boolean isLEFT = false;
    private boolean isRIGHT = false;

    public void pressedKey(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> isUP = true;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> isLEFT = true;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> isDOWN = true;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> isRIGHT = true;
        }
    }

    public void releasedKey(KeyEvent e){
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W, KeyEvent.VK_UP -> isUP = false;
            case KeyEvent.VK_A, KeyEvent.VK_LEFT -> isLEFT = false;
            case KeyEvent.VK_S, KeyEvent.VK_DOWN -> isDOWN = false;
            case KeyEvent.VK_D, KeyEvent.VK_RIGHT -> isRIGHT = false;
        }
    }
}
