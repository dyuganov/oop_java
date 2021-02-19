package ru.nsu.dyuganov.logoworld.Commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.nsu.dyuganov.logoworld.Coordinates.Coordinates;
import ru.nsu.dyuganov.logoworld.Field.Cell;

import static java.lang.Integer.parseInt;

/**
 * Format: TELEPORT <x> <y>
 */
public final class TeleportCommand implements Command {
    private final static Logger logger = LogManager.getLogger(TeleportCommand.class);

    public TeleportCommand() {
        DOMConfigurator.configure("src/main/resources/ru.nsu.dyuganov.logoworld/log4j.xml");
    }

    /**
     * Teleports executor to new position.
     * If draw mode is on, changes new position field cell.
     *
     * @param commandArgs arguments for execution.
     */
    @Override
    public void execute(CommandArgs commandArgs) {
        logger.debug("Teleport command execution started.");
        if(!isCorrectArgsNumber(commandArgs)){
            logger.debug("Teleport command execution finished.");
            return;
        }
        int x = parseInt(commandArgs.getArgs()[1]);
        int y = parseInt(commandArgs.getArgs()[2]);
        logger.debug("Args parsed: x = " + x + "; y = " + y + "; Executor = " +
                commandArgs.getExecutor() + "; Field = " + commandArgs.getField());
        if (commandArgs.getExecutor() == null || commandArgs.getField() == null) {
            logger.error("Throw IllegalArgumentException. Got null argument.");
            throw new IllegalArgumentException("TeleportCommand.execute() error. Got null argument.");
        }
        if(x < 0 || x >= commandArgs.getField().getHeight() || y < 0 || y >= commandArgs.getField().getWidth()){
            logger.error("Got wrong coordinates.");
            System.err.println("Wrong coordinates.");
            logger.debug("Teleport command execution finished.");
            return;
        }
        Coordinates coordinates = new Coordinates(x, y);
        commandArgs.getExecutor().teleport(coordinates);
        logger.info("Executor coordinates changed to " + coordinates);
        if (commandArgs.getExecutor().isDrawing()) {
            commandArgs.getField().setCell(commandArgs.getExecutor().getCoordinates(), Cell.FILLED);
            logger.info("Field cell set to FILLED at " + coordinates);
        }
        logger.debug("Teleport command execution finished.");
    }

    private boolean isCorrectArgsNumber(CommandArgs commandArgs){
        final int correctArgsNumber = 3;
        if(commandArgs.getArgs().length < correctArgsNumber){
            logger.error("Got wrong args number.");
            System.err.println("Wrong args number.");
            return false;
        }
        return true;
    }
}
