package sc.snake.model;


/**
 * Decorates a BoardListener with the logging feature.
 */
public class LoggingBoardListener implements BoardListener {

    private final BoardListener inner;

    /**
     * Decorates inner listener
     * @param inner BoardListener
     */
    public LoggingBoardListener(BoardListener inner) {
        this.inner = inner;
    }

    /**
     * Creates new NullBoardListener and decorates it
     */
    public LoggingBoardListener() {
        this.inner = new NullBoardListener();
    }

    @Override
    public void init(Board board) {
        System.out.print("Logging for " + board.toString());
    }

    @Override
    public void placed(Coordinates coordinates, Placeable placed) {
        System.out.print("Placed " + placed.toString() + " at " + coordinates.toString() + "\n");
        this.inner.placed(coordinates, placed);
    }

    @Override
    public void freed(Coordinates coordinates) {
        System.out.print("Freed " + coordinates.toString() + "\n");
        this.inner.freed(coordinates);
    }

    @Override
    public void overridden(Coordinates coordinates, Placeable old, Placeable placed) {
        System.out.print("Replaced " + old.toString() + " at " + coordinates.toString() + " with" + placed.toString() + "\n");
        this.inner.overridden(coordinates, old, placed);
    }
}
