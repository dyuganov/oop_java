package ru.nsu.dyuganov.trongame.Controller;

import ru.nsu.dyuganov.trongame.Model.Direction.Direction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleController implements Controller {
    @Override
    public Direction getDirection() {

        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String command = in.readLine();
            return switch (command) {
                case "U" -> Direction.UP;
                case "D" -> Direction.DOWN;
                case "L" -> Direction.LEFT;
                case "R" -> Direction.RIGHT;
                default -> null;
            };
        }
        catch (IOException e){
            e.printStackTrace(System.err);
        }

        return null;
    }


}
