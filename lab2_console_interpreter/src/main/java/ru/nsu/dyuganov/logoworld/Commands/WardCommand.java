package ru.nsu.dyuganov.logoworld.Commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.nsu.dyuganov.logoworld.Interpreter.Interpreter;

/**
 * Format: WARD
 */
public final class WardCommand implements Command {
    private final static Logger logger = LogManager.getLogger(String.valueOf(Interpreter.class));

    public WardCommand() {
        DOMConfigurator.configure("src/main/resources/ru.nsu.dyuganov.logoworld/log4j.xml");
    }

    /**
     * Turns off executor draw mode.
     *
     * @param commandArgs arguments for execution.
     */
    @Override
    public void execute(CommandArgs commandArgs) {
        logger.debug("Ward command execution started.");
        if (commandArgs.getExecutor() == null) {
            logger.error("Throw IllegalArgumentException. Executor is null.");
            throw new IllegalArgumentException("WardCommand.execute() error. Got null argument.");
        }
        commandArgs.getExecutor().ward();
        logger.info("Executor mode set to ward mode.");
        logger.debug("Ward command execution finished.");
    }
}
