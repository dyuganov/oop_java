package main.java.ru.nsu.dyuganov.tron.Model.Bike;

import main.java.ru.nsu.dyuganov.tron.Model.Coordinates.Coordinates;
import main.java.ru.nsu.dyuganov.tron.Model.Direction.Direction;

public class Bike {
    /**
     (0,0)--> width(x)<p>
     |<p>
     v length(y)
     */
    Coordinates bikeCoordinates;
    //Trace trace = new Trace();

    public Bike(final Coordinates newBikeCoordinates){
        this.bikeCoordinates = new Coordinates(newBikeCoordinates);
    }

    public void setCoordinates(final Coordinates newBikeCoordinates){
        bikeCoordinates = new Coordinates(newBikeCoordinates);
    }

    public Coordinates getCoordinates(){
        return bikeCoordinates;
    }

    public void move(Direction moveBikeDirection){
        bikeCoordinates.increaseByDirection(moveBikeDirection);
        //trace.addPoint(bikeCoordinates);
    }
}