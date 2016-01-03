package langton.model.cycle.builder;

import langton.model.cycle.Cycle;
import langton.model.orientation.Rotation;

/**
 * Interface impl�ment�e par un monteur de cycle.
 */
public interface CycleBuilderInterface {

    /**
     * Initialise un nouveau cycle
     *
     * @return r�f�rence au CycleBuilderInterface
     */
    CycleBuilderInterface initCycle();

    /**
     * D�finit la rotation � effectuer � la fin du cycle.
     *
     * @param rotation la derni�re rotation � effectuer
     * @return r�f�rence au CycleBuilderInterface
     */
    CycleBuilderInterface setFinalRotation(Rotation rotation);

    /**
     * Ajoute une rotation, et par la m�me occasion une �tape, au cycle.
     *
     * @param rotation la rotation � ajouter
     * @return r�f�rence au CycleBuilderInterface
     */
    CycleBuilderInterface addRotation(Rotation rotation);

    /**
     * Retourne le cycle nouvellement cr��.
     *
     * @return le nouveau cycle
     */
    Cycle get();

}
