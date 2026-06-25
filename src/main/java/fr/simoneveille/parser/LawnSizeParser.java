package fr.simoneveille.parser;

import fr.simoneveille.domain.LawnSize;

import java.util.List;
import java.util.Objects;

public class LawnSizeParser extends AbstractParser<LawnSize> {
    @Override
    public LawnSize parse(List<String> inputs) throws InvalidInputException {
        Objects.requireNonNull(inputs);
        if (inputs.size() != 1) {
            throw new InvalidInputException("LawnSize must be represented by exactly 1 line not " + inputs.size() +".");
        }

        String[] values = splitLine(inputs.getFirst(), 2);

        int maxX = parsePositiveInteger(values[0], "maxX lawnSize");
        int maxY = parsePositiveInteger(values[1], "maxY lawnSize");

        return new LawnSize(maxX, maxY);
    }
}
