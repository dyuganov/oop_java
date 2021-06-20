package main.java.ru.nsu.dyuganov.tron.Model.Observer;

public interface Observable {
    void notifyObservers();
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
}
