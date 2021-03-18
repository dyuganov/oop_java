package ru.nsu.dyuganov.trongame.Model.GameManager;

import ru.nsu.dyuganov.trongame.Controller.ConsoleController;
import ru.nsu.dyuganov.trongame.Controller.Controller;
import ru.nsu.dyuganov.trongame.Controller.KeyboardController;
import ru.nsu.dyuganov.trongame.Model.Direction.Direction;


public class LocalGame {
    public LocalGame(){}

    public void run(RunMode runMode){



        Controller controller = initController(runMode);


        Direction currDirection = null;
        while(true){

        }
    }

    public enum RunMode{
        CONSOLE, WINDOW
    }

    Controller initController(RunMode runMode){
        return switch (runMode){
            case WINDOW -> new KeyboardController();
            case CONSOLE -> new ConsoleController();
            //default -> null;
        };
    }

/*    private void moveBike(Bike bike, Direction direction){
        if(){ // проверка на границы карты
            bike.move(direction);
        }
    }*/
}
