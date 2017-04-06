package sc.snake.model;

import java.io.Serializable;

/**
 * Holds configuration for game
 */
public class BoardConfig implements Serializable {

    /**
     * Board height
     */
    private final int height;

    /**
     * Board width
     */
    private final int width;

    /**
     * Creates new Config
     * @param height int Board height
     * @param width int Board width
     */
    public BoardConfig(int height, int width) {
        this.height = height;
        this.width = width;
    }

    /**
     * Get height of board
     * @return int
     */
    public int getHeight() {
        return height;
    }

    /**
     * Get height of board
     * @return int
     */
    public int getWidth() {
        return width;
    }
}
