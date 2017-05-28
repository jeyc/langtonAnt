package org.biouche.langton.model.gridevents;

import java.util.EventListener;

/**
 * Interface � impl�menter pour se tenir informer des mises � jour d'une grille de Langton.
 */
public interface GridListener extends EventListener{

    /**
     *  M�thode appel�e lorsqu'une grille de Langton observable est modifi�e.
     *
     * @param event Ev�nement d�clench�
     */
    void handleEvent(final GridEvent event);

}
