package ru.nsu.Dyuagnov.LogoWorld.Executor;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;

public class Robot implements Executor {
    private Coordinates coords = null;

    Robot(){
        this.coords = new Coordinates();
    }
    Robot(Coordinates coords){
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
    public Coordinates getCoords;

    public void move(Direction direction){}
    //public void move(ru.nsu.Dyuagnov.LogoWorld.Coordinates.ru.nsu.Dyuagnov.LogoWorld.Coordinates coords);
    public void teleport(Coordinates coords){}
    public void draw(){}
    public void ward(){}
}
