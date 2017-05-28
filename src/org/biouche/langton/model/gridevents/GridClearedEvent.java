package org.biouche.langton.model.gridevents;

import org.biouche.langton.model.grid.Grid;

/**
 * Event utlis� pour notifier les clients qu'une grille a �t� r�-initialis�e.
 */
public final class GridClearedEvent extends GridEvent {

    /**
     * @param source Grille modifi�e
     * @throws IllegalArgumentException if source is null.
     */
    public GridClearedEvent(Grid source) {
        super(source);
    }
}
