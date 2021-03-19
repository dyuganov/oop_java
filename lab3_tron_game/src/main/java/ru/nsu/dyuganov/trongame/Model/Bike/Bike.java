package ru.nsu.dyuganov.trongame.Model.Bike;

import ru.nsu.dyuganov.trongame.Model.Coordinates.Coordinates;
import ru.nsu.dyuganov.trongame.Model.Direction.Direction;

public class Bike {
    // (0,0)--> width(x)
    //   |
    //   v length(y)
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
