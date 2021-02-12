package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;

import static java.lang.Integer.parseInt;

public final class InitCommand implements Command{

    // INIT <width> <height> <x> <y>
    public InitCommand(){}

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
