package ru.nsu.dyuganov.trongame.Model.Game;

import ru.nsu.dyuganov.trongame.Model.Bike.Bike;
import ru.nsu.dyuganov.trongame.Model.Field.GameField;

import java.util.ArrayList;

public class Game {
    Game(){}

    void run(){
        final int fieldWidth = 10;
        final int fieldLength = 10;
        GameField gameField = new GameField(fieldWidth, fieldLength);

        final ArrayList<Bike> bikes = new ArrayList<>();
        bikes.add(new Bike(fieldWidth / 2, fieldLength / 2));



        while(true){

        }
    }
}
