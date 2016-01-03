package langton.model.grid;

import langton.model.exceptions.LangtonNegativeSequenceNumberException;

/**
 * Une grille de Langton bidimensionnelle.
 */
public interface Grid {

    /**
     * Retourne le num�ro de s�quence de la cellule pr�sente aux coordonn�es sp�cifi�es.
     *
     * @param x abcisse de la cellule
     * @param y ordonn�e de la cellule
     * @return le num�ro de s�quence de la cellule pr�sente aux coordonn�es sp�cifi�es
     */
    int getSequenceNumberAt(int x, int y);

    /**
     * Attribue un num�ro de s�quence � la cellule pr�sente aux coordonn�es sp�cifi�es.
     *
     * @param x abcisse de la cellule
     * @param y ordonn�e de la cellule
     * @param sequenceNumber num�ro de s�quence � attribuer � la cellule
     * @throws LangtonNegativeSequenceNumberException si le num�ro de s�quence est strictement n�gatif
     */
    void setSequenceNumberAt(int x, int y, int sequenceNumber)
        throws LangtonNegativeSequenceNumberException;

    /**
     * R�-initialise le num�ro de s�quence de la cellule pr�sente aux coordonn�es sp�cifi�es.
     * Equivalent de <code>setSequenceNumberAt(x, y, 0)</code>.
     *
     * @param x abscisse de la cellule
     * @param y ordonn�e de la cellule
     */
    void clearSequenceNumberAt(int x, int y);

    /**
     * R�-initialise tous les num�ros de s�quence de la grille � 0.
     */
    void clearAll();
}
