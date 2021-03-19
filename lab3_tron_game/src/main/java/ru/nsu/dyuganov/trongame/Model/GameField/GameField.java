package ru.nsu.dyuganov.trongame.Model.GameField;

import ru.nsu.dyuganov.trongame.Model.Coordinates.Coordinates;

/**
 * (0,0)--> (X) - width<p>
 *  |<p>
 *  V (Y) - length
 * */
public class GameField {
    private final int width;
    private final int length;

    public GameField(int width, int length){
        this.width = width;
        this.length = length;
    }


    /**
     * Point is over map bounds check.
     * */
    public boolean isOutOfBounds(final Coordinates coordinates){
        if(coordinates == null){
            throw new IllegalArgumentException("GameField.isOverMap got coordinates == null");
        }
        final int x = coordinates.getX();
        final int y = coordinates.getY();
        return x < 0 || x >= this.width || y < 0 || y >= this.length;
    }
}
