package main.ru.nsu.dyuagnov.logoworld.Field;


/**
 * Elementary cell in the field.
 * Has two conditions: EMPTY or FILLED, can be printed.
 * */
public enum Cell {
    EMPTY("."),
    FILLED("#");

    private final String textRepresentation;
    private Cell(String textRepresentation) {
        this.textRepresentation = textRepresentation;
    }

    @Override public String toString() {
        return textRepresentation;
    }
}