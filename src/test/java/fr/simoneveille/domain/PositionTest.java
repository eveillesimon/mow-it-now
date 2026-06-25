package fr.simoneveille.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionTest {
    @Test
    void shouldMoveForwardAccordingToOrientation() {
        assertEquals(
                new Position(1, 3, Orientation.NORTH),
                new Position(1, 2, Orientation.NORTH).forward()
        );

        assertEquals(
                new Position(2, 2, Orientation.EAST),
                new Position(1, 2, Orientation.EAST).forward()
        );

        assertEquals(
                new Position(0, 2, Orientation.WEST),
                new Position(1, 2, Orientation.WEST).forward()
        );

        assertEquals(
                new Position(1, 1, Orientation.SOUTH),
                new Position(1, 2, Orientation.SOUTH).forward()
        );
    }

    @Test
    void shouldTurnWithoutChangingCoordinates() {
        Position position = new Position(1, 2, Orientation.NORTH);

        Position leftPosition = position.turnLeft();
        Position rightPosition = position.turnRight();

        assertAll(
                () -> assertEquals(1, leftPosition.x()),
                () -> assertEquals(2, leftPosition.y()),
                () -> assertEquals(Orientation.WEST, leftPosition.orientation()),

                () -> assertEquals(1, rightPosition.x()),
                () -> assertEquals(2, rightPosition.y()),
                () -> assertEquals(Orientation.EAST, rightPosition.orientation())
        );
    }

    @Test
    void shouldRejectNullOrientation() {
        NullPointerException exception = assertThrows(
                NullPointerException.class,
                () -> new Position(1, 2, null)
        );

        assertEquals("orientation must not be null", exception.getMessage());
    }
}