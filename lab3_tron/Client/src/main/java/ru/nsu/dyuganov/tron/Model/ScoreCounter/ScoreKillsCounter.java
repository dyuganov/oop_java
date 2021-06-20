package main.java.ru.nsu.dyuganov.tron.Model.ScoreCounter;

public class ScoreKillsCounter implements ScoreCounter {
    private final int STANDARD_SCORE_DELTA = 1;
    private final int STANDARD_SCORE_VAL = 0;
    private int score = STANDARD_SCORE_VAL;

    @Override
    public void increase() {
        int result = score + STANDARD_SCORE_DELTA;
        assert result - score == STANDARD_SCORE_DELTA : "Score counting error";
        score = result;
    }

    @Override
    public void decrease() {
        int result = score - STANDARD_SCORE_DELTA;
        assert result + score == STANDARD_SCORE_DELTA : "Score counting error";
        score = result;
    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void reset() {
        score = STANDARD_SCORE_VAL;
    }
}
