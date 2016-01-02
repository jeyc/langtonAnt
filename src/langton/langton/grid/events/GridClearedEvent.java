package langton.langton.grid.events;

import langton.langton.grid.Grid;

/**
 * Event utlis� pour notifier les clients qu'une grille a �t� r�-initialis�e.
 */
public class GridClearedEvent extends GridEvent {

    /**
     * @param source Grille modifi�e
     * @throws IllegalArgumentException if source is null.
     */
    public GridClearedEvent(Grid source) {
        super(source);
    }
}
