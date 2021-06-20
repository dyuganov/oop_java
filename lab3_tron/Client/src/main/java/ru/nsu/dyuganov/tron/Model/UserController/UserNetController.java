package main.java.ru.nsu.dyuganov.tron.Model.UserController;

import main.java.ru.nsu.dyuganov.tron.Model.Direction.Direction;

import java.net.Socket;

public class UserNetController implements UserController{
    private Socket clientSocket;

    @Override
    public Direction getDirection() {
        return null; // TODO
    }
}
