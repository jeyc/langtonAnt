package org.biouche.langton.model.cycle;

import org.biouche.langton.model.orientation.Rotation;

/**
 * Interface impl�ment�e par un monteur de cycle.
 */
public interface CycleBuilder {

    /**
     * Initialise ou r�initialise le monteur
     *
     * @return r�f�rence au CycleBuilder
     */
    CycleBuilder rollback();

    /**
     * Ajoute une rotation, et par la m�me occasion une �tape, au cycle.
     *
     * @param rotation la rotation � ajouter
     * @return r�f�rence au CycleBuilder
     */
    CycleBuilder addRotation(Rotation rotation);

    /**
     * Retourne le cycle nouvellement cr��.
     *
     * @return le nouveau cycle
     * @throws LangtonCycleEmptyCycleException si aucune transition n'a �t� ajout�e au cycle
     */
    Cycle get() throws LangtonCycleEmptyCycleException;

}
