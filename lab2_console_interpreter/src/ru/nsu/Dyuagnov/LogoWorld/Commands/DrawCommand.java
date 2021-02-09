package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;

public class DrawCommand implements Command {
    private Executor executor = null;
    public DrawCommand(Executor executor){
        this.executor = executor;
    }

    @Override
    public void execute() {

    }
}
