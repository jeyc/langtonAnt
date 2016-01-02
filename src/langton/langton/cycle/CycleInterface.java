package langton.langton.cycle;

import langton.langton.exceptions.LangtonNegativeSequenceNumberException;
import langton.langton.orientation.Rotation;

/**
 * Interface que doivent impl�menter les cycles de Langton.
 * <p>
 *      Un cycle est une s�quence finie et ferm�e de rotations.
 */
public interface CycleInterface {

    /**
     * Retourne la rotation � effectuer � la fin du cycle.
     *
     * @return la derni�re rotation du cycle
     */
    Rotation getFinalRotation();

    /**
     * D�finit la rotation � effectuer � la fin du cycle.
     *
     * @param rotation la derni�re rotation � effectuer
     */
    void setFinalRotation(Rotation rotation);

    /**
     * Ajouter une rotation, et par la m�me occasion une �tape, au cycle.
     *
     * @param rotation la rotation � ajouter
     */
    void addRotation(Rotation rotation);

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
