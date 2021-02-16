package main.ru.nsu.dyuagnov.logoworld.Commands;

import main.ru.nsu.dyuagnov.logoworld.Field.Cell;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Format: DRAW
 * */
public final class DrawCommand implements Command {
    private final static Logger logger = LogManager.getLogger(DrawCommand.class);
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
