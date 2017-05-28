package org.biouche.langton.model.cycle;

import org.biouche.langton.model.exceptions.LangtonNegativeSequenceNumberException;

/**
 * Interface que doivent impl�menter les cycles de Langton.
 * <p>
 *      Un cycle est une s�quence finie et ferm�e de rotations.
 */
public interface Cycle {

    /**
     * Renvoie l'instruction qui suit le num�ro de s�quence fourni.
     *
     * @param currentSequenceNumber num�ro de s�quence de d�part
     * @return prochaine instruction
     * @throws LangtonNegativeSequenceNumberException si le num�ro de s�quence fournit est n�gatif
     * @throws LangtonCycleInvalidSequenceNumberException si le num�ro de s�quence fournit est sup�rieur au num�ro de s�quence maximal du cycle
     */
    Instruction getNextInstruction(int currentSequenceNumber) throws LangtonNegativeSequenceNumberException, LangtonCycleInvalidSequenceNumberException;

}
