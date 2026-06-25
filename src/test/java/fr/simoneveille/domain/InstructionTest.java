package fr.simoneveille.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionTest {
    @Test
    void shouldTurnLeft() {
        Position position = new Position(1, 2, Orientation.NORTH);

        Position result = Instruction.TURN_LEFT.apply(position);

        assertEquals(new Position(1, 2, Orientation.WEST), result);
    }

    @Test
    void shouldTurnRight() {
        Position position = new Position(1, 2, Orientation.NORTH);

        Position result = Instruction.TURN_RIGHT.apply(position);

        assertEquals(new Position(1, 2, Orientation.EAST), result);
    }

    @Test
    void shouldMoveForward() {
        Position position = new Position(1, 2, Orientation.NORTH);

        Position result = Instruction.MOVE_FORWARD.apply(position);

        assertEquals(new Position(1, 3, Orientation.NORTH), result);
    }
}