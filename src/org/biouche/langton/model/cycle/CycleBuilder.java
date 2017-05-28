package org.biouche.langton.model.cycle;

import org.biouche.langton.model.orientation.Rotation;

/**
 * Interface implémentée par un monteur de cycle.
 */
public interface CycleBuilder {

    /**
     * Initialise ou réinitialise le monteur
     *
     * @return référence au CycleBuilder
     */
    CycleBuilder rollback();

    /**
     * Ajoute une rotation, et par la même occasion une étape, au cycle.
     *
     * @param rotation la rotation à ajouter
     * @return référence au CycleBuilder
     */
    CycleBuilder addRotation(Rotation rotation);

    /**
     * Retourne le cycle nouvellement créé.
     *
     * @return le nouveau cycle
     * @throws LangtonCycleEmptyCycleException si aucune transition n'a été ajoutée au cycle
     */
    Cycle get() throws LangtonCycleEmptyCycleException;

}
