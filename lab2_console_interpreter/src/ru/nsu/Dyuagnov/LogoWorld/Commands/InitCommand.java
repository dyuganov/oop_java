package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;

import static java.lang.Integer.parseInt;

public class InitCommand implements Command{
    final private Executor executor;
    private Field field;
    final int width;
    final private int height;
    final private Coordinates coords;

    // INIT <width> <height> <x> <y>
    public InitCommand(CommandArgs commandArgs){
        this.executor = commandArgs.getExecutor();
        this.field = commandArgs.getField();
        this.width = parseInt(commandArgs.getArgs()[1]);
        this.height = parseInt(commandArgs.getArgs()[2]);
        int x = parseInt(commandArgs.getArgs()[3]);
        int y = parseInt(commandArgs.getArgs()[4]);
        coords = new Coordinates(x, y);
    }

    @Override
    public void execute() {
        field.resize(width, height);
        if(width > coords.getY() && height > coords.getX()){
            executor.setCoordinates(coords);
        }
        else {
            throw new IllegalArgumentException("InitCommand.execute error. Wrong executor coordinates.");
        }

    }
}
