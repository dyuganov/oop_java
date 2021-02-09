package ru.nsu.Dyuagnov.LogoWorld;

import ru.nsu.Dyuagnov.LogoWorld.Commands.*;
import ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Direction;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;

import java.util.HashMap;
import java.util.Locale;


import static java.lang.Integer.parseInt;

public class Parser {
    public Command parse(String commandLine, Executor executor){
        commandLine = commandLine.toUpperCase(Locale.ROOT);
        String[] args = commandLine.split(" ");

        switch (args[0]){
            case "INIT": // INIT <width> <height> <x> <y>
                int width = parseInt(args[1]);
                int height = parseInt(args[2]);
                int x = parseInt(args[3]);
                int y = parseInt(args[4]);
                return new InitCommand(executor, width, height, new Coordinates(x, y));

            case "MOVE": // MOVE [L|R|U|D] <steps>
                int stepsN = parseInt(args[2]);
                switch(args[1]){
                    case "L":
                        return new MoveCommand(executor, Direction.LEFT, stepsN);

                    case "R":
                        return new MoveCommand(executor, Direction.RIGHT, stepsN);

                    case "U":
                        return new MoveCommand(executor, Direction.UP, stepsN);

                    case "D":
                        return new MoveCommand(executor, Direction.DOWN, stepsN);
                }

            case "DRAW": // DRAW
                return new DrawCommand(executor);

            case "WARD": // WARD
                return new WardCommand(executor);

            case "TELEPORT": // TELEPORT <x> <y>
                x = parseInt(args[1]);
                y = parseInt(args[2]);
                return new TeleportCommand(executor, new Coordinates(x, y));

            default:
                System.out.println("Wrong command.");
                return null;
        }
    }
}
