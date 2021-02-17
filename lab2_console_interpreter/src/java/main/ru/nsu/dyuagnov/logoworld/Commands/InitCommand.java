package main.ru.nsu.dyuagnov.logoworld.Commands;

import main.ru.nsu.dyuagnov.logoworld.Coordinates.Coordinates;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import static java.lang.Integer.*;

/**
 * Format: INIT <width> <height> <x> <y>
 * */
public final class InitCommand implements Command{
    private final static Logger logger = LogManager.getLogger(InitCommand.class);
    public InitCommand(){}

    /**
     * Changes field size
     * @param commandArgs - arguments for execution.
     * */
    @Override
    public void execute(CommandArgs commandArgs) {
        DOMConfigurator.configure("src/java/resources/log4j.xml");
        logger.setLevel(Level.DEBUG);
        logger.info("Init command execution started.");
        final int width = parseInt(commandArgs.getArgs()[1]);
        final int height = parseInt(commandArgs.getArgs()[2]);
        final int x = parseInt(commandArgs.getArgs()[3]);
        final int y = parseInt(commandArgs.getArgs()[4]);
        Coordinates coordinates = new Coordinates(x, y);
        logger.debug("Args parsed. Width = " + width + "; height = " + height + "; Coordinates = " + coordinates);
        commandArgs.getField().resize(width, height);
        logger.info("Field resized.");
        if(width > y && height > x){
            commandArgs.getExecutor().setCoordinates(coordinates);
            logger.info("Executor coordinates changed.");
        }
        else {
            logger.error("Got wrong executor coordinates. Throw IllegalArgumentException.");
            throw new IllegalArgumentException("InitCommand.execute error. Wrong executor coordinates.");
        }
        logger.debug("Init command execution finished.");
    }
}
