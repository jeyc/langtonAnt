package langton.model.cycle;

import langton.model.cycle.exceptions.LangtonCycleEmptyCycleException;
import langton.model.cycle.exceptions.LangtonCycleInvalidSequenceNumberException;
import langton.model.exceptions.LangtonNegativeSequenceNumberException;
import langton.model.orientation.Rotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Implémentation de <code>Cycle</code>.
 */
final class CycleImmuable implements Cycle {

    private final List<Rotation> rotations;

    public CycleImmuable(List<Rotation> rotations) throws LangtonCycleEmptyCycleException {
        if (rotations == null || rotations.size() == 0)
            throw new LangtonCycleEmptyCycleException();
        this.rotations = new ArrayList<>(rotations);
    }

    @Override
    public Instruction getNextInstruction(int currentSequenceNumber) throws LangtonNegativeSequenceNumberException, LangtonCycleInvalidSequenceNumberException {
        validateSequenceNumber(currentSequenceNumber);

        int next = currentSequenceNumber + 1;
        if (next == rotations.size())
            next = 0;

        return new Instruction(next, rotations.get(currentSequenceNumber));

    }

    private void validateSequenceNumber(int sequenceNumber) throws LangtonNegativeSequenceNumberException, LangtonCycleInvalidSequenceNumberException {
        if (sequenceNumber < 0)
            throw new LangtonNegativeSequenceNumberException();

        if (sequenceNumber >= rotations.size())
            throw new LangtonCycleInvalidSequenceNumberException();
    }

}
