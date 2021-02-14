package main.ru.nsu.Dyuagnov.LogoWorld.Commands;

import main.ru.nsu.Dyuagnov.LogoWorld.Field.Cell;

/**
 * Format: DRAW
 * */
public final class DrawCommand implements Command {
    public DrawCommand(){}

    /**
     * Turns on executor draw mode and changes that cell in field.
     * @param commandArgs - arguments for execution.
     * */
    @Override
    public void execute(CommandArgs commandArgs) {
        if(commandArgs.getExecutor() == null || commandArgs.getField() == null){
            throw new IllegalArgumentException("DrawCommand.execute() error. Got null argument.");
        }
        commandArgs.getExecutor().draw();
        commandArgs.getField().setObject(commandArgs.getExecutor().getCoordinates(), Cell.FILLED);
    }
}
