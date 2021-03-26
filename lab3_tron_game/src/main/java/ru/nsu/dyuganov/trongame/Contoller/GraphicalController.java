package ru.nsu.dyuganov.trongame.Contoller;

public class GraphicalController implements Controller, Runnable{
    final int windowLength, windowWidth;

    GraphicalController(int windowWidth, int windowLength){
        this.windowWidth = windowWidth;
        this.windowLength = windowLength;
    }

    @Override
    public void run() {

    }
}
