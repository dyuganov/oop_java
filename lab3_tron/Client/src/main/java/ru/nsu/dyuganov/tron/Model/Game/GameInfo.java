package main.java.ru.nsu.dyuganov.tron.Model.Game;

import main.java.ru.nsu.dyuganov.tron.Model.Bike.Bike;
import main.java.ru.nsu.dyuganov.tron.Model.UserList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameInfo {
    private UserList userList;
    private final Map<Integer, Bike> idToBikes;
    private final Map<Integer, Integer> idToScore;

    public GameInfo(Map<Integer, Bike> idToBikes,
                    Map<Integer, Integer> idToScore){
        this.idToBikes = idToBikes;
        this.idToScore = idToScore;
    }

}
