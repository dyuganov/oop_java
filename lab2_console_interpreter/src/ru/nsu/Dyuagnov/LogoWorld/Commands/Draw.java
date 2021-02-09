package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;

public class Draw implements Command {
    private Executor executor = null;
    public Draw(Executor executor){
        this.executor = executor;
    }

    @Override
    public void execute() {

    }
}
