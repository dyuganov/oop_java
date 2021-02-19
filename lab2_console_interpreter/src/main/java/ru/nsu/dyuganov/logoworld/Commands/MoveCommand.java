package ru.nsu.dyuganov.logoworld.Commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import ru.nsu.dyuganov.logoworld.AbstractExecutor.AbstractExecutor;
import ru.nsu.dyuganov.logoworld.Coordinates.Coordinates;
import ru.nsu.dyuganov.logoworld.AbstractExecutor.Direction;
import ru.nsu.dyuganov.logoworld.Field.Cell;
import ru.nsu.dyuganov.logoworld.Field.Field;

import static java.lang.Integer.parseInt;

/**
 * Format: MOVE [L|R|U|D] <steps>
 */
public final class MoveCommand implements Command {
    private final static Logger logger = LogManager.getLogger(MoveCommand.class);

    public MoveCommand() {
        DOMConfigurator.configure("src/main/resources/ru.nsu.dyuganov.logoworld/log4j.xml");
    }

    /**
     * Moves executor. If draw mode is on, changes field cells.
     * Checks edges while moving.
     *
     * @param commandArgs arguments for execution.
     */
    @Override
    public void execute(CommandArgs commandArgs) {
        logger.debug("Move command execution started.");
        Direction direction;
        switch (commandArgs.getArgs()[1]) {
            case "L" -> direction = Direction.LEFT;
            case "D" -> direction = Direction.DOWN;
            case "U" -> direction = Direction.UP;
            case "R" -> direction = Direction.RIGHT;
            default -> throw new IllegalArgumentException("Wrong move command direction.");
        }
        logger.debug("Direction parsed.");
        AbstractExecutor abstractExecutor = commandArgs.getExecutor();
        logger.debug("Got executor: " + abstractExecutor.toString());
        Field field = commandArgs.getField();
        logger.debug("Got field: " + field.toString());
        int stepsN = parseInt(commandArgs.getArgs()[2]);
        logger.debug("Steps number parsed: " + stepsN);
        if (stepsN < 0) {
            logger.error("Throw IllegalArgumentException exception. StepsN < 0.");
            throw new IllegalArgumentException("Got negative steps.");
        }
        if (abstractExecutor == null || field == null) {
            logger.error("Throw IllegalArgumentException exception. ru.nsu.dyuganov.logoworld.Executor or field == null.");
            throw new IllegalArgumentException("MoveCommand.execute() error. Got null argument.");
        }
        for (int i = 0; i < stepsN; ++i) {
            if (direction == Direction.RIGHT && abstractExecutor.getCoordinates().getY() == field.getWidth() - 1) {
                logger.info("Moved over RIGHT side. Teleported to LEFT side.");
                abstractExecutor.teleport(new Coordinates(abstractExecutor.getCoordinates().getX(), 0));
            } else if (direction == Direction.LEFT && abstractExecutor.getCoordinates().getY() == 0) {
                logger.info("Moved over LEFT side. Teleported to RIGHT side.");
                abstractExecutor.teleport(new Coordinates(abstractExecutor.getCoordinates().getX(), field.getWidth() - 1));
            } else if (direction == Direction.UP && abstractExecutor.getCoordinates().getX() == 0) {
                logger.info("Moved over UP side. Teleported to DOWN side.");
                abstractExecutor.teleport(new Coordinates(field.getHeight() - 1, abstractExecutor.getCoordinates().getY()));
            } else if (direction == Direction.DOWN && abstractExecutor.getCoordinates().getX() == field.getHeight() - 1) {
                logger.info("Moved over DOWN side. Teleported to UP side.");
                abstractExecutor.teleport(new Coordinates(0, abstractExecutor.getCoordinates().getY()));
            } else {
                abstractExecutor.move(direction);
                logger.info("ru.nsu.dyuganov.logoworld.Executor moved " + direction.toString());
            }
            if (abstractExecutor.isDrawing()) {
                field.setCell(abstractExecutor.getCoordinates(), Cell.FILLED);
                logger.info("ru.nsu.dyuganov.logoworld.Field cell set to FILLED at executor new coordinates: " + abstractExecutor.getCoordinates().toString());
            }
        }
        logger.debug("Move command execution finished.");
    }
}
