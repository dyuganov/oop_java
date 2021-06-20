package main.java.ru.nsu.dyuganov.tron.Model.UserHandler;

import main.java.ru.nsu.dyuganov.tron.Model.UserController.UserController;

import java.net.Socket;
import java.util.Objects;


public class UserHandler {
    private UserController userController;

    public UserHandler(UserController userController){
        this.userController = userController;
    }

    public void setUserController(UserController userController){
        this.userController = userController;
    }

    public UserController getUserController() {
        return userController;
    }
}
