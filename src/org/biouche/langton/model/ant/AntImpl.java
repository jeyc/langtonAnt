package org.biouche.langton.model.ant;

import org.biouche.langton.model.cycle.Cycle;
import org.biouche.langton.model.cycle.Instruction;
import org.biouche.langton.model.cycle.LangtonCycleInvalidSequenceNumberException;
import org.biouche.langton.model.exceptions.LangtonNegativeSequenceNumberException;
import org.biouche.langton.model.grid.Grid;
import org.biouche.langton.model.grid.Position;
import org.biouche.langton.model.orientation.Direction;
import org.biouche.langton.model.orientation.DirectionResolver;

/**
 * Créé par jerome le 06/01/2016.
 */
class AntImpl implements Ant {

    private Position position = null;
    private Direction direction = null;
    private Grid grid = null;

    private Cycle cycle = null;


    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) throws LangtonAntNotOnAGridException {
        if (grid == null && position != null)
            throw new LangtonAntNotOnAGridException();
        this.position = position;
    }

    @Override
    public Direction getDirection() {
        return direction;
    }

    @Override
    public void setDirection(Direction direction) throws LangtonAntNotOnAGridException {
        if (grid == null && direction != null)
            throw new LangtonAntNotOnAGridException();
        this.direction = direction;
    }

    @Override
    public Grid getGrid() {
        return grid;
    }

    @Override
    public void setGrid(Grid grid) {
        if (grid == null) {
            position = null;
            direction = null;
        }
        this.grid = grid;
    }

    @Override
    public void setGrid(Grid grid, Position position, Direction direction) {
        if (grid == null || position == null || direction == null)
            throw new NullPointerException();
        this.grid = grid;
        this.position = position;
        this.direction = direction;
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
    public void move() throws LangtonCycleInvalidSequenceNumberException, LangtonNegativeSequenceNumberException, LangtonAntNoCycleException, LangtonAntNotOnAGridException {
        if (cycle == null)
            throw new LangtonAntNoCycleException();
        if (grid == null)
            throw new LangtonAntNotOnAGridException();

        int x = position.getX();
        int y = position.getY();

        int currentSeqNumber = grid.getSequenceNumberAt(x, y);

        Instruction instruction = cycle.getNextInstruction(currentSeqNumber);

        direction = DirectionResolver.getNextDirection(direction, instruction.getRotation());

        grid.setSequenceNumberAt(x, y, instruction.getSequenceNumber());

        switch (direction) {
            case NORTH:
                position = new Position(x, y - 1);
                break;
            case EAST:
                position = new Position(x + 1, y);
                break;
            case SOUTH:
                position = new Position(x, y + 1);
                break;
            case WEST:
                position = new Position(x - 1, y);
                break;
        }

    }

}
