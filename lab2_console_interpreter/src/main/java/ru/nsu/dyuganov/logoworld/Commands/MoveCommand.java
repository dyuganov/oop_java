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
        if(!isCorrectArgsNumber(commandArgs)){
            logger.debug("Move command execution finished.");
            return;
        }
        Direction moveDirection;
        switch (commandArgs.getArgs()[1]) {
            case "L" -> moveDirection = Direction.LEFT;
            case "D" -> moveDirection = Direction.DOWN;
            case "U" -> moveDirection = Direction.UP;
            case "R" -> moveDirection = Direction.RIGHT;
            default -> {
                System.err.println("Wrong direction.");
                logger.debug("Move command execution finished.");
                return;
            }
        }
        logger.debug("Direction parsed.");
        AbstractExecutor abstractExecutor = commandArgs.getExecutor();
        logger.debug("Got executor: " + abstractExecutor.toString());
        Field field = commandArgs.getField();
        logger.debug("Got field: " + field.toString());
        int stepsNumber = parseInt(commandArgs.getArgs()[2]);
        logger.debug("Steps number parsed: " + stepsNumber);
        if (!isCorrectStepsNumber(stepsNumber)) {
            logger.debug("Move command execution finished.");
            return;
        }
        if (abstractExecutor == null || field == null) {
            logger.error("Throw IllegalArgumentException exception. Executor or field == null.");
            throw new IllegalArgumentException("MoveCommand.execute() error. Got null argument.");
        }
        for (int i = 0; i < stepsNumber; ++i) {
            if (moveDirection == Direction.RIGHT && abstractExecutor.getCoordinates().getY() == field.getWidth() - 1) {
                logger.info("Moved over RIGHT side. Teleported to LEFT side.");
                abstractExecutor.teleport(new Coordinates(abstractExecutor.getCoordinates().getX(), 0));
            } else if (moveDirection == Direction.LEFT && abstractExecutor.getCoordinates().getY() == 0) {
                logger.info("Moved over LEFT side. Teleported to RIGHT side.");
                abstractExecutor.teleport(new Coordinates(abstractExecutor.getCoordinates().getX(), field.getWidth() - 1));
            } else if (moveDirection == Direction.UP && abstractExecutor.getCoordinates().getX() == 0) {
                logger.info("Moved over UP side. Teleported to DOWN side.");
                abstractExecutor.teleport(new Coordinates(field.getHeight() - 1, abstractExecutor.getCoordinates().getY()));
            } else if (moveDirection == Direction.DOWN && abstractExecutor.getCoordinates().getX() == field.getHeight() - 1) {
                logger.info("Moved over DOWN side. Teleported to UP side.");
                abstractExecutor.teleport(new Coordinates(0, abstractExecutor.getCoordinates().getY()));
            } else {
                abstractExecutor.move(moveDirection);
                logger.info("Executor moved " + moveDirection.toString());
            }
            if (abstractExecutor.isDrawing()) {
                field.setCell(abstractExecutor.getCoordinates(), Cell.FILLED);
                logger.info("Field cell set to FILLED at executor new coordinates: " + abstractExecutor.getCoordinates().toString());
            }
        }
        logger.debug("Move command execution finished.");
    }

    private boolean isCorrectArgsNumber(CommandArgs commandArgs){
        final int correctArgsNumber = 3;
        if(commandArgs.getArgs().length < correctArgsNumber){
            logger.error("Got wrong args number.");
            System.err.println("Wrong args number.");
            return false;
        }
        return true;
    }

    private boolean isCorrectStepsNumber(int stepsNumber){
        if(stepsNumber < 0){
            logger.error("Got wrong steps number.");
            System.err.println("Wrong steps number.");
            return false;
        }
        return true;
    }
}
