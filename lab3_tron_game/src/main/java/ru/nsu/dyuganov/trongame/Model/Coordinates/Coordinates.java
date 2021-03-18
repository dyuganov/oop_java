package ru.nsu.dyuganov.trongame.Model.Coordinates;

import ru.nsu.dyuganov.trongame.Model.Direction.Direction;

/**
 * Stores x, y coordinates. <p>
 * x is width; y is length;
 * */
public class Coordinates {
    private int x = 0;
    private int y = 0;

    /**
     * @param x new x coordinate.
     * @param y new y coordinate.
     * */
    public Coordinates(int x, int y){
        if(x < 0 || y < 0){
            throw new IllegalArgumentException("Coordinates constructor got negative args.");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor
     * */
    public Coordinates(Coordinates other){
        this.x = other.getX();
        this.y = other.getY();
    }

    /**
     * @param val new x coordinate.
     * */
    public void setX(int val){
        if(val < 0){
            throw new IllegalArgumentException("Coordinates.setX(int val) got negative arg.");
        }
        this.x = val;
    }

    /**
     * @param val new y coordinate.
     * */
    public void setY(int val){
        if(val < 0){
            throw new IllegalArgumentException("Coordinates.setY(int val) got negative arg.");
        }
        this.y = val;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    @Override
    public String toString() {
        return "(x: " + x + ", y: " + y + ")";
    }

    public void increaseByDirection(Direction direction){
        if(direction == null){
            throw new IllegalArgumentException("Can't increase coordinates by direction. Direction == null.");
        }
        final int standardOffset = 1;
        _increaseByDirection(direction, standardOffset);
    }

    public void increaseByDirection(Direction direction, final int offset){
        if(direction == null){
            throw new IllegalArgumentException("Can't increase coordinates by direction. Direction == null.");
        }
        _increaseByDirection(direction, offset);
    }

    private void _increaseByDirection(Direction direction, final int offset){
        switch (direction) {
            case RIGHT -> {
                this.x += offset;
            }
            case LEFT -> {
                this.x -= offset;
            }
            case DOWN -> {
                this.y += offset;
            }
            case UP -> {
                this.y -= offset;
            }
        }
    }
}

