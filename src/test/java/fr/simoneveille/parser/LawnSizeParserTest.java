package fr.simoneveille.parser;

import fr.simoneveille.domain.LawnSize;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LawnSizeParserTest {
    private final LawnSizeParser parser = new LawnSizeParser();

    @Test
    void shouldParseValidLawnSize() throws InvalidInputException {
        LawnSize lawnSize = parser.parse(List.of("5 5"));

        assertEquals(new LawnSize(5, 5), lawnSize);
    }

    @Test
    void shouldParseLawnSizeWithExtraSpaces() throws InvalidInputException {
        LawnSize lawnSize = parser.parse(List.of("  5   5  "));

        assertEquals(new LawnSize(5, 5), lawnSize);
    }

    @Test
    void shouldRejectInputWithWrongNumberOfLines() {
        assertThrows(
                InvalidInputException.class,
                () -> parser.parse(List.of("5 5", "1 2 N"))
        );
    }

    @Test
    void shouldRejectInvalidLawnSizeValues() {
        assertAll(
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("5"))),
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("5 5 5"))),
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("abc 5"))),
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("-1 5")))
        );
    }
}