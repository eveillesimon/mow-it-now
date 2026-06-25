package fr.simoneveille.domain;

public class Mower {
    private Position position;

    public Mower(Position position) {
        this.position = position;
    }

    public Position position() {
        return position;
    }

    public void execute(Instruction instruction) {
        position = instruction.apply(position);
    }

    @Override
    public String toString() {
        return position.x() + " " + position.y() + " " + position.orientation().symbol();
    }
}
