package ru.nsu.dyuganov.logoworld.Coordinates;

/**
 * Stores x, y coordinates.
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
     * @param val new x coordinate.
     * */
    public void setX(int val){
        if(val < 0){
            throw new IllegalArgumentException("ru.nsu.dyuganov.logoworld.Coordinates.setX(int val) got negative arg.");
        }
        this.x = val;
    }

    /**
     * @param val new y coordinate.
     * */
    public void setY(int val){
        if(val < 0){
            throw new IllegalArgumentException("ru.nsu.dyuganov.logoworld.Coordinates.setY(int val) got negative arg.");
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
}
