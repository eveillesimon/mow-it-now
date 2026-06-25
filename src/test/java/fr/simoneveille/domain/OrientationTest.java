package fr.simoneveille.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrientationTest {
    @Test
    void shouldReturnSymbols() {
        assertEquals("N", Orientation.NORTH.symbol());
        assertEquals("S", Orientation.SOUTH.symbol());
        assertEquals("E", Orientation.EAST.symbol());
        assertEquals("W", Orientation.WEST.symbol());
    }

    @Test
    void shouldTurnLeft() {
        assertEquals(Orientation.WEST, Orientation.NORTH.turnLeft());
        assertEquals(Orientation.SOUTH, Orientation.WEST.turnLeft());
        assertEquals(Orientation.EAST, Orientation.SOUTH.turnLeft());
        assertEquals(Orientation.NORTH, Orientation.EAST.turnLeft());
    }

    @Test
    void shouldTurnRight() {
        assertEquals(Orientation.EAST, Orientation.NORTH.turnRight());
        assertEquals(Orientation.SOUTH, Orientation.EAST.turnRight());
        assertEquals(Orientation.WEST, Orientation.SOUTH.turnRight());
        assertEquals(Orientation.NORTH, Orientation.WEST.turnRight());
    }
}