package main.java.ru.nsu.dyuganov.server.Model.Bike;

import main.java.ru.nsu.dyuganov.server.Model.Coordinates.Coordinates;
import main.java.ru.nsu.dyuganov.server.Model.Direction.Direction;

public class Bike {
    /**
     (0,0)--> width(x)<p>
     |<p>
     v length(y)
     */
    Coordinates bikeCoordinates;

    public Bike(final Coordinates newBikeCoordinates){
        this.bikeCoordinates = new Coordinates(newBikeCoordinates);
    }

    public void setCoordinates(final Coordinates newBikeCoordinates){
        bikeCoordinates = new Coordinates(newBikeCoordinates);
    }

    public void move(Direction moveBikeDirection){
        bikeCoordinates.increaseByDirection(moveBikeDirection);
    }
}