package ru.nsu.dyuganov.trongame.Contoller;

import ru.nsu.dyuganov.trongame.Model.Direction.Direction;

import java.awt.event.KeyEvent;

public interface Controller {
    void handleKey(KeyEvent e, int userId);

}
