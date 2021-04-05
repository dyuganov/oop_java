package ru.nsu.dyuganov.trongame;

import ru.nsu.dyuganov.trongame.Model.GameManager.TronGame;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running main thread");
        Thread gameMainThread = new Thread(new TronGame());
        gameMainThread.start();
        System.out.println("Main thread finished");
    }
}


