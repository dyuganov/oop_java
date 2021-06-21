package main.java.ru.nsu.dyuganov.tron.Model.Game;

import main.java.ru.nsu.dyuganov.tron.Model.Bike.Bike;
import main.java.ru.nsu.dyuganov.tron.Model.ScoreCounter.ScoreCounter;
import main.java.ru.nsu.dyuganov.tron.Model.UserList;

import java.util.Map;

public class GameInfo {
    private UserList userList;
    private final Map<Integer, Bike> idToBikes;
    private final Map<Integer, ScoreCounter> idToScore;
    private int gameIterationsCnt = -1;

    public GameInfo(Map<Integer, Bike> idToBikes,
                    Map<Integer, ScoreCounter> idToScore, int gameIterationsCnt) {
        this.idToBikes = idToBikes;
        this.idToScore = idToScore;
        this.gameIterationsCnt = gameIterationsCnt;
    }

    public int getGameIterationsCnt() {
        return gameIterationsCnt;
    }

    public UserList getUserList() {
        return userList;
    }

    public Map<Integer, Bike> getIdToBikes() {
        return idToBikes;
    }

    public Map<Integer, ScoreCounter> getIdToScore() {
        return idToScore;
    }
}
