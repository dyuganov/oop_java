package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;

import java.lang.reflect.Field;

public class Teleport implements Command{

    private Executor executor = null;
    public Teleport(Executor executor, Coordinates coords){
        this.executor = executor;
    }

    @Override
    public void execute() {

    }

}
