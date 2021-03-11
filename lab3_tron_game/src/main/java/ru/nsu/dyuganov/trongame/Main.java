package ru.nsu.dyuganov.trongame;

import ru.nsu.dyuganov.trongame.Model.Game.Game;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.run(Game.RunMode.WINDOW);
    }
}


