package ru.nsu.Dyuagnov.LogoWorld.Executor;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;


/**
 * Abstract executor for LogoWorld
 */
public interface Executor {
    void move(Direction direction);
    void teleport(Coordinates coords);
    Coordinates draw();
    void ward();
    boolean isDrawing();
    Coordinates getCoordinates();
    void setCoordinates(Coordinates coordinates);
}
