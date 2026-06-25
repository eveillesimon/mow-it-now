package fr.simoneveille.parser;

import fr.simoneveille.domain.Instruction;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InstructionsParser extends AbstractParser<List<Instruction>>{
    @Override
    public List<Instruction> parse(List<String> inputs) throws InvalidInputException {
        Objects.requireNonNull(inputs);
        if (inputs.size() != 1) {
            throw new InvalidInputException("Instruction must be represented by exactly 1 line not " + inputs.size() +".");
        }

        var result = new ArrayList<Instruction>();

        for (char symbol: inputs.getFirst().toCharArray()) {
            result.add(parseEnumSymbol(String.valueOf(symbol), Instruction.class));
        }

        return result;
    }
}
