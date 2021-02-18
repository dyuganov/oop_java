package ru.nsu.dyuganov.logoworld.Field;

import ru.nsu.dyuganov.logoworld.Coordinates.Coordinates;
import ru.nsu.dyuganov.logoworld.Interpreter.Interpreter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Main LogoWorld field. Structure:<p>
 * 0--> width (Y)<p>
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
    public Field(final int newWidth, final int newHeight){
        resize(newWidth, newHeight);
    }

    /**
     * Change field size.
     * Params are non-negative.
     * */
    public void resize(final int newWidth, final int newHeight){
        if(newWidth > 0 && newHeight > 0) {
            this.width = newWidth;
            this.height = newHeight;
            field = new Cell[newHeight][newWidth];
            for (int i = 0; i < newHeight; i++) {
                for (int j = 0; j < newWidth; j++) {
                    field[i][j] = Cell.EMPTY;
                }
            }
        }
        else {
            throw new IllegalArgumentException("ru.nsu.dyuganov.logoworld.Field.resize(int width, int height) error. Got negative or zero value.");
        }
    }

    /**
     * Set object at coordinates.
     * @param coordinates cell coordinates.
     *                    Have to be non-negative and fit field size.
     *                    Else throws IllegalArgumentException.
     * @param newCell new Object to put in cell.
     * */
    public void setCell(final Coordinates coordinates, final Cell newCell){
        if(coordinates == null || newCell == null){
            throw new IllegalArgumentException("ru.nsu.dyuganov.logoworld.Field.setObject coords or object == null.");
        }
        if(coordinates.getX() < 0 || coordinates.getX() >= height || coordinates.getY() < 0 || coordinates.getY() >= width){
            throw new IllegalArgumentException("Wrong ru.nsu.dyuganov.logoworld.Field.setObject param coords values.");
        }
        field[coordinates.getX()][coordinates.getY()] = newCell;
    }

    /**
     * @param coordinates cell coordinates.
     * @return object at coordinates.
     * */
    public Cell getCell(final Coordinates coordinates){
        return field[coordinates.getX()][coordinates.getY()];
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
