package main.java.ru.nsu.dyuganov.tron.Model.UserHandler;

import main.java.ru.nsu.dyuganov.tron.Model.Direction.Direction;
import main.java.ru.nsu.dyuganov.tron.Model.UserController.UserController;


// TODO not needed??
public class UserHandler {
    private UserController userController;

    public UserHandler(UserController userController) {
        this.userController = userController;
    }

    public Direction getMoveDirection() {
        return userController.getDirection();
    }

}
