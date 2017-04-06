package sc.snake.model;

/**
 * Controls main snake's behaviors
 */
public class MainListener implements BoardListener {
    private Board board;

    @Override
    public void init(Board board) {
        this.board = board;
        board.place(board.randomFree(), new Bonus());
    }

    @Override
    public void placed(Coordinates coordinates, Placeable placed) {
    }

    @Override
    public void freed(Coordinates coordinates) {
    }

    @Override
    public void overridden(Coordinates coordinates, Placeable old, Placeable placed) {
        if (SnakePart.class.isInstance(placed)) {
            SnakePart part = (SnakePart) placed;
            this.eat(old, part.getSnake());
        }
    }

    private void eat(Placeable old, Snake snake) {
        if (SnakePart.class.isInstance(old)) {
            snake.interrupt();
            return;
        }

        if (Bonus.class.isInstance(old)) {
            this.board.place(this.board.randomFree(), old);
            snake.grows();
        }

        if (Obstacle.class.isInstance(old)){
            snake.interrupt();
        }
    }
}
