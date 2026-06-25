package fr.simoneveille.parser;

import fr.simoneveille.domain.Instruction;
import fr.simoneveille.domain.MowerProgram;
import fr.simoneveille.domain.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MowerProgramsParser extends AbstractParser<List<MowerProgram>>{
    @Override
    public List<MowerProgram> parse(List<String> inputs) throws InvalidInputException {
        Objects.requireNonNull(inputs);
        // Verify that there is an even number of lines, and at least 2
        if (inputs.size() < 2 || inputs.size() % 2 != 0) {
            throw new InvalidInputException("MowerPrograms must be represented by exactly 2n (min. 2) lines not " + inputs.size() +".");
        }

        var result = new ArrayList<MowerProgram>();

        PositionParser positionParser = new PositionParser();
        InstructionsParser instructionsParser = new InstructionsParser();

        for (int i = 0; i < inputs.size(); i += 2) {
            Position position = positionParser.parse(List.of(inputs.get(i)));
            List<Instruction> instructions = instructionsParser.parse(List.of(inputs.get(i+1)));

            result.add(new MowerProgram(position, instructions));
        }

        return result;
    }
}
