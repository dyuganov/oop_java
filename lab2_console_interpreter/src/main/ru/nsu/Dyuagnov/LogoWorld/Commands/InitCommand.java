package main.ru.nsu.Dyuagnov.LogoWorld.Commands;

import main.ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;

import static java.lang.Integer.parseInt;


/**
 * Format: INIT <width> <height> <x> <y>
 * */
public final class InitCommand implements Command{
    public InitCommand(){}

    /**
     * Changes field size
     * @param commandArgs - arguments for execution.
     * */
    @Override
    public void execute(CommandArgs commandArgs) {
        final int width = parseInt(commandArgs.getArgs()[1]);
        final int height = parseInt(commandArgs.getArgs()[2]);
        final int x = parseInt(commandArgs.getArgs()[3]);
        final int y = parseInt(commandArgs.getArgs()[4]);

        commandArgs.getField().resize(width, height);
        if(width > y && height > x){
            commandArgs.getExecutor().setCoordinates(new Coordinates(x, y));
        }
        else {
            throw new IllegalArgumentException("InitCommand.execute error. Wrong executor coordinates.");
        }

    }
}
