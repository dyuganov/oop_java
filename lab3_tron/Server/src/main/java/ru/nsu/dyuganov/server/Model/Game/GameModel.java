package main.java.ru.nsu.dyuganov.server.Model.Game;

import main.java.ru.nsu.dyuganov.server.Model.Bike.Bike;
import main.java.ru.nsu.dyuganov.server.Model.Bike.Trace;
import main.java.ru.nsu.dyuganov.server.Model.Direction.Direction;
import main.java.ru.nsu.dyuganov.server.Model.User.UserHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameModel {
    private ArrayList<UserHandler> activeUsers = null;
    private static int idGenerator = 0;
    private final Map<Integer, Bike> idToBikes = new HashMap<Integer, Bike>();
    private final Map<Integer, Trace> idToTrace = new HashMap<Integer, Trace>();
    private final Map<Integer, Boolean> isUserAlive = new HashMap<>();

    public GameModel() {
        activeUsers = new ArrayList<>();
    }


    public void makeStep(Map<UserHandler, Direction> currStepUserMoveDirections){
        for(UserHandler user : activeUsers){
            idToBikes.get(user.getId()).move(currStepUserMoveDirections.get(user));
        }
    }

    public void resetGame(){}
    //public void cleanGame(){} // вызывается после игры, чистит поле, игроков

    public void initGame(){
        /*
         * Спавны у игроков в заранее известных точках поля
         * */
    }


}
