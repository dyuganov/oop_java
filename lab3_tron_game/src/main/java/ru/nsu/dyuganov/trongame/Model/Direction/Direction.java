package ru.nsu.dyuganov.trongame.Model.Direction;

public enum Direction {
    UP("U"),
    DOWN("D"),
    LEFT("L"),
    RIGHT("R");

    private final String textRepresentation;
    private Direction(String textRepresentation) {
        this.textRepresentation = textRepresentation;
    }

    @Override public String toString() {
        return textRepresentation;
    }

    public boolean isOpposite(Direction other){
        if(this == Direction.DOWN && other == Direction.UP) return true;
        else if(this == Direction.UP && other == Direction.DOWN) return true;
        else if(this == Direction.LEFT && other == Direction.RIGHT) return true;
        else return (this == Direction.RIGHT && other == Direction.LEFT);
    }
}
