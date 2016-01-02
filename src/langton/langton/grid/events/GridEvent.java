package langton.langton.grid.events;

import langton.langton.grid.Grid;

import java.util.EventObject;

/**
 * Classe de base des events notifi�s lors de changements survenus sur une grille de Langton.
 */
public class GridEvent extends EventObject {

    /**
     * @param source Grille modifi�e
     * @throws IllegalArgumentException if source is null.
     */
    public GridEvent(Grid source) {
        super(source);
    }
}
