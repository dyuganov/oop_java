package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;

import static java.lang.Integer.parseInt;

public class TeleportCommand implements Command{
    private Executor executor = null;
    private Field field = null;
    private Coordinates coords = null;

    // TELEPORT <x> <y>
    public TeleportCommand(CommandArgs commandArgs){
        this.executor = commandArgs.getExecutor();
        this.field = commandArgs.getField();
        int x = parseInt(commandArgs.getArgs()[1]);
        int y = parseInt(commandArgs.getArgs()[2]);
        coords = new Coordinates(x, y);
    }

    @Override
    public void execute() {

    }

}
