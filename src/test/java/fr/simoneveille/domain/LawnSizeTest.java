package fr.simoneveille.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LawnSizeTest {
    @Test
    void shouldContainPositionsInsideLawn() {
        LawnSize lawnSize = new LawnSize(6, 6);

        assertTrue(lawnSize.contains(new Position(0, 0, Orientation.NORTH)));
        assertTrue(lawnSize.contains(new Position(3, 4, Orientation.EAST)));
        assertTrue(lawnSize.contains(new Position(5, 5, Orientation.SOUTH)));
    }

    @Test
    void shouldNotContainPositionsOutsideLawn() {
        LawnSize lawnSize = new LawnSize(6, 6);

        assertFalse(lawnSize.contains(new Position(-1, 0, Orientation.NORTH)));
        assertFalse(lawnSize.contains(new Position(0, -1, Orientation.NORTH)));
        assertFalse(lawnSize.contains(new Position(6, 5, Orientation.NORTH)));
        assertFalse(lawnSize.contains(new Position(5, 6, Orientation.NORTH)));
    }

    @Test
    void shouldRejectNegativeSize() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new LawnSize(-1, 6)),
                () -> assertThrows(IllegalArgumentException.class, () -> new LawnSize(6, -1))
        );
    }
}