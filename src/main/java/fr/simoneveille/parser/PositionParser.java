package fr.simoneveille.parser;

import fr.simoneveille.domain.Orientation;
import fr.simoneveille.domain.Position;

import java.util.List;
import java.util.Objects;

public class PositionParser extends AbstractParser<Position> {
    @Override
    public Position parse(List<String> inputs) throws InvalidInputException {
        Objects.requireNonNull(inputs);
        if (inputs.size() != 1) {
            throw new InvalidInputException("Position must be represented by exactly 1 line not " + inputs.size() +".");
        }

        String[] values = splitLine(inputs.getFirst(), 3);

        int x = parsePositiveInteger(values[0], "x Position");
        int y = parsePositiveInteger(values[1], "y Position");
        Orientation o = parseEnumSymbol(values[2], Orientation.class);

        return new Position(x, y, o);
    }
}
