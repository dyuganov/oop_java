package ru.nsu.dyuganov.trongame.View;

import ru.nsu.dyuganov.trongame.Model.Direction.Direction;


public interface UI {
    void draw();
    Direction getDirection(int id);
}
