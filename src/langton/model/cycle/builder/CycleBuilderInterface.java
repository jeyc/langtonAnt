package langton.model.cycle.builder;

import langton.model.cycle.Cycle;
import langton.model.orientation.Rotation;

/**
 * Interface implémentée par un monteur de cycle.
 */
public interface CycleBuilderInterface {

    /**
     * Initialise un nouveau cycle
     *
     * @return référence au CycleBuilderInterface
     */
    CycleBuilderInterface initCycle();

    /**
     * Définit la rotation à effectuer à la fin du cycle.
     *
     * @param rotation la dernière rotation à effectuer
     * @return référence au CycleBuilderInterface
     */
    CycleBuilderInterface setFinalRotation(Rotation rotation);

    /**
     * Ajoute une rotation, et par la même occasion une étape, au cycle.
     *
     * @param rotation la rotation à ajouter
     * @return référence au CycleBuilderInterface
     */
    CycleBuilderInterface addRotation(Rotation rotation);

    /**
     * Retourne le cycle nouvellement créé.
     *
     * @return le nouveau cycle
     */
    Cycle get();

}
