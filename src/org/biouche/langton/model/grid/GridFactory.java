package org.biouche.langton.model.grid;

import org.biouche.langton.model.grid.Grid;
import org.biouche.langton.model.grid.GridObservable;
import org.biouche.langton.model.grid.GridObservableDecorateur;
import org.biouche.langton.model.grid.SimpleGrid;

/**
 * Créé par jerome le 03/01/2016.
 */
public class GridFactory {

    private final static GridFactory instance = new GridFactory();

    private GridFactory() {}

    public static GridFactory gridFactory() {
        return instance;
    }

    public Grid grid() {
        return new SimpleGrid();
    }

    public GridObservable gridObservable() {
        return new GridObservableDecorateur(new SimpleGrid());
    }

}
