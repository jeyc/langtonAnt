package langton.langton.grid;

import langton.langton.exceptions.LangtonNegativeSequenceNumberException;

import java.util.HashSet;

/**
 * Décorateur de <code>Grid</code> implémentant <code>GridObservable</code>.
 */
public class GridObservableDecorateur implements GridObservable {

    private Grid grid;

    private HashSet<GridListener> onSequenceNumberChangedListeners = new HashSet<>();
    private HashSet<GridListener> onGridClearedListeners = new HashSet<>();

    public GridObservableDecorateur(Grid grid) {
        if (grid == null)
            throw new NullPointerException();

        this.grid = grid;
    }

    @Override
    public void addOnSequenceNumberChangedListener(GridListener listener) {
        if (listener == null)
            return;

        onSequenceNumberChangedListeners.add(listener);
    }

    @Override
    public void removeOnSequenceNumberChangedListener(GridListener listener) {
        onSequenceNumberChangedListeners.remove(listener);
    }

    @Override
    public void addOnGridClearedListener(GridListener listener) {
        if (listener == null)
            return;

        onGridClearedListeners.add(listener);
    }

    @Override
    public void removeOnGridClearedListener(GridListener listener) {
        onGridClearedListeners.remove(listener);
    }

    @Override
    public int getSequenceNumberAt(int x, int y) {
        return grid.getSequenceNumberAt(x, y);
    }

    @Override
    public void setSequenceNumberAt(int x, int y, int sequenceNumber) throws LangtonNegativeSequenceNumberException {
        int oldSequenceNumber = getSequenceNumberAt(x, y);
        grid.setSequenceNumberAt(x, y, sequenceNumber);

        onSequenceNumberChangedListeners.forEach(
                gridListener -> gridListener.handleGridEvent(GridEvent.SEQUENCE_NUMBER_CHANGED, this, new Position(x, y), oldSequenceNumber, sequenceNumber)
        );
    }

    @Override
    public void clearSequenceNumberAt(int x, int y) {
        try {
            setSequenceNumberAt(x, y, 0);
        } catch (LangtonNegativeSequenceNumberException e) {}
    }

    @Override
    public void clearAll() {
        grid.clearAll();

        onGridClearedListeners.forEach(
                gridListener -> gridListener.handleGridEvent(GridEvent.CLEARED, this, null, 0, 0)
        );
    }
}
