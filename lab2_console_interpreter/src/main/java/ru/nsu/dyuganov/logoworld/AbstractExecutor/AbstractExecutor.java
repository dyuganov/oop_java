package ru.nsu.dyuganov.logoworld.AbstractExecutor;

import ru.nsu.dyuganov.logoworld.Coordinates.Coordinates;


/**
 * Abstract executor for LogoWorld
 */
public interface AbstractExecutor {
    void move(Direction direction);
    void teleport(Coordinates coords);
    void draw();
    void ward();
    boolean isDrawing();
    Coordinates getCoordinates();
    void setCoordinates(Coordinates coordinates);
}
