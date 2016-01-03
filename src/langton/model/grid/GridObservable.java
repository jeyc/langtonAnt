package langton.model.grid;

import langton.model.grid.events.GridListener;

/**
 * Grille de Langton observable.
 */
public interface GridObservable extends Grid{

    /**
     * Ajoute un observateur à la liste des observateurs de l'événement SEQUENCE_NUMBER_CHANGED
     *
     * @param listener l'observateur à ajouter
     */
    void addOnSequenceNumberChangedListener(GridListener listener);

    /**
     * Supprime un observateur à la liste des observateurs de l'événement SEQUENCE_NUMBER_CHANGED
     *
     * @param listener l'observateur à supprimer
     */
    void removeOnSequenceNumberChangedListener(GridListener listener);

    /**
     * Ajoute un observateur à la liste des observateurs de l'événement CLEARED
     *
     * @param listener l'observateur à ajouter
     */
    void addOnGridClearedListener(GridListener listener);

    /**
     * Supprime un observateur à la liste des observateurs de l'événement CLEARED
     *
     * @param listener l'observateur à supprimer
     */
    void removeOnGridClearedListener(GridListener listener);
}
