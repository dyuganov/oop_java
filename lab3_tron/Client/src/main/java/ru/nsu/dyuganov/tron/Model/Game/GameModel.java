package main.java.ru.nsu.dyuganov.tron.Model.Game;

import main.java.ru.nsu.dyuganov.tron.Model.Bike.Bike;
import main.java.ru.nsu.dyuganov.tron.Model.Coordinates.Coordinates;
import main.java.ru.nsu.dyuganov.tron.Model.UserList;

import java.util.*;

public class GameModel {
    static final int DELAY = 100;
    static final int FIELD_WIDTH = 55;
    static final int FIELD_HEIGHT = 33;

    UserList activeUsers;
    private final Map<Integer, Bike> idToBikes = new HashMap<Integer, Bike>();
    private final List<Coordinates> startCoordinates = new ArrayList<>();

    public GameModel(UserList userList) {
        activeUsers = userList;

    }

    public void start(){
        // main game
    }

    private void initPlayers(){

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
