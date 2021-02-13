package ru.nsu.Dyuagnov.LogoWorld.Commands;

/**
 * Format: WARD
 * */
public final class WardCommand implements Command{
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
