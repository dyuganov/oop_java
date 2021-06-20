package main.java.ru.nsu.dyuganov.tron.Model.Game;

import main.java.ru.nsu.dyuganov.tron.Model.Bike.Bike;
import main.java.ru.nsu.dyuganov.tron.Model.Coordinates.Coordinates;
import main.java.ru.nsu.dyuganov.tron.Model.Observer.Observable;
import main.java.ru.nsu.dyuganov.tron.Model.Observer.Observer;
import main.java.ru.nsu.dyuganov.tron.Model.ScoreCounter.ScoreCounter;
import main.java.ru.nsu.dyuganov.tron.Model.ScoreCounter.ScoreKillsCounter;
import main.java.ru.nsu.dyuganov.tron.Model.UserHandler.UserHandler;
import main.java.ru.nsu.dyuganov.tron.Model.UserList;

import java.util.*;

public class GameModel implements Observable {
    static final int DELAY = 100;
    static final int FIELD_WIDTH = 55; // x
    static final int FIELD_HEIGHT = 33; // y
    boolean isGameEnd = false;

    Set<Observer> observers = new HashSet<>();

    private final UserList activeUsers;
    private final Map<Integer, Bike> idToBikes = new HashMap<Integer, Bike>();
    private final Map<Integer, ScoreCounter> idToScore = new HashMap<>();
    private GameInfo currGameInfo = new GameInfo(idToBikes, idToScore);

    public GameModel(UserList userList) {
        assert userList != null;
        activeUsers = userList;
    }

    public void makeStep(){
        for(Integer i : activeUsers.getUsersId()){
            UserHandler currUser = activeUsers.getUser(i);
            // TODO: передвинуть юзера ...

            idToBikes.get(i).move(currUser.getMoveDirection());
            currGameInfo = new GameInfo(idToBikes, idToScore);
        }
        checkCollisions();
    }

    private void checkCollisions(){
        for(Integer i : activeUsers.getUsersId()){
            Bike first = idToBikes.get(i);
            for(Integer j : activeUsers.getUsersId()){
                Bike second = idToBikes.get(j);
                if(i.equals(j) || !first.isActive() || !second.isActive()){
                    continue;
                }
                if(first.getCoordinates().equals(second.getCoordinates())){
                    first.setActive(false);
                    second.setActive(false);
                }
                if(second.getTrace().contains(first.getCoordinates())){
                    //idToScore;
                }
            }
        }
    }

    public void resetGame(){
        initBikes();
        resetScores();
        currGameInfo = new GameInfo(idToBikes, idToScore);
    }

    private void resetScores(){
        for (Integer i : activeUsers.getUsersId()){
            idToScore.put(i, new ScoreKillsCounter());
        }
    }

    private void initBikes(){
        final int xIndent = 3;
        final int yIndent = 3;
        for(Integer i : activeUsers.getUsersId()){
            this.idToBikes.put(i, new Bike(createRandomCoordinates(xIndent, yIndent)));
        }
    }

    @Override
    public void notifyObservers() {
        for(Observer o : this.observers){
            o.update(currGameInfo);
        }
    }

    public GameInfo getGameInfo(){
        return currGameInfo;
    }

    public boolean isGameEnd(){
        return isGameEnd;
    }

    @Override
    public void registerObserver(Observer newObserver) {
        this.observers.add(newObserver);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    private Coordinates createRandomCoordinates(int xIndent, int yIndent){
        Random random = new Random();
        int x = random.nextInt(FIELD_WIDTH - xIndent) + xIndent;
        int y = random.nextInt(FIELD_HEIGHT - yIndent) + yIndent;
        return new Coordinates(x, y);
    }
}
