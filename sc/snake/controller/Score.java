package sc.snake.controller;


import java.io.Serializable;
import java.util.Date;

/**
 * User score
 */
public class Score implements Serializable {

    private final int score;

    private final String name;

    private final Date at;

    /**
     * Constructor
     * @param score int number of points
     * @param name String name of the player
     */
    Score(int score, String name) {
        this.score = score;
        this.name = name;
        at = new Date();
    }

    /**
     * Returns date of creation
     * @return Date
     */
    public Date getAt() {
        return at;
    }

    /**
     * Returns number of points
     * @return int
     */
    public int getScore() {
        return score;
    }

    /**
     * Returns name of the player
     * @return String
     */
    public String getName() {
        return name;
    }

}
