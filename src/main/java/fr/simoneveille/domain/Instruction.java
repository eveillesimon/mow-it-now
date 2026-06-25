package fr.simoneveille.domain;

public enum Instruction implements HasSymbol {
    TURN_LEFT("G") {
        @Override
        public Position apply(Position p) {
            return p.turnLeft();
        }
    },
    TURN_RIGHT("D") {
        @Override
        public Position apply(Position p) {
            return p.turnRight();
        }
    },
    MOVE_FORWARD("A") {
        @Override
        public Position apply(Position p) {
            return p.forward();
        }
    };

    private final String symbol;

    Instruction(String symbol) {
        this.symbol = symbol;
    }

    public String symbol() {
        return symbol;
    }


    /*
    Returns the position associated to the initial Position p, once the Instruction has been applied
     */
    public abstract Position apply(Position p);
}
