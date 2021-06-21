package main.java.ru.nsu.dyuganov.tron.Model.Game;

import main.java.ru.nsu.dyuganov.tron.Model.Bike.Bike;
import main.java.ru.nsu.dyuganov.tron.Model.Coordinates.Coordinates;
import main.java.ru.nsu.dyuganov.tron.Model.Observer.Observable;
import main.java.ru.nsu.dyuganov.tron.Model.Observer.Observer;
import main.java.ru.nsu.dyuganov.tron.Model.ScoreCounter.ScoreCounter;
import main.java.ru.nsu.dyuganov.tron.Model.ScoreCounter.ScoreKillsCounter;
import main.java.ru.nsu.dyuganov.tron.Model.UserList;

import java.util.*;

public class GameModel implements Observable {
    static final int GAME_ITERATIONS = 3;
    static final int FIELD_WIDTH = 55; // x
    static final int FIELD_HEIGHT = 33; // y

    Set<Observer> observers = new HashSet<>();

    boolean isGameEnd = false;
    int gameIterationsCnt = 0;

    private final UserList activeUsers;
    private final Map<Integer, Bike> idToBikes = new HashMap<Integer, Bike>();
    private final Map<Integer, ScoreCounter> idToScore = new HashMap<>();
    private GameInfo currGameInfo = new GameInfo(idToBikes, idToScore, gameIterationsCnt, isGameEnd);

    public GameModel(UserList userList) {
        assert userList != null;
        activeUsers = userList;
    }

    public void makeStep() {
        for (Integer i : activeUsers.getUsersId()) {
            idToBikes.get(i).move(activeUsers.getUser(i).getDirection());
        }
        checkCollisions();
        if (playersAlive() <= 1) {
            if (++gameIterationsCnt < GAME_ITERATIONS) {
                resetGame();
            } else {
                isGameEnd = true;
            }
        }
        updateGameInfo();
    }

    private void checkCollisions() {
        for (Integer i : activeUsers.getUsersId()) {
            Bike first = idToBikes.get(i);
            if (!first.isActive()) {
                continue;
            }
            if (isOutOfBounds(first.getCoordinates())) {
                first.setActive(false);
                continue;
            }
            if(first.getTrace().contains(first.getCoordinates())){
                first.setActive(false);
                //idToScore.get(i).decrease();
                continue;
            }
            for (Integer j : activeUsers.getUsersId()) {
                Bike second = idToBikes.get(j);
                if (i.equals(j) || !second.isActive()) {
                    continue;
                }
                if (first.getCoordinates().equals(second.getCoordinates())) {
                    first.setActive(false);
                    second.setActive(false);
                    break;
                }
                if (second.getTrace().contains(first.getCoordinates())) {
                    //idToScore.get(j).increase();
                    //idToScore.get(i).decrease();
                    first.setActive(false);
                    break;
                }
            }
        }
    }

    private boolean isOutOfBounds(Coordinates coordinates) {
        return coordinates.getX() < 0 || coordinates.getX() >= FIELD_WIDTH ||
                coordinates.getY() < 0 || coordinates.getY() >= FIELD_HEIGHT;
    }

    private long playersAlive() {
        return this.idToBikes.values().stream().filter(Bike::isActive).count();
    }

    public void resetGame() {
        initBikes();
        updateGameInfo();
    }

    public void resetScores() {
        for (Integer i : activeUsers.getUsersId()) {
            idToScore.put(i, new ScoreKillsCounter());
        }
    }

    private void initBikes() {
        final int xIndent = 3;
        final int yIndent = 3;
        for (Integer i : activeUsers.getUsersId()) {
            this.idToBikes.put(i, new Bike(createRandomCoordinates(xIndent, yIndent)));
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer o : this.observers) {
            o.update(currGameInfo);
        }
    }

    public GameInfo getGameInfo() {
        return currGameInfo;
    }

    public boolean isGameEnd() {
        return isGameEnd;
    }

    public UserList getUserList(){
        return activeUsers;
    }

    @Override
    public void registerObserver(Observer newObserver) {
        this.observers.add(newObserver);
    }

    @Override
    public void removeObserver(Observer observer) {
        this.observers.remove(observer);
    }

    private Coordinates createRandomCoordinates(int xIndent, int yIndent) {
        Random random = new Random();
        int x = random.nextInt(FIELD_WIDTH - xIndent) + xIndent;
        int y = random.nextInt(FIELD_HEIGHT - yIndent) + yIndent;
        return new Coordinates(x, y);
    }

    private void updateGameInfo(){
        this.currGameInfo = new GameInfo(idToBikes, idToScore, gameIterationsCnt, isGameEnd);
    }
}
