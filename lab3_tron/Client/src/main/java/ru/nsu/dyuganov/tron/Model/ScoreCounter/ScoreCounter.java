package main.java.ru.nsu.dyuganov.tron.Model.ScoreCounter;

public interface ScoreCounter {
    void increase();
    void decrease();
    int getScore();
    void reset();
}
