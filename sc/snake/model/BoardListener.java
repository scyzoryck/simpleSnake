package sc.snake.model;

/**
 * Listener for game board
 */
public interface BoardListener {
    /**
     * Called when board is created.
     * @param board Board
     */
    void init(Board board);

    /**
     * Called when new element is placed on the free place
     * @param coordinates Coordinates
     * @param placed Placeable
     */
    void placed(Coordinates coordinates, Placeable placed);

    /**
     * Called when element is removed from the board
     * @param coordinates Coordinates
     */
    void freed(Coordinates coordinates);

    /**
     * Called when new element is placed on another element
     * @param coordinates Coordinates
     * @param old Placeable
     * @param placed Placeable
     */
    void overridden(Coordinates coordinates, Placeable old, Placeable placed);
}
