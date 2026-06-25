package fr.simoneveille.parser;

import fr.simoneveille.domain.Orientation;
import fr.simoneveille.domain.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PositionParserTest {
    private final PositionParser parser = new PositionParser();

    @Test
    void shouldParseValidPosition() throws InvalidInputException {
        Position position = parser.parse(List.of("1 2 N"));

        assertEquals(new Position(1, 2, Orientation.NORTH), position);
    }

    @Test
    void shouldParsePositionWithExtraSpaces() throws InvalidInputException {
        Position position = parser.parse(List.of("  3   4   E  "));

        assertEquals(new Position(3, 4, Orientation.EAST), position);
    }

    @Test
    void shouldRejectInputWithWrongNumberOfLines() {
        assertAll(
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of())),
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("1 2 N", "3 3 E")))
        );
    }

    @Test
    void shouldRejectInvalidPositionValues() {
        assertAll(
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("1 2"))),
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("1 2 N X"))),
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("abc 2 N"))),
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("1 -2 N"))),
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("1 2 X")))
        );
    }
}