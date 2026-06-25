package fr.simoneveille.domain;

import java.util.List;
import java.util.Objects;

public record MowerProgram(Position startingPosition, List<Instruction> instructions) {

    public MowerProgram {
        Objects.requireNonNull(startingPosition, "startingPosition must not be null");
        Objects.requireNonNull(instructions, "instructions must not be null");

        // We ensure that the list is immutable
        instructions = List.copyOf(instructions);
    }

}
