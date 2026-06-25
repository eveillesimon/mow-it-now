package fr.simoneveille.domain;

import java.util.Objects;

public record Position(int x, int y, Orientation orientation) {
    public Position {
        Objects.requireNonNull(orientation, "orientation must not be null");
    }
}
