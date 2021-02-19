package ru.nsu.dyuganov.logoworld.Commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.nsu.dyuganov.logoworld.Coordinates.Coordinates;

import static java.lang.Integer.parseInt;

/**
 * Format: INIT <width> <height> <x> <y>
 */
public final class InitCommand implements Command {
    private final static Logger logger = LogManager.getLogger(InitCommand.class);

    public InitCommand() {
        DOMConfigurator.configure("src/main/resources/ru.nsu.dyuganov.logoworld/log4j.xml");
    }

    /**
     * Changes field size
     *
     * @param commandArgs arguments for execution.
     */
    @Override
    public void execute(CommandArgs commandArgs) {
        logger.debug("Init command execution started.");
        if(!isCorrectArgsNumber(commandArgs)){
            logger.debug("Init command execution finished.");
            return;
        }
        final int width = parseInt(commandArgs.getArgs()[1]);
        final int height = parseInt(commandArgs.getArgs()[2]);
        final int x = parseInt(commandArgs.getArgs()[3]);
        final int y = parseInt(commandArgs.getArgs()[4]);
        if(!isCorrectCoordinates(x, y, height, width)){
            logger.debug("Init command execution finished.");
            return;
        }
        final Coordinates coordinates = new Coordinates(x, y);
        logger.debug("Args parsed. Width = " + width + "; height = " + height + "; Coordinates = " + coordinates);
        commandArgs.getField().resize(width, height);
        logger.info("Field resized.");
        commandArgs.getExecutor().setCoordinates(coordinates);
        logger.info("Executor coordinates changed.");
        logger.debug("Init command execution finished.");
    }

    private boolean isCorrectArgsNumber(CommandArgs commandArgs){
        final int correctArgsNumber = 5;
        if(commandArgs.getArgs().length < correctArgsNumber){
            logger.error("Got wrong args.");
            System.err.println("Wrong args.");
            return false;
        }
        return true;
    }

    private boolean isCorrectCoordinates(int x, int y, int height, int width){
        if(x < 0 || x >= height || y < 0 || y >= width){
            logger.error("Got wrong coordinates.");
            System.err.println("Wrong coordinates.");
            return false;
        }
        return true;
    }
}
