package langton.model.orientation;

/**
 * Classe pr�sentant une m�thode statique pour calculer la direction � prendre.
 */
public class DirectionResolver {

    /**
     * Calcule la direction � prendre � partir de la direction actuelle et d'une rotation.
     *
     * @param direction la direction actuelle
     * @param rotation la rotation effectu�e
     * @return la direction prise apr�s rotation
     */
    public static Direction getNextDirection(Direction direction, Rotation rotation) {
        Direction dir = null;

        switch (rotation) {
            case LEFT:
                switch (direction) {
                    case NORTH:
                        dir = Direction.WEST;
                        break;
                    case WEST:
                        dir = Direction.SOUTH;
                        break;
                    case SOUTH:
                        dir = Direction.EAST;
                        break;
                    case EAST:
                        dir = Direction.NORTH;
                        break;
                }
                break;
            case RIGHT:
                switch (direction) {
                    case NORTH:
                        dir = Direction.EAST;
                        break;
                    case EAST:
                        dir = Direction.SOUTH;
                        break;
                    case SOUTH:
                        dir = Direction.WEST;
                        break;
                    case WEST:
                        dir = Direction.NORTH;
                        break;
                }
                break;
        }
        return dir;
    }

}
