package org.biouche.langton.model.cycle;

import org.biouche.langton.model.orientation.Rotation;

/**
 * Wrapper pour une couple (nextSequenceNumber, Rotation). Immuable.
 */
public final class Instruction {

    private final int sequenceNumber;
    private final Rotation rotation;

    public Instruction(int sequenceNumber, Rotation rotation) {
        this.sequenceNumber = sequenceNumber;
        this.rotation = rotation;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public Rotation getRotation() {
        return rotation;
    }
}
