package fr.simoneveille.domain;

public record LawnSize(int sizeX, int sizeY) {

    public LawnSize {
        if (sizeX < 0) {
            throw new IllegalArgumentException("Lawn width must be greater than or equal to 0");
        }
        if (sizeY < 0) {
            throw new IllegalArgumentException("Lawn height must be greater than or equal to 0");
        }
    }

    public boolean contains(Position p) {
        if (p.x() < 0 || p.x() >= sizeX) {
            return false;
        }
        if (p.y() < 0 || p.y() >= sizeY) {
            return false;
        }
        return true;
    }
}
