package fr.simoneveille.parser;

import fr.simoneveille.domain.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MowingProgramInputParserTest {
    private final MowingProgramInputParser parser = new MowingProgramInputParser();

    @Test
    void shouldParseValidMowingProgramInput() throws InvalidInputException {
        MowingProgramInput input = parser.parse(List.of(
                "5 5",
                "1 2 N",
                "GAGAGAGAA",
                "3 3 E",
                "AADAADADDA"
        ));

        assertEquals(new LawnSize(6, 6), input.lawnSize());
        assertEquals(2, input.programs().size());

        assertEquals(
                new MowerProgram(
                        new Position(1, 2, Orientation.NORTH),
                        List.of(
                                Instruction.TURN_LEFT,
                                Instruction.MOVE_FORWARD,
                                Instruction.TURN_LEFT,
                                Instruction.MOVE_FORWARD,
                                Instruction.TURN_LEFT,
                                Instruction.MOVE_FORWARD,
                                Instruction.TURN_LEFT,
                                Instruction.MOVE_FORWARD,
                                Instruction.MOVE_FORWARD
                        )
                ),
                input.programs().get(0)
        );

        assertEquals(
                new MowerProgram(
                        new Position(3, 3, Orientation.EAST),
                        List.of(
                                Instruction.MOVE_FORWARD,
                                Instruction.MOVE_FORWARD,
                                Instruction.TURN_RIGHT,
                                Instruction.MOVE_FORWARD,
                                Instruction.MOVE_FORWARD,
                                Instruction.TURN_RIGHT,
                                Instruction.MOVE_FORWARD,
                                Instruction.TURN_RIGHT,
                                Instruction.TURN_RIGHT,
                                Instruction.MOVE_FORWARD
                        )
                ),
                input.programs().get(1)
        );
    }

    @Test
    void shouldRejectInputWithLessThanThreeLines() {
        assertAll(
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of())),
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("5 5"))),
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("5 5", "1 2 N")))
        );
    }

    @Test
    void shouldRejectInputWithInvalidMowerPrograms() {
        assertAll(
                () -> assertThrows(
                        InvalidInputException.class,
                        () -> parser.parse(List.of("5 5", "1 2 N", "GAG", "3 3 E"))
                ),
                () -> assertThrows(
                        InvalidInputException.class,
                        () -> parser.parse(List.of("5 5", "1 2 X", "GAG"))
                ),
                () -> assertThrows(
                        InvalidInputException.class,
                        () -> parser.parse(List.of("5 5", "1 2 N", "GAX"))
                )
        );
    }
}