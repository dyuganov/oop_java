package ru.nsu.Dyuagnov.LogoWorld.Field;

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