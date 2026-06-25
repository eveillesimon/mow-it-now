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

    public Orientation turnLeft() {
        return switch (this) {
            case NORTH -> WEST;
            case WEST -> SOUTH;
            case SOUTH -> EAST;
            case EAST -> NORTH;
        };
    }

    public Orientation turnRight() {
        return switch (this) {
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
    }
}
