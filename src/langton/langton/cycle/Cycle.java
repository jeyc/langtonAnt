package langton.langton.cycle;

import langton.langton.exceptions.LangtonNegativeSequenceNumberException;
import langton.langton.orientation.Rotation;

import java.util.ArrayList;

/**
 * Implémentation de <code>CycleInterface</code>.
 */
public class Cycle implements CycleInterface {

    private final ArrayList<Rotation> rotations = new ArrayList<>();
    private Rotation finalRotation = Rotation.LEFT;

    @Override
    public Rotation getFinalRotation() {
        return finalRotation;
    }

    @Override
    public void setFinalRotation(Rotation rotation) {
        if (rotation == null)
            throw new NullPointerException();
        finalRotation = rotation;
    }

    public void addRotation(Rotation rotation) {
        if (rotation == null)
            throw new NullPointerException();
        rotations.add(rotation);
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
