package ru.nsu.dyuganov.logoworld.Commands;

import ru.nsu.dyuganov.logoworld.Field.Cell;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.Arrays;

/**
 * Format: DRAW
 * */
public final class DrawCommand implements Command {
    private final static Logger logger = LogManager.getLogger(DrawCommand.class);
    public DrawCommand(){
        DOMConfigurator.configure("src/main/resources/ru.nsu.dyuganov.logoworld/log4j.xml");
    }

    /**
     * Turns on executor draw mode and changes that cell in field.
     * @param commandArgs arguments for execution.
     * */
    @Override
    public void execute(CommandArgs commandArgs) {
        logger.debug("Draw command execution started");
        logger.debug("Command args are: explorer - " + commandArgs.getExecutor() +
                "; field - " + commandArgs.getField() + "; args - " + Arrays.toString(commandArgs.getArgs()));
        if(commandArgs.getExecutor() == null || commandArgs.getField() == null){
            logger.error("Throw IllegalArgumentException. Got null argument.");
            throw new IllegalArgumentException("DrawCommand.execute() error. Got null argument.");
        }
        commandArgs.getExecutor().draw();
        logger.info("ru.nsu.dyuganov.logoworld.Executor mode set to draw mode.");
        commandArgs.getField().setObject(commandArgs.getExecutor().getCoordinates(), Cell.FILLED);
        logger.info("ru.nsu.dyuganov.logoworld.Field cell set to FILLED at " + commandArgs.getExecutor().getCoordinates());
        logger.debug("Draw command execution finished.");
    }
}
