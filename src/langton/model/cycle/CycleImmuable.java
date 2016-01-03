package langton.model.cycle;

import langton.model.exceptions.LangtonNegativeSequenceNumberException;
import langton.model.orientation.Rotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de <code>Cycle</code>.
 */
public final class CycleImmuable implements Cycle {

    private final List<Rotation> rotations;
    private final Rotation finalRotation;

    public CycleImmuable(List<Rotation> rotations, Rotation finalRotation) {
        this.rotations = new ArrayList<Rotation>(rotations);
        this.finalRotation = finalRotation;
    }


    @Override
    public Rotation getFinalRotation() {
        return finalRotation;
    }

    @Override
    public int getNextSequenceNumber(int currentSequenceNumber) throws LangtonNegativeSequenceNumberException, LangtonCycleInvalidSequenceNumberException {
        validateSequenceNumber(currentSequenceNumber);

        int next = currentSequenceNumber + 1;
        if (next > rotations.size())
            next = 0;

        return next;



    }

    @Override
    public Rotation getNextRotation(int currentSequenceNumber) throws LangtonCycleInvalidSequenceNumberException, LangtonNegativeSequenceNumberException {
        validateSequenceNumber(currentSequenceNumber);

        if (currentSequenceNumber == rotations.size())
            return finalRotation;
        return rotations.get(currentSequenceNumber);
    }

    private void validateSequenceNumber(int sequenceNumber) throws LangtonNegativeSequenceNumberException, LangtonCycleInvalidSequenceNumberException {
        if (sequenceNumber < 0)
            throw new LangtonNegativeSequenceNumberException();

        if (sequenceNumber > rotations.size())
            throw new LangtonCycleInvalidSequenceNumberException();
    }

}
