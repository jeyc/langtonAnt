package org.biouche.langton.model.gridevents;

import java.util.EventListener;

/**
 * Interface à implémenter pour se tenir informer des mises à jour d'une grille de Langton.
 */
public interface GridListener extends EventListener{

    /**
     *  Méthode appelée lorsqu'une grille de Langton observable est modifiée.
     *
     * @param event Evénement déclenché
     */
    void handleEvent(final GridEvent event);

}
