package langton.model.cycle;

import langton.model.exceptions.LangtonNegativeSequenceNumberException;
import langton.model.orientation.Rotation;

/**
 * Interface que doivent implémenter les cycles de Langton.
 * <p>
 *      Un cycle est une séquence finie et fermée de rotations.
 */
public interface Cycle {

    /**
     * Retourne la rotation à effectuer à la fin du cycle.
     *
     * @return la dernière rotation du cycle
     */
    Rotation getFinalRotation();

    /**
     * Renvoie le numéro de séquence suivant : currentSequenceNumber + 1 dans le cas général, 0 en fin de cycle.
     *
     * @param currentSequenceNumber numéro de séquence de départ
     * @return numéro de séquence d'arrivée
     * @throws LangtonNegativeSequenceNumberException si le numéro de séquence fournit est négatif
     * @throws LangtonCycleInvalidSequenceNumberException si le numéro de séquence fournit est supérieur au numéro de séquence maximal du cycle
     */
    int getNextSequenceNumber(int currentSequenceNumber) throws LangtonNegativeSequenceNumberException, LangtonCycleInvalidSequenceNumberException;

    Rotation getNextRotation(int currentSequenceNumber) throws LangtonCycleInvalidSequenceNumberException, LangtonNegativeSequenceNumberException;

}
