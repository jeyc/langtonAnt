package langton.langton.ant;

import langton.langton.cycle.Cycle;
import langton.langton.cycle.LangtonCycleInvalidSequenceNumberException;
import langton.langton.exceptions.LangtonNegativeSequenceNumberException;
import langton.langton.grid.Grid;
import langton.langton.orientation.Direction;

/**
 * D�finit l'interface des fourmis de Langton.
 */
public interface AntInterface {

    /**
     * Renvoie l'abscisse de la fourmi.
     *
     * @return l'abscisse de la fourmi.
     */
    int getX();

    /**
     * Renvoie l'ordonn�e de la fourmi.
     *
     * @return l'ordonn�e de la fourmi.
     */
    int getY();

    /**
     * D�finit la position de la fourmi.
     *
     * @param x l'abscisse
     * @param y l'ordonn�e
     */
    void setPosition(int x, int y);

    /**
     * Renvoie la direction vers laquelle la fourmi est tourn�e.
     *
     * @return la direction de la fourmi
     */
    Direction getDirection();

    /**
     * D�finit la direction de la fourmi.
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
     * Pose la fourmi sur une grille � la position (0, 0), dirig�e vers le nord.
     * Null accept�.
     *
     * @param grid grille
     */
    void setGrid(Grid grid);

    /**
     * Pose la fourmi sur une grille � la position donn�e, et avec la direction donn�e.
     * Grille nulle accept�e.
     *
     * @param grid grille
     * @param x abscisse
     * @param y ordonn�e
     * @param direction direction
     */
    void setGrid(Grid grid, int x, int y, Direction direction);

    /**
     * Retourne le cycle qui d�finit le comportement de la fourmi sur sa grille.
     *
     * @return cycle comportementale de la fourmi
     */
    Cycle getCycle();

    /**
     * D�finit le cycle qui d�terminera le comportement de la fourmi sur sa grille.
     * Null accept� (immobilit�)
     *
     * @param cycle comportemental
     */
    void setCycle(Cycle cycle);

    /**
     * Fait effectuer un mouvement unitaire � la fourmi sur sa grille.
     * Si aucune grille ou aucun comportement (cycle) n'est d�fini, la fourmi ne fait rien.
     *
     * @throws LangtonCycleInvalidSequenceNumberException si une erreur interne survient
     * @throws LangtonNegativeSequenceNumberException si une erreur interne survient
     */
    void move() throws LangtonCycleInvalidSequenceNumberException, LangtonNegativeSequenceNumberException;

}
