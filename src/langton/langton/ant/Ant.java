package langton.langton.ant;

import langton.langton.cycle.Cycle;
import langton.langton.cycle.LangtonCycleInvalidSequenceNumberException;
import langton.langton.exceptions.LangtonNegativeSequenceNumberException;
import langton.langton.grid.Grid;
import langton.langton.orientation.Direction;
import langton.langton.orientation.DirectionResolver;
import langton.langton.orientation.Rotation;

/**
 * Impl�mentation de <code>AntInterface</code>.
 */
public class Ant implements AntInterface {

    private int x = 0;
    private int y = 0;

    private Direction direction = Direction.NORTH;

    private Grid grid = null;

    private Cycle cycle = null;

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void setDirection(Direction direction) {
        if (direction == null)
            throw new NullPointerException();
        this.direction = direction;
    }

    @Override
    public Grid getGrid() {
        return grid;
    }

    @Override
    public void setGrid(Grid grid) {
        this.grid = grid;
    }

    @Override
    public void setGrid(Grid grid, int x, int y, Direction direction) {
        setGrid(grid);
        setPosition(x, y);
        setDirection(direction);
    }

    @Override
    public Cycle getCycle() {
        return cycle;
    }

    @Override
    public void setCycle(Cycle cycle) {
        this.cycle = cycle;
    }

    @Override
    public void move() throws LangtonCycleInvalidSequenceNumberException, LangtonNegativeSequenceNumberException {
        if (grid == null || cycle == null)
            return;
        int currentSeqNumber = grid.getSequenceNumberAt(getX(), getY());

        int nextSeq = cycle.getNextSequenceNumber(currentSeqNumber);
        Rotation rotation = cycle.getNextRotation(currentSeqNumber);

        direction = DirectionResolver.getNextDirection(direction, rotation);

        grid.setSequenceNumberAt(x, y, nextSeq);

        switch (direction) {
            case NORTH:
                setPosition(x, y - 1);
                break;
            case EAST:
                setPosition(x + 1, y);
                break;
            case SOUTH:
                setPosition(x, y + 1);
                break;
            case WEST:
                setPosition(x - 1, y);
                break;
        }

    }
}