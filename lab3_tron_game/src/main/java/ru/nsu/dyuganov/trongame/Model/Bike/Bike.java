package ru.nsu.dyuganov.trongame.Model.Bike;

import ru.nsu.dyuganov.trongame.Model.Color.Color;
import ru.nsu.dyuganov.trongame.Model.Coordinates.Coordinates;
import ru.nsu.dyuganov.trongame.Model.Direction.Direction;

public class Bike {
    private final Coordinates coordinates;
    private Color color;
    private Trace trace; // новая точка добавляется только если меняется направление движения
    private Direction prevMoveDirection;

    public Bike(int x, int y){
        coordinates = new Coordinates(x, y);
        trace = new Trace();
        trace.addPoint(new Coordinates(coordinates.getX(), coordinates.getY()));
    }

    // (0,0)--> (x)
    //   |
    //   v (y)
    void move(Direction direction) {
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

    void setColor(Color color){
        this.color = color;
    }
}
