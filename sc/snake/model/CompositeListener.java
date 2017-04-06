package sc.snake.model;

import java.util.ArrayList;

/**
 * Composite for many BoardListener
 */
public class CompositeListener implements BoardListener {

    /**
     * List of listeners
     */
    private final ArrayList<BoardListener> listeners;

    /**
     * Create new composite
     * @param listeners ArrayList<BoardListener> the list of the listeners
     */
    public CompositeListener(ArrayList<BoardListener> listeners) {
        this.listeners = listeners;
    }

    @Override
    public void init(Board board) {
        this.listeners.forEach(boardListener -> boardListener.init(board));
    }

    @Override
    public void placed(Coordinates coordinates, Placeable placed) {
        this.listeners.forEach(boardListener -> boardListener.placed(coordinates, placed));
    }

    @Override
    public void freed(Coordinates coordinates) {
        this.listeners.forEach(boardListener -> boardListener.freed(coordinates));
    }

    @Override
    public void overridden(Coordinates coordinates, Placeable old, Placeable placed) {
        this.listeners.forEach(boardListener -> boardListener.overridden(coordinates, old, placed));
    }
}
