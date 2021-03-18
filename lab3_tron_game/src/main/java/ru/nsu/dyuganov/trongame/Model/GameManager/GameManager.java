package ru.nsu.dyuganov.trongame.Model.GameManager;

import ru.nsu.dyuganov.trongame.Model.Coordinates.Coordinates;
import ru.nsu.dyuganov.trongame.Model.Direction.Direction;


/**
 * Tron game manager. Can work with different View and Controllers.
 * */
public interface GameManager {
    // Get Model info (for View)
    /** Get number of active users */
    int getPlayersNum();

    /** Array of trace core points */
    Coordinates[] getTrace(int id);

    /** Coordinates of bike with this id */
    Coordinates getBikeCoordinates(int id);

    /** Get all available player id */
    int[] getPlayersId();

    // Change Model (for Controller)
    /** Move bike with ID to 1 cell in DIRECTION */
    void moveBike(Direction direction, int id);
    // ...
}
