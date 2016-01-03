package langton.model.grid;

import langton.model.exceptions.LangtonNegativeSequenceNumberException;

import java.util.HashMap;

/**
 * Implémentation de <code>Grid</code>.
 */
public class SimpleGrid implements Grid {

    private HashMap<Position, Integer> grid = new HashMap<>();

    @Override
    public int getSequenceNumberAt(int x, int y) {
        return grid.getOrDefault(new Position(x, y), 0);
    }

    @Override
    public void setSequenceNumberAt(int x, int y, int sequenceNumber) throws LangtonNegativeSequenceNumberException {
        if (sequenceNumber < 0)
            throw new LangtonNegativeSequenceNumberException();

        Position p = new Position(x, y);

        if (sequenceNumber == 0)
            grid.remove(p);
        else
            grid.put(p, sequenceNumber);
    }

    @Override
    public void clearSequenceNumberAt(int x, int y) {
        try {
            setSequenceNumberAt(x, y, 0);
        } catch (LangtonNegativeSequenceNumberException e) {}
    }

    @Override
    public void clearAll() {
        grid.clear();
    }
}
