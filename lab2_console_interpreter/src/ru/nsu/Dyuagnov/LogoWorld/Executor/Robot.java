package ru.nsu.Dyuagnov.LogoWorld.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;


/**
 * Robot interacts with the field.
 * Has position and can turn on draw mode.
 * */
public class Robot implements Executor {
    private Coordinates coordinates;
    private boolean isDrawing = false;

    /**
     * Creates robot with start position.
     * @param coordinates - start position.
     * */
    public Robot(final Coordinates coordinates){
        setCoordinates(coordinates);
    }

    /**
     * Set new coordinates.
     * @param coordinates - new coordinates.
     * */
    public void setCoordinates(final Coordinates coordinates){
        if(coordinates == null){
            throw new IllegalArgumentException("Got coordinates == null");
        }
        if(coordinates.getX() < 0 || coordinates.getY() < 0){
            throw new IllegalArgumentException("Got negative coordinates");
        }
        this.coordinates = coordinates;
    }

    /**
     * @return current coordinates.
     * */
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

    /**
     * Changes robot position, connected with Field realisation.
     * Right: y += 1;
     * Left: y -= 1;
     * Up: x -= 1;
     * Down: x += 1;
     * */
    @Override
    public void move(Direction direction){
        switch (direction){
            case UP -> setCoordX(coordinates.getX() - 1);
            case DOWN -> setCoordX(coordinates.getX() + 1);
            case LEFT -> setCoordY(coordinates.getY() - 1);
            case RIGHT -> setCoordY(coordinates.getY() + 1);
        }
    }

    /**
     * Change coordinates.
     * @param coordinates - new position.
     * */
    @Override
    public void teleport(Coordinates coordinates){
        this.setCoordinates(coordinates);
    }

    /**
     * Turns on draw mode.
     * @return current position.
     * */
    @Override
    public Coordinates draw(){
        isDrawing = true;
        return this.coordinates;
    }

    /**
     * Turns off draw mode.
     * */
    @Override
    public void ward(){
        isDrawing = false;
    }

    /**
     * Checks draw mode.
     * */
    @Override
    public boolean isDrawing() {
        return isDrawing;
    }
}
