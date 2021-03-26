package ru.nsu.dyuganov.trongame;

import ru.nsu.dyuganov.trongame.Model.GameManager.TronGame;

public class Main {
    public static void main(String[] args) {
        TronGame game = new TronGame();
        game.run(TronGame.RunMode.WINDOW);
    }
}


