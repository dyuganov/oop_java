package main.java.ru.nsu.dyuganov.tron.Model.Observer;

import main.java.ru.nsu.dyuganov.tron.Model.Game.GameInfo;

public interface Observer {
    void update(GameInfo gameInfo);
}
