package ru.nsu.dyuganov.trongame.Model.Server;

import ru.nsu.dyuganov.trongame.Model.Bike.Bike;
import ru.nsu.dyuganov.trongame.Model.Coordinates.Coordinates;
import ru.nsu.dyuganov.trongame.Model.GameField.GameField;

import java.util.ArrayList;

public class Server {
    Server(){}

    private int fieldWidth;
    private int fieldLength;
    GameField gameField = new GameField(fieldWidth, fieldLength);

    final ArrayList<Bike> bikes = new ArrayList<>();

    void addBike(final Coordinates coordinates, final int id){
        final int x = coordinates.getX();
        final int y = coordinates.getY();
        if(x < 0 || x >= fieldWidth || y < 0 || y > fieldLength){
            throw new IllegalArgumentException("Server.addBike(int x, int y) got wrong coordinate.");
        }
        bikes.add(new Bike(coordinates, id));
    }



}
