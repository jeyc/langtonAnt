package langton.model.grid.events;

import langton.model.grid.Grid;

/**
 * Event utlisé pour notifier les clients qu'une grille a été ré-initialisée.
 */
public final class GridClearedEvent extends GridEvent {

    /**
     * @param source Grille modifiée
     * @throws IllegalArgumentException if source is null.
     */
    public GridClearedEvent(Grid source) {
        super(source);
    }
}
