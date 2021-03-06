package org.biouche.langton.model.grid;

import org.biouche.langton.model.exceptions.LangtonNegativeSequenceNumberException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Implémentation de <code>Grid</code>.
 */
public class SimpleGrid implements Grid {

    private final HashMap<Position, Integer> grid = new HashMap<>();

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

    @Override
    public List<Case> getSequenceNumbers() {
        List<Case> cases = new ArrayList<Case>();
        grid.forEach((position, sequenceNumber) -> cases.add(new Case(position.getX(), position.getY(), sequenceNumber)));

        return cases;
    }
}
