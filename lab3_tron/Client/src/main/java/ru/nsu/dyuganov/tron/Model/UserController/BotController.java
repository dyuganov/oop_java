package main.java.ru.nsu.dyuganov.tron.Model.UserController;

import main.java.ru.nsu.dyuganov.tron.Model.Direction.Direction;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BotController implements UserController {
    final Random random = new Random();
    final List<Direction> directionsList = new ArrayList<>();

    @Override
    public Direction getDirection() {
        return Direction.randomDirection();
    }
}
