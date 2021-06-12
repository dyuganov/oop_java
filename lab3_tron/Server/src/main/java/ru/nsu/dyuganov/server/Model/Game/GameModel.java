package main.java.ru.nsu.dyuganov.server.Model.Game;

import main.java.ru.nsu.dyuganov.server.Model.Bike.Bike;
import main.java.ru.nsu.dyuganov.server.Model.Bike.Trace;
import main.java.ru.nsu.dyuganov.server.Model.Direction.Direction;
import main.java.ru.nsu.dyuganov.server.User.UserHandler;
import main.java.ru.nsu.dyuganov.server.User.UserList;

import java.util.HashMap;
import java.util.Map;

public class GameModel {
    private final Map<Integer, Bike> idToBikes = new HashMap<Integer, Bike>();
    private final Map<Integer, Trace> idToTrace = new HashMap<Integer, Trace>();

    UserList activeUsers;

    public GameModel(UserList userList) {
        activeUsers = userList;
    }


    public void makeStep(Map<UserHandler, Direction> currStepUserMoveDirections){
        for(Integer userId : activeUsers.getUsersId()){
            //idToBikes.get(user.getId()).move(currStepUserMoveDirections.get(user));
        }
    }

    public void resetGame(){}
    //public void cleanGame(){} // вызывается после игры, чистит поле, игроков

    //Спавны у игроков в заранее известных точках поля
    public void initGame(){}


}
