package sc.snake.model;

/**
 * Represents the direction on the board
 * @see Board
 */
public enum Direction {
    LEFT(),
    RIGHT(),
    UP(),
    DOWN();


    /**
     * Returns the opposed direction
     * @return Direction
     */
    public Direction opposed() {
        switch (this) {
            case LEFT:
                return Direction.RIGHT;
            case RIGHT:
                return Direction.LEFT;
            case UP:
                return Direction.DOWN;
            case DOWN:
                return Direction.UP;
        }
        throw new RuntimeException();
    }


}
