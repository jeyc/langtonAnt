package langton.model.cycle;

import langton.model.exceptions.LangtonNegativeSequenceNumberException;
import langton.model.orientation.Rotation;

/**
 * Interface que doivent impl�menter les cycles de Langton.
 * <p>
 *      Un cycle est une s�quence finie et ferm�e de rotations.
 */
public interface Cycle {

    /**
     * Retourne la rotation � effectuer � la fin du cycle.
     *
     * @return la derni�re rotation du cycle
     */
    Rotation getFinalRotation();

    /**
     * Renvoie le num�ro de s�quence suivant : currentSequenceNumber + 1 dans le cas g�n�ral, 0 en fin de cycle.
     *
     * @param currentSequenceNumber num�ro de s�quence de d�part
     * @return num�ro de s�quence d'arriv�e
     * @throws LangtonNegativeSequenceNumberException si le num�ro de s�quence fournit est n�gatif
     * @throws LangtonCycleInvalidSequenceNumberException si le num�ro de s�quence fournit est sup�rieur au num�ro de s�quence maximal du cycle
     */
    int getNextSequenceNumber(int currentSequenceNumber) throws LangtonNegativeSequenceNumberException, LangtonCycleInvalidSequenceNumberException;

    Rotation getNextRotation(int currentSequenceNumber) throws LangtonCycleInvalidSequenceNumberException, LangtonNegativeSequenceNumberException;

}
