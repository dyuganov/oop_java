package ru.nsu.dyuganov.trongame.Model.GameModel;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.nsu.dyuganov.trongame.Model.Bike.Bike;
import ru.nsu.dyuganov.trongame.Model.Bike.Trace;
import ru.nsu.dyuganov.trongame.Model.Coordinates.Coordinates;
import ru.nsu.dyuganov.trongame.Model.GameField.GameField;
import ru.nsu.dyuganov.trongame.Model.GameManager.TronGame;

import java.util.HashMap;

public class GameModel {
    private final static Logger logger = LogManager.getLogger(GameModel.class);

    static int idGenerator = 0;
    final HashMap<Integer, Bike> bikesByID = new HashMap<Integer, Bike>();
    final HashMap<Integer, Trace> traceByID = new HashMap<Integer, Trace>();
    GameField gameField = null; // can't be changed while playing

    public GameModel(final int fieldWidth, final int fieldLength){
        DOMConfigurator.configure("src/main/resources/ru.nsu.dyuganov.trongame/log4j/log4j.xml");
        gameField = new GameField(fieldWidth, fieldLength);
    }

    public void setGameField(final int newGameFieldWidth, int newGameFieldWLength){
        this.gameField = new GameField(newGameFieldWidth, newGameFieldWLength);

    }

    /**
     * For controller or server
     * */
    public void addBike(final Coordinates newBikeCoords, int newBikeId){
        if(gameField.isOutOfBounds(newBikeCoords)){
            throw new IllegalArgumentException("Can't add bike. New bike coordinates are out of bounds.");
        }
        if(bikesByID.containsKey(newBikeId)){
            System.err.println("Created Bike with id similar to existing id. Old Bike was deleted."); // or use exception
        }
        bikesByID.put(newBikeId, new Bike(newBikeCoords));
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
