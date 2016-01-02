package langton.langton.grid;

/**
 * Interface à implémenter pour se tenir informer des mises à jour d'une grille de Langton.
 */
public interface GridListener {

    /**
     *  Méthode appelée lorsqu'une grille de Langton observable est modifiée.
     *
     * @param event Type d'événement
     * @param grid Grille modifiée
     * @param position Pour certains événements, position de la cellule modifiée
     * @param oldValue Pour certains événements, numéro de séquence avant modification
     * @param newValue Pour certains événements, numéro de séquence après modification
     */
    void handleGridEvent(GridEvent event, Grid grid, Position position, int oldValue, int newValue);

}
