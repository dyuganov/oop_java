package ru.nsu.Dyuagnov.LogoWorld.Coordinates;

public class Coordinates {
    private int x = 0;
    private int y = 0;

    public Coordinates(){}

    Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void setX(int val){
        this.x = val;
    }

    public void setY(int val){
        this.y = val;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

}
