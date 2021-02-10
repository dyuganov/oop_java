package ru.nsu.Dyuagnov.LogoWorld.Field;

public class Field {
    private int width = 0;
    private int length = 0;

    public Field(){}
    public Field(int width, int length){
        if(length > 0 && width > 0){
            this.length = length;
            this.width = width;
        }
        else {
            throw new IllegalArgumentException("Wrong parameters (length or width) value in Field constructor.");
        }

    }

}
