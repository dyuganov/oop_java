package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;

public final class WardCommand implements Command{
    // WARD
    public WardCommand(){}

    @Override
    public void execute(CommandArgs commandArgs) {
        if(commandArgs.getExecutor() == null){
            throw new IllegalArgumentException("WardCommand.execute() error. Got null argument.");
        }
        commandArgs.getExecutor().ward();
    }
}
