package org.biouche.langton.model.grid;

import org.biouche.langton.model.gridevents.GridListener;

/**
 * Grille de Langton observable.
 */
public interface GridObservable extends Grid{

    /**
     * Ajoute un observateur � la liste des observateurs de l'�v�nement SEQUENCE_NUMBER_CHANGED
     *
     * @param listener l'observateur � ajouter
     */
    void addOnSequenceNumberChangedListener(GridListener listener);

    /**
     * Supprime un observateur � la liste des observateurs de l'�v�nement SEQUENCE_NUMBER_CHANGED
     *
     * @param listener l'observateur � supprimer
     */
    void removeOnSequenceNumberChangedListener(GridListener listener);

    /**
     * Ajoute un observateur � la liste des observateurs de l'�v�nement CLEARED
     *
     * @param listener l'observateur � ajouter
     */
    void addOnGridClearedListener(GridListener listener);

    /**
     * Supprime un observateur � la liste des observateurs de l'�v�nement CLEARED
     *
     * @param listener l'observateur � supprimer
     */
    void removeOnGridClearedListener(GridListener listener);
}
