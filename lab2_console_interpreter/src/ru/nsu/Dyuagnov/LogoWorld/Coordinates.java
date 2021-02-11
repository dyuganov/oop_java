package ru.nsu.Dyuagnov.LogoWorld;

public class Coordinates {
    private int x = 0;
    private int y = 0;

    public Coordinates(){}

    public Coordinates(int x, int y){
        if(x < 0 || y < 0){
            throw new IllegalArgumentException("Coordinates constructor got negative args.");
        }
        this.x = x;
        this.y = y;
    }

    public void setX(int val){
        if(val < 0){
            throw new IllegalArgumentException("Coordinates.setX(int val) got negative arg.");
        }
        this.x = val;
    }

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

}
