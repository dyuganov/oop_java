package test.ru.nsu.Dyuganov.LogoWorld;

import main.ru.nsu.Dyuagnov.LogoWorld.Commands.*;
import org.junit.jupiter.api.Test;
import main.ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;
import main.ru.nsu.Dyuagnov.LogoWorld.Executor.Executor;
import main.ru.nsu.Dyuagnov.LogoWorld.Executor.Robot;
import main.ru.nsu.Dyuagnov.LogoWorld.Field.Cell;
import main.ru.nsu.Dyuagnov.LogoWorld.Field.Field;

import static org.junit.jupiter.api.Assertions.*;

public class CommandsTest {
    @Test
    void initCommand(){
        Command initCommand = new InitCommand();
        Executor executor = new Robot(new Coordinates(0,0));
        Field field = new Field(10, 10);
        String[] args = {"INIT", "5", "6", "1", "2"};

        initCommand.execute(new CommandArgs(executor, field, args));
        assertEquals(5, field.getWidth());
        assertEquals(6, field.getHeight());
        assertEquals(1, executor.getCoordinates().getX());
        assertEquals(2, executor.getCoordinates().getY());

        assertThrows(RuntimeException.class, () -> initCommand.execute(null));
    }

    @Test
    void teleportCommand(){
        Command teleportCommand = new TeleportCommand();
        Executor executor = new Robot(new Coordinates(1,1));
        Field field = new Field(10, 10);
        String[] args = {"TELEPORT", "3", "4"};
        String[] incorrectArgs = {"TELEPORT", "-3", "-4"};
        CommandArgs commandArgs = new CommandArgs(executor, field, null);

        commandArgs.setArgs(args);
        teleportCommand.execute(commandArgs);
        assertEquals(3, executor.getCoordinates().getX());
        assertEquals(4, executor.getCoordinates().getY());

        commandArgs.setArgs(incorrectArgs);
        assertThrows(RuntimeException.class, () -> teleportCommand.execute(commandArgs));

        assertThrows(RuntimeException.class, () -> teleportCommand.execute(null));
    }

    @Test
    void moveCommand(){
        Command moveCommand = new MoveCommand();
        Executor executor = new Robot(new Coordinates(0,0));
        Field field = new Field(10, 10);
        String[] argsRight = {"MOVE", "R", "2"};
        String[] argsDown = {"MOVE", "D", "3"};
        String[] argsLeft = {"MOVE", "L", "2"};
        String[] argsUp = {"MOVE", "U", "3"};
        String[] incorrectArgs1 = {"MOVE", "U1"};
        String[] incorrectArgs2 = {"MOVE", "U", "-1"};
        CommandArgs commandArgs = new CommandArgs(executor, field, null);

        commandArgs.setArgs(argsRight);
        moveCommand.execute(commandArgs);
        assertEquals(2,executor.getCoordinates().getY());
        assertEquals(0,executor.getCoordinates().getX());

        commandArgs.setArgs(argsDown);
        moveCommand.execute(commandArgs);
        assertEquals(2,executor.getCoordinates().getY());
        assertEquals(3,executor.getCoordinates().getX());

        commandArgs.setArgs(argsLeft);
        moveCommand.execute(commandArgs);
        assertEquals(0,executor.getCoordinates().getY());
        assertEquals(3,executor.getCoordinates().getX());

        commandArgs.setArgs(argsUp);
        moveCommand.execute(commandArgs);
        assertEquals(0,executor.getCoordinates().getY());
        assertEquals(0,executor.getCoordinates().getX());

        commandArgs.setArgs(argsRight);
        executor.draw();
        moveCommand.execute(commandArgs);
        assertEquals(Cell.FILLED, field.getObject(new Coordinates(0, 1)));
        assertEquals(Cell.FILLED, field.getObject(new Coordinates(0, 2)));

        commandArgs.setArgs(incorrectArgs1);
        assertThrows(RuntimeException.class, () -> moveCommand.execute(commandArgs));

        commandArgs.setArgs(incorrectArgs2);
        assertThrows(RuntimeException.class, () -> moveCommand.execute(commandArgs));

        assertThrows(RuntimeException.class, () -> moveCommand.execute(null));
    }

    @Test
    void drawCommand(){
        final Command drawCommand = new DrawCommand();
        final Coordinates coordinates = new Coordinates(1,1);
        final Executor executor = new Robot(coordinates);
        final Field field = new Field(10, 10);
        String[] args = {"DRAW"};

        assertFalse(executor.isDrawing());
        drawCommand.execute(new CommandArgs(executor, field, args));
        assertTrue(executor.isDrawing());
        assertEquals(Cell.FILLED, field.getObject(coordinates));

        assertThrows(RuntimeException.class, () -> drawCommand.execute(null));
    }

    @Test
    void wardCommand(){
        Command wardCommand = new WardCommand();
        Executor executor = new Robot(new Coordinates(1,1));
        Field field = new Field(10, 10);
        String[] args = {"WARD"};

        assertFalse(executor.isDrawing());
        wardCommand.execute(new CommandArgs(executor, field, args));
        assertFalse(executor.isDrawing());

        executor.draw();
        assertTrue(executor.isDrawing());
        wardCommand.execute(new CommandArgs(executor, field, args));
        assertFalse(executor.isDrawing());

        assertThrows(RuntimeException.class, () -> wardCommand.execute(null));
    }
}
