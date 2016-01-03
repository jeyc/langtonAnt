package langton.model.grid;

import langton.model.exceptions.LangtonNegativeSequenceNumberException;

/**
 * Une grille de Langton bidimensionnelle.
 */
public interface Grid {

    /**
     * Retourne le numéro de séquence de la cellule présente aux coordonnées spécifiées.
     *
     * @param x abcisse de la cellule
     * @param y ordonnée de la cellule
     * @return le numéro de séquence de la cellule présente aux coordonnées spécifiées
     */
    int getSequenceNumberAt(int x, int y);

    /**
     * Attribue un numéro de séquence à la cellule présente aux coordonnées spécifiées.
     *
     * @param x abcisse de la cellule
     * @param y ordonnée de la cellule
     * @param sequenceNumber numéro de séquence à attribuer à la cellule
     * @throws LangtonNegativeSequenceNumberException si le numéro de séquence est strictement négatif
     */
    void setSequenceNumberAt(int x, int y, int sequenceNumber)
        throws LangtonNegativeSequenceNumberException;

    /**
     * Ré-initialise le numéro de séquence de la cellule présente aux coordonnées spécifiées.
     * Equivalent de <code>setSequenceNumberAt(x, y, 0)</code>.
     *
     * @param x abscisse de la cellule
     * @param y ordonnée de la cellule
     */
    void clearSequenceNumberAt(int x, int y);

    /**
     * Ré-initialise tous les numéros de séquence de la grille à 0.
     */
    void clearAll();
}
