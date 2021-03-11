package ru.nsu.dyuganov.trongame;

import ru.nsu.dyuganov.trongame.Model.Game.LocalGame;

public class Main {
    public static void main(String[] args) {
        LocalGame localGame = new LocalGame();
        localGame.run(LocalGame.RunMode.WINDOW);
    }
}


