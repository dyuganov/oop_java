package main.ru.nsu.dyuagnov.logoworld.Commands;

import main.ru.nsu.dyuagnov.logoworld.Interpreter;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Format: WARD
 * */
public final class WardCommand implements Command{
    private final static Logger logger = LogManager.getLogger(String.valueOf(Interpreter.class));
    public WardCommand(){}

    /**
     * Turns off executor draw mode.
     * @param commandArgs - arguments for execution.
     * */
    @Override
    public void execute(CommandArgs commandArgs) {
        DOMConfigurator.configure("src/java/resources/log4j.xml");
        logger.setLevel(Level.DEBUG);
        logger.debug("Ward command execution started.");
        if(commandArgs.getExecutor() == null){
            logger.error("Throw IllegalArgumentException. Executor is null.");
            throw new IllegalArgumentException("WardCommand.execute() error. Got null argument.");
        }
        commandArgs.getExecutor().ward();
        logger.info("Executor mode set to ward mode.");
        logger.debug("Ward command execution finished.");
    }
}
