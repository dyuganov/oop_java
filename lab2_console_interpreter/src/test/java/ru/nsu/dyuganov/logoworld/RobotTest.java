package ru.nsu.dyuganov.logoworld;

import org.junit.jupiter.api.Test;
import ru.nsu.dyuganov.logoworld.Coordinates.Coordinates;
import ru.nsu.dyuganov.logoworld.AbstractExecutor.Direction;
import ru.nsu.dyuganov.logoworld.AbstractExecutor.Robot;

import static org.junit.jupiter.api.Assertions.*;

public class RobotTest {
    private final Robot robot = new Robot(new Coordinates(0, 0));

    @Test
    void directionMovement() {
        // normal use
        robot.move(Direction.RIGHT);
        assertEquals(0, robot.getCoordinates().getX());
        assertEquals(1, robot.getCoordinates().getY());

        robot.move(Direction.DOWN);
        assertEquals(1, robot.getCoordinates().getX());
        assertEquals(1, robot.getCoordinates().getY());

        robot.move(Direction.LEFT);
        assertEquals(1, robot.getCoordinates().getX());
        assertEquals(0, robot.getCoordinates().getY());

        robot.move(Direction.UP);
        assertEquals(0, robot.getCoordinates().getX());
        assertEquals(0, robot.getCoordinates().getY());

        // null arg
        assertThrows(RuntimeException.class, () -> robot.move(null));
    }

    @Test
    void teleportation() {
        robot.teleport(new Coordinates(5, 6));
        assertEquals(5, robot.getCoordinates().getX());
        assertEquals(6, robot.getCoordinates().getY());

        // normal use
        robot.teleport(new Coordinates(0, 0));
        assertEquals(0, robot.getCoordinates().getX());
        assertEquals(0, robot.getCoordinates().getY());

        // negative coordinates
        assertThrows(RuntimeException.class, () -> robot.teleport(new Coordinates(-1, -1)));
    }

    @Test
    void drawMode() {
        // normal case
        robot.draw();
        assertTrue(robot.isDrawing());

        // ward check
        robot.ward();
        assertFalse(robot.isDrawing());
    }
}
