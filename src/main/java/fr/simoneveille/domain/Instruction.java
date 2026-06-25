package fr.simoneveille.domain;

public enum Instruction implements HasSymbol {
    TURN_LEFT("G"),
    TURN_RIGHT("D"),
    MOVE_FORWARD("A");

    private final String symbol;

    Instruction(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }
}
