package fr.simoneveille.domain;

import java.util.List;
import java.util.Objects;

public record MowingProgramInput(LawnSize lawnSize, List<MowerProgram> programs) {

    public MowingProgramInput {
        Objects.requireNonNull(lawnSize, "lawnSize must not be null");
        programs = List.copyOf(programs);
    }

}
