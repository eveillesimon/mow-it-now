package fr.simoneveille.domain;

import java.util.Objects;

public record Position(int x, int y, Orientation orientation) {
    public Position {
        Objects.requireNonNull(orientation, "orientation must not be null");
    }

    /*
    Returns the theoretical new position after moving forward (no check about lawn size or mower presence)
     */
    public Position forward() {
        return switch (orientation) {
            case NORTH -> new Position(x, y+1, orientation);
            case EAST -> new Position(x+1, y, orientation);
            case WEST -> new Position(x-1, y, orientation);
            case SOUTH -> new Position(x, y-1, orientation);
        };
    }

    public Position turnRight() {
        return new Position(x, y, orientation.turnRight());
    }

    public Position turnLeft() {
        return new Position(x, y, orientation.turnLeft());
    }
}
