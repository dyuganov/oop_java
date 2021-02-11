package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;
import ru.nsu.Dyuagnov.LogoWorld.Field.Object;


public class DrawCommand implements Command {
    private Executor executor = null;
    private Field field = null;

    // DRAW
    public DrawCommand(CommandArgs commandArgs){
        this.executor = commandArgs.getExecutor();
        this.field = commandArgs.getField();
    }

    @Override
    public void execute() {
        executor.draw();
        field.setObject(executor.getCoordinates(), Object.FILLED);
    }
}
