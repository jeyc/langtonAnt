package langton.langton.grid.events;

import langton.langton.grid.Grid;

/**
 * Event utlisé pour notifier les clients qu'une grille a été ré-initialisée.
 */
public class GridClearedEvent extends GridEvent {

    /**
     * @param source Grille modifiée
     * @throws IllegalArgumentException if source is null.
     */
    public GridClearedEvent(Grid source) {
        super(source);
    }
}
