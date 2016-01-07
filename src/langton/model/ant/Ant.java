package langton.model.ant;

import langton.model.cycle.Cycle;
import langton.model.cycle.exceptions.LangtonCycleInvalidSequenceNumberException;
import langton.model.exceptions.LangtonNegativeSequenceNumberException;
import langton.model.grid.Grid;
import langton.model.grid.Position;
import langton.model.orientation.Direction;

/**
 * Définit l'interface des fourmis de Langton.
 */
public interface Ant {

    /**
     * Renvoie la position de la fourmi.
     *
     * @return la position de la fourmi.
     */
    Position getPosition();

    /**
     * Définit la position de la fourmi.
     *
     * @param position nouvelle position
     * @throws LangtonAntNotOnAGridException lorsque la position est non nulle mais que la fourmi n'est sur aucune grille
     */
    void setPosition(Position position) throws LangtonAntNotOnAGridException;

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
     * @throws LangtonAntNotOnAGridException lorsque la direction est non nulle mais que la fourmi n'est sur aucune grille
     */
    void setDirection(Direction direction) throws LangtonAntNotOnAGridException;

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
     * @param position position sur la grille
     * @param direction direction
     */
    void setGrid(Grid grid, Position position, Direction direction);

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
     * @throws LangtonAntNotOnAGridException si la fourmi n'est pas sur une grille
     * @throws LangtonAntNoCycleException si aucun cycle n'est attribué à la fourmi
     */
    void move() throws LangtonCycleInvalidSequenceNumberException, LangtonNegativeSequenceNumberException, LangtonAntNoCycleException, LangtonAntNotOnAGridException;

}
