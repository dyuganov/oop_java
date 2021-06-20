package main.java.ru.nsu.dyuganov.tron.Model.Direction;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

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

    private static final List<Direction> values = List.of(values());
    private static int size = values.size();
    private static final Random random = new Random();
    public static Direction randomDirection(){
        return values.get(random.nextInt(size));
    }
}