package langton.model.orientation;

/**
 * Classe présentant une méthode statique pour calculer la direction à prendre.
 */
public class DirectionResolver {

    /**
     * Calcule la direction à prendre à partir de la direction actuelle et d'une rotation.
     *
     * @param direction la direction actuelle
     * @param rotation la rotation effectuée
     * @return la direction prise après rotation
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
