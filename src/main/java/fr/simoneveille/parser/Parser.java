package fr.simoneveille.parser;

import java.util.List;

public interface Parser<T> {
    T parse(List<String> inputs) throws InvalidInputException;
}
