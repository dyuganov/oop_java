package ru.nsu.dyuganov.trongame.Model.GameModel;

import ru.nsu.dyuganov.trongame.Model.Bike.Bike;
import ru.nsu.dyuganov.trongame.Model.Coordinates.Coordinates;
import ru.nsu.dyuganov.trongame.Model.GameField.GameField;

import java.util.HashMap;

public class GameModel {
    static int idGenerator = 0;
    GameField gameField = null; // can't be changed while playing

    GameModel(final int fieldWidth, final int fieldLength){
        gameField = new GameField(fieldWidth, fieldLength);
    }

    final HashMap<Integer, Bike> bikesByID = new HashMap<Integer, Bike>();


    /**
     * For controller or server
     * */
    public void addBike(final Coordinates newBikeCoords){
        if(gameField.isOutOfBounds(newBikeCoords)){
            throw new IllegalArgumentException("Can't add bike. New bike coordinates are out of bounds.");
        }
        int newId = idGenerator++;
        if(bikesByID.containsKey(newId)){
            System.err.println("Created Bike with id similar to existing id. Old Bike was deleted."); // or use exception
        }
        bikesByID.put(newId, new Bike(newBikeCoords));
    }

    /**
     * For controller or server
     * */
    public void deleteBike(final int id){
        bikesByID.remove(id);
    }

    private void respawnBike(int id){
        // выбирает координаты для байка, очищает его и спавнит
    }
}
