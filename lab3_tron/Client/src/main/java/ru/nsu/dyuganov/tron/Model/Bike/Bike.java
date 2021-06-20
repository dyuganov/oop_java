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
    Trace trace = new Trace();
    Direction prevMoveDirection = Direction.RIGHT;
    boolean isActive = true;

    public Bike(final Coordinates newBikeCoordinates){
        this.bikeCoordinates = new Coordinates(newBikeCoordinates);
        trace.addPoint(newBikeCoordinates);
    }

    public boolean isActive(){
        return isActive;
    }

    public void setActive(boolean val){
        this.isActive = val;
    }

    public void setCoordinates(final Coordinates newBikeCoordinates){
        bikeCoordinates = new Coordinates(newBikeCoordinates);
        //trace.clear();
        //trace.addPoint(newBikeCoordinates);
    }

    public Coordinates getCoordinates(){
        return bikeCoordinates;
    }

    public void move(final Direction moveBikeDirection){
        bikeCoordinates.increaseByDirection(moveBikeDirection);
        trace.addPoint(bikeCoordinates);
        prevMoveDirection = moveBikeDirection;
    }

    public Trace getTrace(){
        return trace;
    }

    public void resetTrace(){
        trace.clear();
        trace.addPoint(bikeCoordinates);
        prevMoveDirection = Direction.RIGHT;
    }

    public Direction getPrevMoveDirection(){
        return prevMoveDirection;
    }
}