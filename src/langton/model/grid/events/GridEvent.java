package langton.model.grid.events;

import langton.model.grid.Grid;

import java.util.EventObject;

/**
 * Classe de base des events notifiés lors de changements survenus sur une grille de Langton.
 */
public class GridEvent extends EventObject {

    /**
     * @param source Grille modifiée
     * @throws IllegalArgumentException if source is null.
     */
    public GridEvent(Grid source) {
        super(source);
    }
}
