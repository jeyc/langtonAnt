package langton.langton.ant;

import langton.langton.cycle.Cycle;
import langton.langton.cycle.LangtonCycleInvalidSequenceNumberException;
import langton.langton.exceptions.LangtonNegativeSequenceNumberException;
import langton.langton.grid.Grid;
import langton.langton.orientation.Direction;

/**
 * Définit l'interface des fourmis de Langton.
 */
public interface AntInterface {

    /**
     * Renvoie l'abscisse de la fourmi.
     *
     * @return l'abscisse de la fourmi.
     */
    int getX();

    /**
     * Renvoie l'ordonnée de la fourmi.
     *
     * @return l'ordonnée de la fourmi.
     */
    int getY();

    /**
     * Définit la position de la fourmi.
     *
     * @param x l'abscisse
     * @param y l'ordonnée
     */
    void setPosition(int x, int y);

    /**
     * Renvoie la direction vers laquelle la fourmi est tournée.
     *
     * @return la direction de la fourmi
     */
    Direction getDirection();

    /**
     * Définit la direction de la fourmi.
     *
     * @param direction direction dans laquelle la fourmi doit regarder
     */
    void setDirection(Direction direction);

    /**
     * Renvoie la grille sur laquelle la fourmi se situe.
     *
     * @return la grille de la fourmi. Null si la fourmi n'est pas sur une grille.
     */
    Grid getGrid();

    /**
     * Pose la fourmi sur une grille à la position (0, 0), dirigée vers le nord.
     * Null accepté.
     *
     * @param grid grille
     */
    void setGrid(Grid grid);

    /**
     * Pose la fourmi sur une grille à la position donnée, et avec la direction donnée.
     * Grille nulle acceptée.
     *
     * @param grid grille
     * @param x abscisse
     * @param y ordonnée
     * @param direction direction
     */
    void setGrid(Grid grid, int x, int y, Direction direction);

    /**
     * Retourne le cycle qui définit le comportement de la fourmi sur sa grille.
     *
     * @return cycle comportementale de la fourmi
     */
    Cycle getCycle();

    /**
     * Définit le cycle qui déterminera le comportement de la fourmi sur sa grille.
     * Null accepté (immobilité)
     *
     * @param cycle comportemental
     */
    void setCycle(Cycle cycle);

    /**
     * Fait effectuer un mouvement unitaire à la fourmi sur sa grille.
     * Si aucune grille ou aucun comportement (cycle) n'est défini, la fourmi ne fait rien.
     *
     * @throws LangtonCycleInvalidSequenceNumberException si une erreur interne survient
     * @throws LangtonNegativeSequenceNumberException si une erreur interne survient
     */
    void move() throws LangtonCycleInvalidSequenceNumberException, LangtonNegativeSequenceNumberException;

}
