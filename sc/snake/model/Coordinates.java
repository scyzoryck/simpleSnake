package sc.snake.model;

/**
 * Represents the coordinates on the board
 * @see Board
 */
public class Coordinates {
    /**
     * X position
     */
    private final int x;

    /**
     * Y position
     */
    private final int y;

    /**
     * Creates new Coordinates
     * @param x int x position
     * @param y int y position
     */
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns X position
     * @return int
     */
    public int getX() {
        return x;
    }

    /**
     * Returns X position
     * @return int
     */
    public  int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return this.x + this.y * 10000;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().isInstance(obj) && this.hashCode() == obj.hashCode();
    }

    @Override
    public String toString() {
        return Integer.toString(this.x) + 'x' + Integer.toString(this.y);
    }
}

