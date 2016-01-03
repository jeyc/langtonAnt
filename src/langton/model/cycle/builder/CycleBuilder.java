package langton.model.cycle.builder;

import langton.model.cycle.Cycle;
import langton.model.cycle.CycleImmuable;
import langton.model.orientation.Rotation;

import java.util.ArrayList;
import java.util.List;

/**
 * Créé par jerome le 03/01/2016.
 */
public class CycleBuilder implements CycleBuilderInterface {

    private static CycleBuilderInterface instance = null;

    private List<Rotation> rotations = null;
    private Rotation finalRotation = null;

    private CycleBuilder() {}

    public static CycleBuilderInterface cycleBuilder() {
        if (instance == null)
            instance = new CycleBuilder();
        return instance;
    }

    public CycleBuilder initCycle() {
        rotations = new ArrayList<>();
        finalRotation = Rotation.LEFT;
        return this;
    }

    public CycleBuilder addRotation(Rotation rotation) {
        if (rotations == null)
            initCycle();
        rotations.add(rotation);
        return this;
    }

    public CycleBuilder setFinalRotation(Rotation rotation) {
        if (rotations == null)
            initCycle();
        finalRotation = rotation;
        return this;
    }

    public Cycle get() {
        if (rotations == null)
            initCycle();
        Cycle cycle = new CycleImmuable(rotations, finalRotation);
        rotations = null;
        return cycle;
    }
}
