package ru.nsu.dyuganov.logoworld;

import org.junit.jupiter.api.Test;
import ru.nsu.dyuganov.logoworld.Coordinates.Coordinates;
import ru.nsu.dyuganov.logoworld.Field.Cell;
import ru.nsu.dyuganov.logoworld.Field.Field;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FieldTest {
    private Field field = new Field(10, 10);

    @Test
    void resize() {
        // init is correct check
        assertEquals(10, field.getHeight());
        assertEquals(10, field.getWidth());

        // normal set case
        field.resize(15, 15);
        assertEquals(15, field.getHeight());
        assertEquals(15, field.getWidth());

        // incorrect size case
        assertThrows(RuntimeException.class, () -> field.resize(-10, -10));
    }

    @Test
    void setObject() {
        // init is correct check
        final Coordinates coordinates = new Coordinates(0, 0);
        assertEquals(Cell.EMPTY, field.getCell(coordinates));

        // normal set case
        field.setCell(coordinates, Cell.FILLED);
        assertEquals(Cell.FILLED, field.getCell(coordinates));

        // double set case
        field.setCell(coordinates, Cell.EMPTY);
        field.setCell(coordinates, Cell.EMPTY);
        assertEquals(Cell.EMPTY, field.getCell(coordinates));
    }
}
