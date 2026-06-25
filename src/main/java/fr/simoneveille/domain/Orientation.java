package fr.simoneveille.domain;

public enum Orientation implements HasSymbol {

    NORTH("N"),
    SOUTH("S"),
    EAST("E"),
    WEST("W");

    private final String symbol;

    Orientation(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }
}
