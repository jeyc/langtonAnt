package langton.model.grid;

import langton.model.exceptions.LangtonNegativeSequenceNumberException;
import langton.model.grid.events.GridClearedEvent;
import langton.model.grid.events.GridListener;
import langton.model.grid.events.GridSequenceNumberChangedEvent;

import java.util.HashSet;

/**
 * Décorateur de <code>Grid</code> implémentant <code>GridObservable</code>.
 */
public class GridObservableDecorateur implements GridObservable {

    private final Grid grid;

    private final HashSet<GridListener> onSequenceNumberChangedListeners = new HashSet<>();
    private final HashSet<GridListener> onGridClearedListeners = new HashSet<>();

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

        GridSequenceNumberChangedEvent event = new GridSequenceNumberChangedEvent(this, x, y, oldSequenceNumber, sequenceNumber);

        onSequenceNumberChangedListeners.forEach(
                gridListener -> gridListener.handleEvent(event)
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
                gridListener -> gridListener.handleEvent(new GridClearedEvent(this))
        );
    }
}
