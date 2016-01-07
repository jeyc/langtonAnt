package langton.model.cycle;

import langton.model.cycle.exceptions.LangtonCycleEmptyCycleException;
import langton.model.orientation.Rotation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implémentation de <code>CycleBuilder</code>. Thread-safe.
 */
final class CycleBuilderImpl implements CycleBuilder {

    private final List<Rotation> rotations;

    public CycleBuilderImpl() {
        rotations = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public CycleBuilderImpl rollback() {
        rotations.clear();

        return this;
    }

    @Override
    public CycleBuilderImpl addRotation(Rotation rotation) {
        rotations.add(rotation);
        return this;
    }

    @Override
    public Cycle get() throws LangtonCycleEmptyCycleException {
        Cycle cycle;
        synchronized (rotations) {
            cycle = new CycleImmuable(rotations);
            rollback();
        }
        return cycle;
    }
}
