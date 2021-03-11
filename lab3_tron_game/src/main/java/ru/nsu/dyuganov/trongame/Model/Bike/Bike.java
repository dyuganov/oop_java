package ru.nsu.dyuganov.trongame.Model.Bike;

import ru.nsu.dyuganov.trongame.Model.Color.Color;
import ru.nsu.dyuganov.trongame.Model.Coordinates.Coordinates;
import ru.nsu.dyuganov.trongame.Model.Direction.Direction;

public class Bike {
    private final Coordinates coordinates;
    private Trace trace; // новая точка добавляется только если меняется направление движения
    private Direction prevMoveDirection;
    private final int id;

    public Bike(int x, int y, int id){
        coordinates = new Coordinates(x, y);

        trace = new Trace();
        trace.addPoint(new Coordinates(coordinates.getX(), coordinates.getY()));
        this.id = id;
    }

    public Bike(final Coordinates coordinates, final int id){
        this.coordinates = new Coordinates(coordinates);
        trace = new Trace();
        trace.addPoint(new Coordinates(coordinates.getX(), coordinates.getY()));
        this.id = id;
    }

    // (0,0)--> (x)
    //   |
    //   v (y)
    public void move(Direction direction) {
        if(direction.isOpposite(prevMoveDirection)){
            direction = prevMoveDirection;
        }
        switch (direction) {
            case RIGHT -> {
                coordinates.setX(coordinates.getX() + 1);
            }
            case LEFT -> {
                coordinates.setX(coordinates.getX() - 1);
            }
            case DOWN -> {
                coordinates.setY(coordinates.getY() + 1);
            }
            case UP -> {
                coordinates.setY(coordinates.getY() - 1);
            }
        }
        if(direction != prevMoveDirection){
            trace.addPoint(new Coordinates(coordinates.getX(), coordinates.getY()));
            prevMoveDirection = direction;
        }
    }
}
