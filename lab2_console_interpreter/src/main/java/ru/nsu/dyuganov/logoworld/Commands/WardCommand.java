package ru.nsu.dyuganov.logoworld.Commands;

import ru.nsu.dyuganov.logoworld.Interpreter.Interpreter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Format: WARD
 * */
public final class WardCommand implements Command{
    private final static Logger logger = LogManager.getLogger(String.valueOf(Interpreter.class));
    public WardCommand(){
        DOMConfigurator.configure("src/main/resources/ru.nsu.dyuganov.logoworld/log4j.xml");
    }

    /**
     * Turns off executor draw mode.
     * @param commandArgs arguments for execution.
     * */
    @Override
    public void execute(CommandArgs commandArgs) {
        logger.debug("Ward command execution started.");
        if(commandArgs.getExecutor() == null){
            logger.error("Throw IllegalArgumentException. ru.nsu.dyuganov.logoworld.Executor is null.");
            throw new IllegalArgumentException("WardCommand.execute() error. Got null argument.");
        }
        commandArgs.getExecutor().ward();
        logger.info("ru.nsu.dyuganov.logoworld.Executor mode set to ward mode.");
        logger.debug("Ward command execution finished.");
    }
}
