package main.ru.nsu.dyuagnov.logoworld.Commands;

import main.ru.nsu.dyuagnov.logoworld.Interpreter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
        if(commandArgs.getExecutor() == null){
            throw new IllegalArgumentException("WardCommand.execute() error. Got null argument.");
        }
        commandArgs.getExecutor().ward();
    }
}
