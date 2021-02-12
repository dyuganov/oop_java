package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Coordinates;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;
import ru.nsu.Dyuagnov.LogoWorld.Field.Cell;

import static java.lang.Integer.parseInt;

public final class TeleportCommand implements Command{
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
    public void execute(CommandArgs commandArgs) {
        if(executor == null || field == null){
            throw new IllegalArgumentException("TeleportCommand.execute() error. Got null argument.");
        }
        executor.teleport(coords);
        if(executor.isDrawing()){
            field.setObject(executor.getCoordinates(), Cell.FILLED);
        }
    }

}
