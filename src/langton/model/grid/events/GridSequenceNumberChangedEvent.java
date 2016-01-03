package langton.model.grid.events;

import langton.model.grid.Grid;

/**
 * GridSequenceNumberChangedEvent est utlis� pour notifier tous les clients int�ress�s que le num�ro de s�quence
 * d'une cellule de grille de Langton a �t� modifi�.
 */
public class GridSequenceNumberChangedEvent extends GridEvent {

    private int x;
    private int y;
    private int oldValue;
    private int newValue;

    /**
     * @param source grille � l'origine de l'event
     * @param x abscisse de la cellule modifi�e
     * @param y ordonn�e de la cellule modifi�e
     * @param oldValue ancienne valeur du num�ro de s�quence
     * @param newValue nouvelle valeur du num�ro de s�quence
     */
    public GridSequenceNumberChangedEvent(Grid source, int x, int y, int oldValue, int newValue) {
        super(source);
        this.x = x;
        this.y = y;
        this.oldValue = oldValue;
        this.newValue = newValue;
    }

    /**
     * Retoune l'abscisse de la cellule modifi�e.
     *
     * @return abscisse de la cellule modifi�e
     */
    public int getX() {
        return x;
    }

    /**
     * Retoune l'ordonn�e de la cellule modifi�e.
     *
     * @return ordonn�e de la cellule modifi�e
     */
    public int getY() {
        return y;
    }

    /**
     * Retourne l'ancienne valeur du num�ro de s�quence.
     *
     * @return ancienne valeur du num�ro de s�quence
     */
    public int getOldValue() {
        return oldValue;
    }

    /**
     * Retourne la nouvelle valeur du num�ro de s�quence.
     *
     * @return nouvelle valeur du num�ro de s�quence
     */
    public int getNewValue() {
        return newValue;
    }
}
