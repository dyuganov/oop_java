package ru.nsu.dyuganov.trongame.Model.GameManager;

import ru.nsu.dyuganov.trongame.Model.Direction.Direction;
import ru.nsu.dyuganov.trongame.Model.GameModel.GameModel;


// настройка
public class TronGame {
    public TronGame(){}

    // сновной цикл игры, всязка всего.запускает процессы из себя
    public void run(RunMode runMode){
        //Controller controller = initController(runMode);

        final int fieldWidth = 100;
        final int fieldLength = 100;
        GameModel game = new GameModel(fieldWidth, fieldLength);

    }


    public enum RunMode{
        CONSOLE, WINDOW
    }

/*    Controller initController(RunMode runMode){
        return switch (runMode){
            case WINDOW -> new KeyboardController();
            case CONSOLE -> new ConsoleController();
        };
    }*/
}
