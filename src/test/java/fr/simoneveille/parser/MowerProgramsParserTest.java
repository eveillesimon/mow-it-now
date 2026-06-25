package fr.simoneveille.parser;

import fr.simoneveille.domain.Instruction;
import fr.simoneveille.domain.MowerProgram;
import fr.simoneveille.domain.Orientation;
import fr.simoneveille.domain.Position;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MowerProgramsParserTest {
    private final MowerProgramsParser parser = new MowerProgramsParser();

    @Test
    void shouldParseSingleMowerProgram() throws InvalidInputException {
        List<MowerProgram> mowerPrograms = parser.parse(List.of(
                "1 2 N",
                "GDA"
        ));

        assertEquals(
                List.of(
                        new MowerProgram(
                                new Position(1, 2, Orientation.NORTH),
                                List.of(
                                        Instruction.TURN_LEFT,
                                        Instruction.TURN_RIGHT,
                                        Instruction.MOVE_FORWARD
                                )
                        )
                ),
                mowerPrograms
        );
    }

    @Test
    void shouldParseMultipleMowerPrograms() throws InvalidInputException {
        List<MowerProgram> mowerPrograms = parser.parse(List.of(
                "1 2 N",
                "GAGAGAGAA",
                "3 3 E",
                "AADAADADDA"
        ));

        assertEquals(2, mowerPrograms.size());

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
                mowerPrograms.get(0)
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
                mowerPrograms.get(1)
        );
    }

    @Test
    void shouldRejectInputWithWrongNumberOfLines() {
        assertAll(
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of())),
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("1 2 N"))),
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("1 2 N", "GDA", "3 3 E")))
        );
    }

    @Test
    void shouldRejectInvalidSubParserInput() {
        assertAll(
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("1 2 X", "GDA"))),
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("1 2 N", "GXDA")))
        );
    }
}