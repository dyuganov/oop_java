package ru.nsu.Dyuagnov.LogoWorld.Field;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates;

/*
* 0------> width (Y)
* |
* |
* V height (X)
* */

public class Field {
    private int width;
    private int height;
    Cell[][] field;

    public Field(final int width, final int height){
        resize(width, height);
    }

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

    public void setObject(final Coordinates coords, final Cell object){
        if(coords == null || object == null){
            throw new IllegalArgumentException("Field.setObject coords or object == null.");
        }
        if(coords.getX() < 0 || coords.getX() >= height || coords.getY() < 0 || coords.getY() >= width){
            throw new IllegalArgumentException("Wrong Field.setObject param coords values.");
        }
        field[coords.getX()][coords.getY()] = object;
    }

    public Cell getObject(final Coordinates coords){
        return field[coords.getX()][coords.getY()];
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}
