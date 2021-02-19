package ru.nsu.dyuganov.logoworld;

import org.junit.jupiter.api.Test;
import ru.nsu.dyuganov.logoworld.AbstractExecutor.AbstractExecutor;
import ru.nsu.dyuganov.logoworld.Commands.*;
import ru.nsu.dyuganov.logoworld.Coordinates.Coordinates;
import ru.nsu.dyuganov.logoworld.AbstractExecutor.Robot;
import ru.nsu.dyuganov.logoworld.Field.Cell;
import ru.nsu.dyuganov.logoworld.Field.Field;

import static org.junit.jupiter.api.Assertions.*;

public class CommandsTest {
    @Test
    void initCommand() {
        Command initCommand = new InitCommand();
        AbstractExecutor abstractExecutor = new Robot(new Coordinates(0, 0));
        Field field = new Field(10, 10);
        String[] args = {"INIT", "5", "6", "1", "2"};

        // normal use
        initCommand.execute(new CommandArgs(abstractExecutor, field, args));
        assertEquals(5, field.getWidth());
        assertEquals(6, field.getHeight());
        assertEquals(1, abstractExecutor.getCoordinates().getX());
        assertEquals(2, abstractExecutor.getCoordinates().getY());

        // null args
        assertThrows(RuntimeException.class, () -> initCommand.execute(null));
    }

    @Test
    void teleportCommand() {
        Command teleportCommand = new TeleportCommand();
        AbstractExecutor abstractExecutor = new Robot(new Coordinates(1, 1));
        Field field = new Field(10, 10);
        String[] args = {"TELEPORT", "3", "4"};
        String[] incorrectArgs = {"TELEPORT", "-3", "-4"};
        CommandArgs commandArgs = new CommandArgs(abstractExecutor, field, null);

        // normal use
        commandArgs.setArgs(args);
        teleportCommand.execute(commandArgs);
        assertEquals(3, abstractExecutor.getCoordinates().getX());
        assertEquals(4, abstractExecutor.getCoordinates().getY());

        // incorrect args
        commandArgs.setArgs(incorrectArgs);
        assertThrows(RuntimeException.class, () -> teleportCommand.execute(commandArgs));

        // null args
        assertThrows(RuntimeException.class, () -> teleportCommand.execute(null));
    }

    @Test
    void moveCommand() {
        Command moveCommand = new MoveCommand();
        AbstractExecutor abstractExecutor = new Robot(new Coordinates(0, 0));
        Field field = new Field(10, 10);
        String[] argsRight = {"MOVE", "R", "2"};
        String[] argsDown = {"MOVE", "D", "3"};
        String[] argsLeft = {"MOVE", "L", "2"};
        String[] argsUp = {"MOVE", "U", "3"};
        String[] wrongDirectionArgs = {"MOVE", "U1", "1"};
        String[] wrongStepNumberArgs = {"MOVE", "U", "-1"};
        String[] noStepsNumberArgs = {"MOVE", "U"};
        CommandArgs commandArgs = new CommandArgs(abstractExecutor, field, null);

        // normal use RIGHT
        commandArgs.setArgs(argsRight);
        moveCommand.execute(commandArgs);
        assertEquals(2, abstractExecutor.getCoordinates().getY());
        assertEquals(0, abstractExecutor.getCoordinates().getX());

        // normal use DOWN
        commandArgs.setArgs(argsDown);
        moveCommand.execute(commandArgs);
        assertEquals(2, abstractExecutor.getCoordinates().getY());
        assertEquals(3, abstractExecutor.getCoordinates().getX());

        // normal use LEFT
        commandArgs.setArgs(argsLeft);
        moveCommand.execute(commandArgs);
        assertEquals(0, abstractExecutor.getCoordinates().getY());
        assertEquals(3, abstractExecutor.getCoordinates().getX());

        // normal use UP
        commandArgs.setArgs(argsUp);
        moveCommand.execute(commandArgs);
        assertEquals(0, abstractExecutor.getCoordinates().getY());
        assertEquals(0, abstractExecutor.getCoordinates().getX());

        // normal use DRAW and move
        commandArgs.setArgs(argsRight);
        abstractExecutor.draw();
        moveCommand.execute(commandArgs);
        assertEquals(Cell.FILLED, field.getCell(new Coordinates(0, 1)));
        assertEquals(Cell.FILLED, field.getCell(new Coordinates(0, 2)));

        // wrong direction
        commandArgs.setArgs(wrongDirectionArgs);
        assertThrows(RuntimeException.class, () -> moveCommand.execute(commandArgs));

        // wrong steps number
        commandArgs.setArgs(wrongStepNumberArgs);
        assertThrows(RuntimeException.class, () -> moveCommand.execute(commandArgs));

        // no steps number
        commandArgs.setArgs(noStepsNumberArgs);
        assertThrows(RuntimeException.class, () -> moveCommand.execute(commandArgs));

        // null args
        assertThrows(RuntimeException.class, () -> moveCommand.execute(null));
    }

    @Test
    void drawCommand() {
        final Command drawCommand = new DrawCommand();
        final Coordinates coordinates = new Coordinates(1, 1);
        final AbstractExecutor abstractExecutor = new Robot(coordinates);
        final Field field = new Field(10, 10);
        String[] args = {"DRAW"};

        // normal use
        assertFalse(abstractExecutor.isDrawing());
        drawCommand.execute(new CommandArgs(abstractExecutor, field, args));
        assertTrue(abstractExecutor.isDrawing());
        assertEquals(Cell.FILLED, field.getCell(coordinates));

        // null args
        assertThrows(RuntimeException.class, () -> drawCommand.execute(null));
    }

    @Test
    void wardCommand() {
        Command wardCommand = new WardCommand();
        AbstractExecutor abstractExecutor = new Robot(new Coordinates(1, 1));
        Field field = new Field(10, 10);
        String[] args = {"WARD"};
        CommandArgs commandArgs = new CommandArgs(abstractExecutor, field, args);

        // normal use
        abstractExecutor.draw();
        assertTrue(abstractExecutor.isDrawing());
        wardCommand.execute(commandArgs);
        assertFalse(abstractExecutor.isDrawing());

        // non-drawing
        assertFalse(abstractExecutor.isDrawing());
        wardCommand.execute(commandArgs);
        assertFalse(abstractExecutor.isDrawing());

        // null args
        assertThrows(RuntimeException.class, () -> wardCommand.execute(null));
    }
}
