package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Field.Cell;


public final class DrawCommand implements Command {
    // DRAW
    public DrawCommand(){}

    @Override
    public void execute(CommandArgs commandArgs) {
        if(commandArgs.getExecutor() == null || commandArgs.getField() == null){
            throw new IllegalArgumentException("DrawCommand.execute() error. Got null argument.");
        }
        commandArgs.getExecutor().draw();
        commandArgs.getField().setObject(commandArgs.getExecutor().getCoordinates(), Cell.FILLED);
    }
}
