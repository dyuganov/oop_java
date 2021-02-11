package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;

public class WardCommand implements Command{
    private Executor executor = null;
    private Field field = null;

    // WARD
    public WardCommand(CommandArgs commandArgs){
        this.executor = commandArgs.getExecutor();
        this.field = commandArgs.getField();
    }

    @Override
    public void execute() {
        executor.ward();
    }

}
