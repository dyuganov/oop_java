package ru.nsu.dyuganov.trongame.Model.GameField;

import ru.nsu.dyuganov.trongame.Model.Coordinates.Coordinates;
import ru.nsu.dyuganov.trongame.Model.Direction.Direction;

/**
 * (0,0)--> (X) - width<p>
 *  |<p>
 *  V (Y) - length
 * */
public class GameField {
    private final int width;
    private final int length;

    /**
     * Cell[width(x)][length(y)];
     * */
    private final Cell[][] field;

    public GameField(int width, int length){
        this.width = width;
        this.length = length;
        field = new Cell[width][length];
    }

    void setCell(Coordinates cellCoordinates, Cell newCellType){
        if(cellCoordinates == null || newCellType == null){
            throw new IllegalArgumentException("GameField.setCell(Coordinates cellCoordinates, Cell newCellType) got null argument.");
        }
        int x = cellCoordinates.getX();
        int y = cellCoordinates.getY();
        if(x >= 0 && x < width && y >= 0 && y < length){
            this.field[x][y] = newCellType;
        }
        else {
            throw new IllegalArgumentException("GameField.setCell(Coordinates cellCoordinates, Cell newCellType) got wrong coordinates.");
        }
    }

    Cell getCell(Coordinates coordinates){
        return field[coordinates.getX()][coordinates.getY()];
    }

    boolean isAbleToMove(final Coordinates currentCoordinates, final Direction direction){
        return switch (direction){
            case UP -> (currentCoordinates.getY() - 1 >= 0) && (currentCoordinates.getY() - 1 < length);
            case DOWN -> (currentCoordinates.getY() + 1 >= 0) && (currentCoordinates.getY() + 1 < length);
            case LEFT -> (currentCoordinates.getX() - 1 >= 0) && (currentCoordinates.getX() - 1 < width);
            case RIGHT -> (currentCoordinates.getX() + 1 >= 0) && (currentCoordinates.getX() + 1 < width);
            default -> false;
        };
    }
}
