package sc.snake.model;

/**
 * Represents the game board
 */
public interface Board {

    /**
     * Returns the coordinates next to the current in the given direction
     * @param current Coordinates
     * @param direction Direction
     * @return Coordinates
     */
    Coordinates next(Coordinates current, Direction direction);

    /**
     * Returns coordinates where games starts
     * @return Coordinates
     */
    Coordinates startAt();

    /**
     * Place element on the given Coordinates
     * @param current Coordinates
     * @param toPlace Placeable
     */
    void place(Coordinates current, Placeable toPlace);

    /**
     * Freed the given Coordinates
     * @param current Coordinates
     */
    void free(Coordinates current);

    /**
     * Returns the random free coordinate on board
     * @return Coordinates
     */
    Coordinates randomFree();
}
