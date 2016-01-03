package langton.model.grid.events;

import langton.model.grid.Grid;

/**
 * GridSequenceNumberChangedEvent est utlisé pour notifier tous les clients intéressés que le numéro de séquence
 * d'une cellule de grille de Langton a été modifié.
 */
public class GridSequenceNumberChangedEvent extends GridEvent {

    private int x;
    private int y;
    private int oldValue;
    private int newValue;

    /**
     * @param source grille à l'origine de l'event
     * @param x abscisse de la cellule modifiée
     * @param y ordonnée de la cellule modifiée
     * @param oldValue ancienne valeur du numéro de séquence
     * @param newValue nouvelle valeur du numéro de séquence
     */
    public GridSequenceNumberChangedEvent(Grid source, int x, int y, int oldValue, int newValue) {
        super(source);
        this.x = x;
        this.y = y;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /**
     * Retoune l'abscisse de la cellule modifiée.
     *
     * @return abscisse de la cellule modifiée
     */
    public int getX() {
        return x;
    }

    /**
     * Retoune l'ordonnée de la cellule modifiée.
     *
     * @return ordonnée de la cellule modifiée
     */
    public int getY() {
        return y;
    }

    /**
     * Retourne l'ancienne valeur du numéro de séquence.
     *
     * @return ancienne valeur du numéro de séquence
     */
    public int getOldValue() {
        return oldValue;
    }

    /**
     * Retourne la nouvelle valeur du numéro de séquence.
     *
     * @return nouvelle valeur du numéro de séquence
     */
    public int getNewValue() {
        return newValue;
    }
}
