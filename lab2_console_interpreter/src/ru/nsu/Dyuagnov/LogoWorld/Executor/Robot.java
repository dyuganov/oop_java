package ru.nsu.Dyuagnov.LogoWorld.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Coordinates;

public class Robot implements Executor {
    private Coordinates coordinates;
    private boolean isDrawing = false;

    public Robot(final Coordinates coordinates){
        setCoordinates(coordinates);
    }

    public void setCoordinates(final Coordinates coordinates){
        if(coordinates == null){
            throw new IllegalArgumentException("Robot.setCoordinates(Coordinates coordinates) error. Got coordinates == null.");
        }
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordX(int val){
        if(val < 0){
            throw new IllegalArgumentException("Robot.setCoordX can't be negative.");
        }
        this.coordinates.setX(val);
    }

    public void setCoordY(int val){
        if(val < 0){
            throw new IllegalArgumentException("Robot.setCoordY can't be negative.");
        }
        this.coordinates.setY(val);
    }

    @Override
    public void move(Direction direction){
        switch (direction){
            case UP -> setCoordX(coordinates.getX() - 1);
            case DOWN -> setCoordX(coordinates.getX() + 1);
            case LEFT -> setCoordY(coordinates.getY() - 1);
            case RIGHT -> setCoordY(coordinates.getY() + 1);
        }
    }

    @Override
    public void teleport(Coordinates coordinates){
        this.setCoordinates(coordinates);
    }

    @Override
    public Coordinates draw(){
        isDrawing = true;
        return this.coordinates;
    }

    @Override
    public void ward(){
        isDrawing = false;
    }

    @Override
    public boolean isDrawing() {
        return isDrawing;
    }
}
