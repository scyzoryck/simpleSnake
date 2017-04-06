package sc.snake.model;

/**
 * Null listener
 */
public class NullBoardListener implements BoardListener{

    @Override
    public void init(Board board) {
    }

    @Override
    public void placed(Coordinates coordinates, Placeable placed) {
    }

    @Override
    public void freed(Coordinates coordinates) {
    }

    @Override
    public void overridden(Coordinates coordinates, Placeable old, Placeable placed) {
    }
}
