package main.java.ru.nsu.dyuganov.server.Model.Game;

import main.java.ru.nsu.dyuganov.server.Model.Bike.Bike;
import main.java.ru.nsu.dyuganov.server.Model.Bike.Trace;
import main.java.ru.nsu.dyuganov.server.Model.Direction.Direction;
import main.java.ru.nsu.dyuganov.server.Model.User.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameModel {
    private ArrayList<User> activeUsers = null;
    private static int idGenerator = 0;
    private final Map<Integer, Bike> idToBikes = new HashMap<Integer, Bike>();
    private final Map<Integer, Trace> idToTrace = new HashMap<Integer, Trace>();
    private final Map<Integer, Boolean> isUserAlive = new HashMap<>();
    //private final GameModel gameModel = new GameModel();

    GameModel(ArrayList<User> users){
        this.activeUsers = users;
    }

    public void setActiveUsers(ArrayList<User> users){
        this.activeUsers = users;
    }

    public void makeStep(Map<User, Direction> userMoveDirections){

        for(User user : activeUsers){
            idToBikes.get(user.getId()).move(userMoveDirections.get(user));
        }
    }

    public void resetGame(){

    }

}
