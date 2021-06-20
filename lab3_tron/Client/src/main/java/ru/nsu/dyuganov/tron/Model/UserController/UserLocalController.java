package main.java.ru.nsu.dyuganov.tron.Model.UserController;

import main.java.ru.nsu.dyuganov.tron.KeyController.KeyController;
import main.java.ru.nsu.dyuganov.tron.Model.Direction.Direction;

public class UserLocalController implements UserController{
    private final KeyController keyController;
    public UserLocalController(KeyController keyController){
        this.keyController = keyController;
    }

    @Override
    public Direction getDirection() {
        return keyController.getCurrentDirection();
    }
}
