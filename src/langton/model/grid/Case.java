package langton.model.grid;

/**
 * Créé par jerome le 03/01/2016.
 */
public final class Case {

    private final int x;
    private final int y;
    private final int sequenceNumber;

    public Case(int x, int y, int sequenceNumber) {
        this.x = x;
        this.y = y;
        this.sequenceNumber = sequenceNumber;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }
}
