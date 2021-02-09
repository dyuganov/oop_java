package ru.nsu.Dyuagnov.LogoWorld.Executor;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;

public class Robot implements Executor {
    private Coordinates coords = new Coordinates();
    private boolean drawing = false;



    Robot(){

    }
    public Robot(Coordinates coords){
        this.coords = coords;
    }

    public void setCoords(Coordinates coords){
        this.coords = coords;
    }
    public void setCoordX(int val){
        this.coords.setX(val);
    }
    public void setCoordY(int val){
        this.coords.setY(val);
    }

    public Coordinates getCoords() {
        return coords;
    }

    public void move(Direction direction){}
    //public void move(ru.nsu.Dyuagnov.ru.nsu.Dyuagnov.LogoWorld.LogoWorld.Coordinates.ru.nsu.Dyuagnov.ru.nsu.Dyuagnov.LogoWorld.LogoWorld.Coordinates coords);
    public void teleport(Coordinates coords){}
    public void draw(){}

    public void ward(){}
}
