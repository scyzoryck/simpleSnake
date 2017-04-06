package sc.snake.model;

/**
 * Represents the part of snake on the board
 */
public class SnakePart implements Placeable {
    /**
     * The snake which part it is
     */
    private final Snake snake;

    /**
     * The coordinates of part on the board
     */
    private final Coordinates coordinates;

    /**
     * @param snake Snake which part it is
     * @param coordinates Coordinates where on the board it is placed
     */
    SnakePart(Snake snake, Coordinates coordinates) {
        this.snake = snake;
        this.coordinates = coordinates;
    }

    /**
     * Return the snake
     * @return Snake
     */
    public Snake getSnake() {
        return snake;
    }

    /**
     * Returns coordinates of part on the board
     * @return Coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }
}
