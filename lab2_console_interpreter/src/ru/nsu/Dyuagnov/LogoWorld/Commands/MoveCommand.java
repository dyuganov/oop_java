package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Executor.Direction;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;

import java.lang.reflect.Field;

public class MoveCommand implements Command{

    private Executor executor = null;
    public MoveCommand(Executor executor, Direction direction, int stepsN){
        this.executor = executor;
    }

    @Override
    public void execute() {

    }
}
