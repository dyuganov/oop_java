package ru.nsu.dyuganov.trongame.Observer;

public interface Publisher {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(GameUpdates gameUpdates);
}
