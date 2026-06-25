package fr.simoneveille.domain;

import java.util.ArrayList;
import java.util.List;

public class Simulator {

    private final LawnSize lawnSize;
    private final List<MowerProgram> mowerPrograms;
    private final List<Mower> mowers;

    public Simulator(LawnSize lawnSize, List<MowerProgram> mowerPrograms) {
        this.lawnSize = lawnSize;
        this.mowerPrograms = List.copyOf(mowerPrograms);
        this.mowers = new ArrayList<>();
        for (MowerProgram program: mowerPrograms) {
            mowers.add(new Mower(program.startingPosition()));
        }
    }

    public Simulator(MowingProgramInput input) {
        this(input.lawnSize(), input.programs());
    }


    public void run() {
        if (!verifyMowerStartingPosition()) {
            System.out.println("Every mower must start within the lawn limits.");
            return;
        }

        // I use indices to access mowerPrograms and the corresponding mower
        for (int i = 0; i < mowerPrograms.size(); i++) {
            for (Instruction instruction: mowerPrograms.get(i).instructions()) {

                // Only case where we need verifications
                if (instruction.equals(Instruction.MOVE_FORWARD)) {
                    var aimed_position = instruction.apply(mowers.get(i).position());
                    if (!lawnSize.contains(aimed_position)) {
                        continue;
                    }
                    if (!isFree(aimed_position)) {
                        continue;
                    }

                }
                mowers.get(i).execute(instruction);

            }
        }

        var outs = new ArrayList<String>();
        for (Mower mower: mowers) {
            outs.add(mower.toString());
        }
        System.out.println(String.join(" ", outs));

    }

    /*
    Return true if every mower is instantiated within the map's limits
     */
    private boolean verifyMowerStartingPosition() {
        for (MowerProgram program: mowerPrograms) {
            if (!lawnSize.contains(program.startingPosition())) {
                return false;
            }
        }
        return true;
    }

    /*
    Returns true if no mower is on the specified position.
     */
    private boolean isFree(Position position) {
        for (Mower mower: mowers) {
            if (mower.position().x() == position.x() && mower.position().y() == position.y()) {
                return false;
            }
        }
        return true;
    }

}
