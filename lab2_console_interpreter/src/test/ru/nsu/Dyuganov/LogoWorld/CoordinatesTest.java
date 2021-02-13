package test.ru.nsu.Dyuganov.LogoWorld;

import org.junit.jupiter.api.Test;
import ru.nsu.Dyuagnov.LogoWorld.Coordinates.Coordinates;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinatesTest {
    private Coordinates coordinates = new Coordinates(1, 2);

    @Test
    void constructor(){
        // init is correct check
        assertEquals(1, coordinates.getX());
        assertEquals(2, coordinates.getY());

        // incorrect values init test
        assertThrows(RuntimeException.class, () -> new Coordinates(-1, -1));
    }

    @Test
    void setCoordinates(){
        coordinates.setX(4);
        assertEquals(4, coordinates.getX());

        coordinates.setY(5);
        assertEquals(5, coordinates.getY());
    }
}
