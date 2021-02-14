package main.ru.nsu.Dyuagnov.LogoWorld.Commands;

import main.ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;
import main.ru.nsu.Dyuagnov.LogoWorld.Executor.Direction;
import main.ru.nsu.Dyuagnov.LogoWorld.Field.Cell;
import main.ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import main.ru.nsu.Dyuagnov.LogoWorld.Field.Field;

import static java.lang.Integer.parseInt;

/**
 * Format: MOVE [L|R|U|D] <steps>
 * */
public final class MoveCommand implements Command{
    public MoveCommand(){}

    /**
     * Moves executor. If draw mode is on, changes field cells.
     * Checks edges while moving.
     * @param commandArgs - arguments for execution.
     * */
    @Override
    public void execute(CommandArgs commandArgs) {
        Direction direction;
        switch (commandArgs.getArgs()[1]){
            case "L"->direction = Direction.LEFT;
            case "D"->direction = Direction.DOWN;
            case "U"->direction = Direction.UP;
            case "R"->direction = Direction.RIGHT;
            default -> throw new IllegalArgumentException("Wrong move command direction.");
        }

        Executor executor = commandArgs.getExecutor();
        Field field = commandArgs.getField();
        int stepsN = parseInt(commandArgs.getArgs()[2]);
        if(stepsN < 0){
            throw new IllegalArgumentException("Got negative steps.");
        }
        if(executor == null || field == null){
            throw new IllegalArgumentException("MoveCommand.execute() error. Got null argument.");
        }
        // edges check
        for(int i = 0; i < stepsN; ++i){
            if(direction == Direction.RIGHT && executor.getCoordinates().getY() == field.getWidth() - 1){
                executor.teleport(new Coordinates(executor.getCoordinates().getX(), 0));
            }
            else if(direction == Direction.LEFT && executor.getCoordinates().getY() == 0){
                executor.teleport(new Coordinates(executor.getCoordinates().getX(), field.getWidth() - 1));
            }
            else if(direction == Direction.UP && executor.getCoordinates().getX() == 0){
                executor.teleport(new Coordinates(field.getHeight() - 1, executor.getCoordinates().getY()));
            }
            else if(direction == Direction.DOWN && executor.getCoordinates().getX() == field.getHeight() - 1){
                executor.teleport(new Coordinates(0, executor.getCoordinates().getY()));
            }
            else{
                executor.move(direction);
            }
            if(executor.isDrawing()){
                field.setObject(executor.getCoordinates(), Cell.FILLED);
            }
        }
    }
}
