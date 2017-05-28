package org.biouche.langton.model.grid;

import java.util.Objects;

/**
 * Donnée d'une abscisse et d'une ordonnée.
 */
public final class Position {

    private final int x;
    private final int y;

    /**
     * @param x abscisse de la position
     * @param y ordonnée de la position
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Renvoie l'abscisse de la position.
     *
     * @return l'abscisse de la position
     */
    public int getX() {
        return x;
    }

    /**
     * Renvoie l'ordonnée de la position.
     *
     * @return l'ordonnée de la position
     */
    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return Objects.equals(getX(), position.getX()) &&
                Objects.equals(getY(), position.getY());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
