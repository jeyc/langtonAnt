package org.biouche.langton.model.cycle;

import org.biouche.langton.model.exceptions.LangtonNegativeSequenceNumberException;

/**
 * Interface que doivent implémenter les cycles de Langton.
 * <p>
 *      Un cycle est une séquence finie et fermée de rotations.
 */
public interface Cycle {

    /**
     * Renvoie l'instruction qui suit le numéro de séquence fourni.
     *
     * @param currentSequenceNumber numéro de séquence de départ
     * @return prochaine instruction
     * @throws LangtonNegativeSequenceNumberException si le numéro de séquence fournit est négatif
     * @throws LangtonCycleInvalidSequenceNumberException si le numéro de séquence fournit est supérieur au numéro de séquence maximal du cycle
     */
    Instruction getNextInstruction(int currentSequenceNumber) throws LangtonNegativeSequenceNumberException, LangtonCycleInvalidSequenceNumberException;

}
