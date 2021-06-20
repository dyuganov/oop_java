package main.java.ru.nsu.dyuganov.tron.Model.Game;

import main.java.ru.nsu.dyuganov.tron.Model.Bike.Bike;
import main.java.ru.nsu.dyuganov.tron.Model.Coordinates.Coordinates;
import main.java.ru.nsu.dyuganov.tron.Model.UserHandler.UserHandler;
import main.java.ru.nsu.dyuganov.tron.Model.UserList;

import java.util.*;

public class GameModel {
    static final int DELAY = 100;
    static final int FIELD_WIDTH = 55; // x
    static final int FIELD_HEIGHT = 33; // y
    boolean gameEnd = false;

    private UserList activeUsers;
    private final Map<Integer, Bike> idToBikes = new HashMap<Integer, Bike>();
    //private final List<Coordinates> startCoordinates = new ArrayList<>();

    public GameModel(UserList userList) {
        assert userList != null;
        activeUsers = userList;
    }

    public void start(){
        // main game
        initBikes();
        while(!gameEnd){
            makeStep();
        }
    }

    public void makeStep(){
        for(Integer i : activeUsers.getUsersId()){
            UserHandler currUser = activeUsers.getUser(i);

        }
    }

    private void initBikes(){
        final int xIndent = 3;
        final int yIndent = 3;
        for(Integer i : activeUsers.getUsersId()){
            this.idToBikes.put(i, new Bike(createRandomCoordinates(xIndent, yIndent)));
        }
    }

    private Coordinates createRandomCoordinates(int xIndent, int yIndent){
        Random random = new Random();
        int x = random.nextInt(FIELD_WIDTH - xIndent) + xIndent;
        int y = random.nextInt(FIELD_HEIGHT - yIndent) + yIndent;
        return new Coordinates(x, y);
    }
}
