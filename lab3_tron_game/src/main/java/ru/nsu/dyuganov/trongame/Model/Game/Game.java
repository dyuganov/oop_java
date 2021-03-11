package ru.nsu.dyuganov.trongame.Model.Game;

import ru.nsu.dyuganov.trongame.Controller.ConsoleController;
import ru.nsu.dyuganov.trongame.Controller.Controller;
import ru.nsu.dyuganov.trongame.Controller.KeyboardController;
import ru.nsu.dyuganov.trongame.Model.Bike.Bike;
import ru.nsu.dyuganov.trongame.Model.Color.Color;
import ru.nsu.dyuganov.trongame.Model.Direction.Direction;
import ru.nsu.dyuganov.trongame.Model.Field.GameField;

import java.util.ArrayList;

public class Game {
    public Game(){}

    public void run(RunMode runMode){
        final int fieldWidth = 10;
        final int fieldLength = 10;
        GameField gameField = new GameField(fieldWidth, fieldLength);

        final ArrayList<Bike> bikes = new ArrayList<>();
        bikes.add(new Bike(fieldWidth / 2, fieldLength / 2));

        Controller controller = initController(runMode);

        while(true){
            System.out.println(controller.getDirection());
        }
    }

    public enum RunMode{
        CONSOLE, WINDOW
    }

    Controller initController(RunMode runMode){
        return switch (runMode){
            case WINDOW -> new KeyboardController();
            case CONSOLE -> new ConsoleController();
            default -> null;
        };
    }
}
