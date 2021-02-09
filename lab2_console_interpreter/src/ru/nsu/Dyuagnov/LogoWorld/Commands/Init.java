package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;

public class Init implements Command{

    private Executor executor = null;
    // INIT <width> <height> <x> <y>
    public Init(Executor executor, int width, int height, Coordinates coords){
        this.executor = executor;
    }

    @Override
    public void execute() {

    }


}
