package ru.nsu.Dyuagnov.LogoWorld.Commands;

import ru.nsu.Dyuagnov.LogoWorld.Executor.Direction;
import ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import ru.nsu.Dyuagnov.LogoWorld.Field.Field;
import ru.nsu.Dyuagnov.LogoWorld.Field.Cell;

import static java.lang.Integer.parseInt;

public class MoveCommand implements Command{
    private Executor executor = null;
    private Field field = null;
    Direction direction;
    int stepsN = 1;

    // MOVE [L|R|U|D] <steps>
    public MoveCommand(CommandArgs commandArgs){
        this.executor = commandArgs.getExecutor();
        this.field = commandArgs.getField();
        this.stepsN = parseInt(commandArgs.getArgs()[2]);
        switch (commandArgs.getArgs()[1]){
            case "L"->direction = Direction.LEFT;
            case "D"->direction = Direction.DOWN;
            case "U"->direction = Direction.UP;
            case "R"->direction = Direction.RIGHT;
            default -> throw new IllegalArgumentException("Wrong move command direction.");
        }
    }

    @Override
    public void execute() {
        if(executor == null || field == null){
            throw new IllegalArgumentException("MoveCommand.execute() error. Got null argument.");
        }
        for(int i = 0; i < stepsN; ++i){
            executor.move(direction);// TODO: обработка границ
            if(executor.isDrawing()){
                field.setObject(executor.getCoordinates(), Cell.FILLED);
            }
        }
    }
}
