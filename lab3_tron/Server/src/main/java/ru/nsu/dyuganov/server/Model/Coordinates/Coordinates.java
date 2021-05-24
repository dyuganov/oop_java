package main.java.ru.nsu.dyuganov.server.Model.Coordinates;

import main.java.ru.nsu.dyuganov.server.Model.Direction.Direction;

import java.util.Objects;

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
    public Coordinates(final int x, final int y){
        if(x < 0 || y < 0){
            throw new IllegalArgumentException("Coordinates constructor got negative args.");
        }
        this.x = x;
        this.y = y;
    }

    /**
     * Copy constructor
     * */
    public Coordinates(final Coordinates other){
        this.x = other.getX();
        this.y = other.getY();
    }

    /**
     * @param newX new x coordinate.
     * */
    public void setX(final int newX){
        if(newX < 0){
            throw new IllegalArgumentException("Coordinates.setX(int newX) got negative arg.");
        }
        this.x = newX;
    }

    /**
     * @param newY new y coordinate.
     * */
    public void setY(final int newY){
        if(newY < 0){
            throw new IllegalArgumentException("Coordinates.setY(int newY) got negative arg.");
        }
        this.y = newY;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public void increaseByDirection(final Direction direction){
        if(direction == null){
            throw new IllegalArgumentException("Can't increase coordinates by direction. Direction == null.");
        }
        final int standardOffset = 1;
        _increaseByDirection(direction, standardOffset);
    }

    public void increaseByDirection(final Direction direction, final int offset){
        if(direction == null){
            throw new IllegalArgumentException("Can't increase coordinates by direction. Direction == null.");
        }
        _increaseByDirection(direction, offset);
    }

    private void _increaseByDirection(final Direction direction, final int offset){
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

