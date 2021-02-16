package main.ru.nsu.dyuagnov.logoworld.Field;

import main.ru.nsu.dyuagnov.logoworld.Coordinates.Coordinates;
import main.ru.nsu.dyuagnov.logoworld.Interpreter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Main LogoWorld field.
 *
 * Structure:
 * 0------> width (Y)
 * |
 * |
 * V height (X)
 * */
public class Field {
    private final static Logger logger = LogManager.getLogger(String.valueOf(Interpreter.class));
    private int width;
    private int height;
    Cell[][] field;

    /**
     * Create field with needed width and height.
     * Params are non-negative.
     * */
    public Field(final int width, final int height){
        resize(width, height);
    }

    /**
     * Change field size.
     * Params are non-negative.
     * */
    public void resize(final int width, final int height){
        if(width > 0 && height > 0) {
            this.width = width;
            this.height = height;
            field = new Cell[height][width];
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    field[i][j] = Cell.EMPTY;
                }
            }
        }
        else {
            throw new IllegalArgumentException("Field.resize(int width, int height) error. Got negative or zero value.");
        }
    }

    /**
     * Set object at coordinates.
     * @param coordinates - cell coordinates.
     *                    Have to be non-negative and fit field size.
     *                    Else throws IllegalArgumentException.
     * @param object - new Object to put in cell.
     * */
    public void setObject(final Coordinates coordinates, final Cell object){
        if(coordinates == null || object == null){
            throw new IllegalArgumentException("Field.setObject coords or object == null.");
        }
        if(coordinates.getX() < 0 || coordinates.getX() >= height || coordinates.getY() < 0 || coordinates.getY() >= width){
            throw new IllegalArgumentException("Wrong Field.setObject param coords values.");
        }
        field[coordinates.getX()][coordinates.getY()] = object;
    }

    /**
     * @param coordinates - cell coordinates.
     * @return object at coordinates.
     * */
    public Cell getObject(final Coordinates coordinates){
        return field[coordinates.getX()][coordinates.getY()];
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
