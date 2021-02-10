package ru.nsu.Dyuagnov.LogoWorld.Field;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates;

import java.util.ArrayList;

public class Field {
    private int width = 1;
    private int height = 1;
    ArrayList<ArrayList<Integer>> field = null; // use enum object?
    Coordinates robotPosition = new Coordinates(0,0);

    public Field(int width, int height){
        if(width > 0 && height > 0) {
            this.width = width;
            this.height = height;
        }
        else {
            throw new IllegalArgumentException("Wrong parameters (length or width) value in Field constructor.");
        }
        field = new ArrayList<>(); // init field here

    }

}
