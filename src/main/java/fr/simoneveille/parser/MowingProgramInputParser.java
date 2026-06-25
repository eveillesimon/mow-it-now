package fr.simoneveille.parser;

import fr.simoneveille.domain.LawnSize;
import fr.simoneveille.domain.MowerProgram;
import fr.simoneveille.domain.MowingProgramInput;

import java.util.List;
import java.util.Objects;

public class MowingProgramInputParser extends AbstractParser<MowingProgramInput>{
    @Override
    public MowingProgramInput parse(List<String> inputs) throws InvalidInputException {

        Objects.requireNonNull(inputs);
        if (inputs.size() < 3) {
            throw new InvalidInputException("The input file must contain at least 3 lines (LawnSize : 1 line + MowerProgram : 2 lines)");
        }

        LawnSizeParser lawnSizeParser = new LawnSizeParser();
        MowerProgramsParser mowerProgramsParser = new MowerProgramsParser();

        LawnSize lawnSize = lawnSizeParser.parse(List.of(inputs.getFirst()));
        List<MowerProgram> mowerPrograms = mowerProgramsParser.parse(inputs.subList(1, inputs.size()));

        return new MowingProgramInput(lawnSize, mowerPrograms);
    }
}
