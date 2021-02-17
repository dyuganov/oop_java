package main.ru.nsu.dyuagnov.logoworld.Commands;

/**
 * Command, which can be executed with different parameters.
 * */
public interface Command {
    /**
     * @param commandArgs new arguments for command.
     * */
    void execute(CommandArgs commandArgs);
}
