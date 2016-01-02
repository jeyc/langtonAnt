package langton.langton.grid;

/**
 * Interface � impl�menter pour se tenir informer des mises � jour d'une grille de Langton.
 */
public interface GridListener {

    /**
     *  M�thode appel�e lorsqu'une grille de Langton observable est modifi�e.
     *
     * @param event Type d'�v�nement
     * @param grid Grille modifi�e
     * @param position Pour certains �v�nements, position de la cellule modifi�e
     * @param oldValue Pour certains �v�nements, num�ro de s�quence avant modification
     * @param newValue Pour certains �v�nements, num�ro de s�quence apr�s modification
     */
    void handleGridEvent(GridEvent event, Grid grid, Position position, int oldValue, int newValue);

}
