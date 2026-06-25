package fr.simoneveille.domain;

public record LawnSize(int maxX, int maxY) {

    public LawnSize {
        if (maxX < 0) {
            throw new IllegalArgumentException("Lawn width must be greater than or equal to 0");
        }
        if (maxY < 0) {
            throw new IllegalArgumentException("Lawn height must be greater than or equal to 0");
        }
    }
}
