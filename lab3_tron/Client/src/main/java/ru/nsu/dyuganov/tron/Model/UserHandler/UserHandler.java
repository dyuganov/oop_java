package main.java.ru.nsu.dyuganov.tron.Model.UserHandler;

import main.java.ru.nsu.dyuganov.tron.Model.Direction.Direction;
import main.java.ru.nsu.dyuganov.tron.Model.UserController.UserController;

import java.net.Socket;
import java.util.Objects;

public class UserHandler {
    private UserController userController;
    //private int gamePoints = 0;

    public UserHandler(UserController userController){
        this.userController = userController;
    }

    public Direction getMoveDirection(){
        return userController.getDirection();
    }

   /* public void setUserController(UserController userController){
        this.userController = userController;
    }

    public UserController getUserController() {
        return userController;
    }*/

    /*public void addGamePoints(int val){
        int result = gamePoints + val;
        assert result - gamePoints == val : "Adding game points " + gamePoints + " + " + val + " got wrong result: " + result;
        gamePoints = result;
    }*/
}
