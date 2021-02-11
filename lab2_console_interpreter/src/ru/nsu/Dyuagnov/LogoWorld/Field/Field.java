package ru.nsu.Dyuagnov.LogoWorld.Field;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates;

import java.util.ArrayList;

/*
* 0------> width (X)
* |
* |
* V height (Y)
* */

public class Field {
    private int width = 10;
    private int height = 10;
    ArrayList<ArrayList<Object>> field = null; // хранить одномерно в стиле Си?
    //Coordinates robotPosition = new Coordinates(0,0);

    public Field(int width, int height){
        if(width > 0 && height > 0) {
            this.width = width;
            this.height = height;
            field = new ArrayList<ArrayList<Object>>(width); // init field here
            for(ArrayList<Object> line : field){
                for (int i = 0; i < height; i++) {
                    line.add(Object.EMPTY);
                }
            }
        }
        else {
            throw new IllegalArgumentException("Wrong parameters (length or width) value in Field constructor.");
        }
    }

    public void setObject(Coordinates coords, Object object){
        if(coords == null || object == null){
            throw new IllegalArgumentException("Field.setObject coords or object == null.");
        }
        if(coords.getX() < 0 || coords.getX() > width || coords.getY() < 0 || coords.getY() > height){
            throw new IllegalArgumentException("Wrong Field.setObject param coords values.");
        }
        field.get(coords.getX()).set(coords.getY(), object);
    }

    public Object getObject(Coordinates coords){
        return field.get(coords.getX()).get(coords.getY());
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

}
