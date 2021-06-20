package main.java.ru.nsu.dyuganov.tron.Model.Game;

import main.java.ru.nsu.dyuganov.tron.Model.Bike.Bike;
import main.java.ru.nsu.dyuganov.tron.Model.ScoreCounter.ScoreCounter;
import main.java.ru.nsu.dyuganov.tron.Model.UserList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameInfo {
    private UserList userList;
    private final Map<Integer, Bike> idToBikes;
    private final Map<Integer, ScoreCounter> idToScore;

    public GameInfo(Map<Integer, Bike> idToBikes,
                    Map<Integer, ScoreCounter> idToScore){
        this.idToBikes = idToBikes;
        this.idToScore = idToScore;
    }

}
