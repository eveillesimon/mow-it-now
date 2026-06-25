package fr.simoneveille.parser;

import fr.simoneveille.domain.HasSymbol;

import java.util.Objects;

public abstract class AbstractParser<T> implements Parser<T> {
    protected String[] splitLine(String line, Integer expected_values) throws InvalidInputException {
        if (line == null || line.isBlank()) {
            throw new InvalidInputException("Line must not be blank");
        }

        String[] values = line.trim().split("\\s+");

        if (expected_values != null) {
            if (values.length != expected_values) {
                throw new InvalidInputException("The line should contain exactly " + expected_values + "values, not " + values.length);
            }
        }

        return values;
    }

    protected int parsePositiveInteger(String value, String fieldName) throws InvalidInputException {
        try {
            int parsedValue = Integer.parseInt(value);

            if (parsedValue < 0) {
                throw new InvalidInputException(fieldName + " value must be positive");
            }

            return parsedValue;
        } catch (NumberFormatException e) {
            throw new InvalidInputException(fieldName + " value must represent an integer", e);
        }
    }

    protected <E extends Enum<E> & HasSymbol> E parseEnumSymbol(String value, Class<E> enumClass) throws InvalidInputException{
        for (E enumConst : enumClass.getEnumConstants()) {
            if (Objects.equals(enumConst.symbol(), value)) {
                return enumConst;
            }
        }
        throw new InvalidInputException(enumClass.getTypeName() + " has no value symbolised by " + value);
    }

}
