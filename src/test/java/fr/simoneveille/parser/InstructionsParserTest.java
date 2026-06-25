package fr.simoneveille.parser;

import fr.simoneveille.domain.Instruction;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InstructionsParserTest {
    private final InstructionsParser parser = new InstructionsParser();

    @Test
    void shouldParseValidInstructions() throws InvalidInputException {
        List<Instruction> instructions = parser.parse(List.of("GDA"));

        assertEquals(
                List.of(
                        Instruction.TURN_LEFT,
                        Instruction.TURN_RIGHT,
                        Instruction.MOVE_FORWARD
                ),
                instructions
        );
    }

    @Test
    void shouldParseOfficialSampleInstructions() throws InvalidInputException {
        List<Instruction> instructions = parser.parse(List.of("GAGAGAGAD"));

        assertEquals(
                List.of(
                        Instruction.TURN_LEFT,
                        Instruction.MOVE_FORWARD,
                        Instruction.TURN_LEFT,
                        Instruction.MOVE_FORWARD,
                        Instruction.TURN_LEFT,
                        Instruction.MOVE_FORWARD,
                        Instruction.TURN_LEFT,
                        Instruction.MOVE_FORWARD,
                        Instruction.TURN_RIGHT
                ),
                instructions
        );
    }

    @Test
    void shouldRejectInputWithWrongNumberOfLines() {
        assertAll(
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of())),
                () -> assertThrows(InvalidInputException.class, () -> parser.parse(List.of("GDA", "AAG")))
        );
    }

    @Test
    void shouldRejectInvalidInstructionSymbol() {
        assertThrows(
                InvalidInputException.class,
                () -> parser.parse(List.of("GXA"))
        );
    }
}