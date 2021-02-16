package ru.nsu.dyuganov.logoworld;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import main.ru.nsu.dyuagnov.logoworld.Coordinates.Coordinates;
import main.ru.nsu.dyuagnov.logoworld.Executor.Direction;
import main.ru.nsu.dyuagnov.logoworld.Executor.Robot;

public class RobotTest {
    private final Robot robot = new Robot(new Coordinates(0, 0));

    @Test
    void directionMovement(){
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
    }

    @Test
    void teleportation(){
        robot.teleport(new Coordinates(5, 6));
        assertEquals(5, robot.getCoordinates().getX());
        assertEquals(6, robot.getCoordinates().getY());

        robot.teleport(new Coordinates(0, 0));
        assertEquals(0, robot.getCoordinates().getX());
        assertEquals(0, robot.getCoordinates().getY());

        Exception exception = assertThrows(RuntimeException.class,
                () -> robot.teleport(new Coordinates(-1, -1)));
    }

    @Test
    void drawMode(){
        // normal case
        robot.draw();
        assertTrue(robot.isDrawing());

        // return value check
        assertEquals(robot.getCoordinates(), robot.draw());

        // ward check
        robot.ward();
        assertFalse(robot.isDrawing());
    }
}
