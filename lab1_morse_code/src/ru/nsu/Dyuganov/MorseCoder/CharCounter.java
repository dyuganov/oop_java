package ru.nsu.Dyuganov.MorseCoder;

public class CharCounter {
    private final Character symbol;
    private Integer counter = 1;

    public CharCounter(Character symbol){
        this.symbol = symbol;
    }

    public Character getSymbol(){
        return symbol;
    }

    public Integer getCounter() {
        return counter;
    }

    public void increaseCnt() {
        ++counter;
    }

    public void decrease() {
        --counter;
    }

    public boolean equals(Object other) {
        if(other == null) return false;
        if(this == other || this.symbol.equals(((CharCounter)other).symbol)) {
            ((CharCounter) other).increaseCnt();
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (int)symbol;
    }
}
