package sc.snake.model;

import java.util.HashMap;
import java.util.Random;
import java.util.Set;

/**
 * Default board for game
 */
public final class DefaultBoard implements Board {

    /**
     * height of board
     */
    private final int height;

    /**
     * width of board
     */
    private final int width;

    /**
     * holds the entire board
     */
    private final HashMap<Coordinates, Placeable> map;

    /**
     * holds the free elements
     */
    private final HashMap<Coordinates, Coordinates> free;

    /**
     * Listener
     */
    private final BoardListener listener;

    /**
     * Create new board
     * @param config BoardConfig game configuration
     * @param listener BoardListener which is used for the board
     */
    public DefaultBoard(BoardConfig config, BoardListener listener) {
        height = config.getHeight();
        width = config.getWidth();
        map = new HashMap<>(height * width);
        free = new HashMap<>(height * width);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Coordinates cords = new Coordinates(x,y);
                this.free.put(cords, null);
            }
        }
        this.listener = listener;
        this.listener.init(this);
    }

    @Override
    public Coordinates next(Coordinates current, Direction direction) {
        int newX = current.getX();
        int newY = current.getY();
        switch (direction) {
            case DOWN:
                newY++;
                if (newY >= this.height) {
                    newY = 0;
                }
                break;
            case UP:
                newY--;
                if (newY < 0) {
                    newY = this.height - 1;
                }
                break;
            case LEFT:
                newX--;
                if (newX < 0) {
                    newX = this.width - 1;
                }
                break;
            case RIGHT:
                newX++;
                if (newX >= this.width) {
                    newX = 0;
                }
                break;
        }
        return new Coordinates(newX, newY);
    }

    @Override
    public Coordinates startAt() {
        return new Coordinates(this.width / 2, this.height / 2);
    }

    @Override
    public void place(Coordinates current, Placeable toPlace) {
        if (this.map.containsKey(current)) {
            this.listener.overridden(current, this.map.get(current), toPlace);
        } else {
            this.listener.placed(current, toPlace);
            this.free.remove(current);
        }

        this.map.put(current, toPlace);
    }

    @Override
    public void free(Coordinates current) {
        if (this.map.containsKey(current)) {
            this.map.remove(current);
            this.free.put(current, null);
            this.listener.freed(current);
        }
    }

    @Override
    public Coordinates randomFree() {
        Random random = new Random();
        Set<Coordinates> all = this.free.keySet();
        return (Coordinates)all.toArray()[random.nextInt(all.size())];
    }
}
