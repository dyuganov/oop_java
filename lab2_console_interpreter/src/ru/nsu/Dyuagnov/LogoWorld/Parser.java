package ru.nsu.Dyuagnov.LogoWorld;

import ru.nsu.Dyuagnov.LogoWorld.Commands.*;
import ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Direction;

import java.util.Locale;


import static java.lang.Integer.parseInt;

public class Parser {
    public Command parse(String commandLine){
        commandLine = commandLine.toUpperCase(Locale.ROOT);
        String[] args = commandLine.split(" ");

        switch (args[0]){
            case "INIT": // INIT <width> <height> <x> <y>
                return new Init(parseInt(args[1]), parseInt(args[2]), parseInt(args[3]), parseInt(args[4]));

            case "MOVE": // MOVE [L|R|U|D] <steps>
                switch(args[1]){
                    case "L":
                        return new Move(Direction.LEFT, parseInt(args[2]));

                    case "R":
                        return new Move(Direction.RIGHT, parseInt(args[2]));

                    case "U":
                        return new Move(Direction.UP, parseInt(args[2]));

                    case "D":
                        return new Move(Direction.DOWN, parseInt(args[2]));
                }

            case "DRAW": // DRAW
                return new Draw();

            case "WARD": // WARD
                return new Ward();

            case "TELEPORT": // TELEPORT <x> <y>
                return new Teleport( new Coordinates(parseInt(args[2]), parseInt(args[2])));

            default:
                System.out.println("Wrong command.");
                return null;
        }
    }

}
