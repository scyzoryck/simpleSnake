package sc.snake.model;

import java.util.LinkedList;

/**
 * Snake
 */
public class Snake extends Thread {
    private Direction direction;
    private final Board board;
    private Coordinates head;
    private final LinkedList<SnakePart> parts;
    private boolean interrupt = false;
    private int queue = 0;

    /**
     * @param board Board where the snake lives
     */
    public Snake(Board board) {
        direction = Direction.LEFT;
        this.board = board;
        parts = new LinkedList<>();

        head = this.board.startAt();
        grows();
        grows();
        grows();
        goAhead();
        goAhead();
        goAhead();
    }

    /**
     * Grows the snake length
     */
    void grows() {
        queue++;
    }

    /**
     * Moves snake`s head to the next position
     * @param next Coordinates
     */
    private synchronized void add(Coordinates next) {
        SnakePart part = new SnakePart(this, next);
        head = next;
        parts.add(part);
        board.place(next, part);
    }

    /**
     * Removes the last part of snake
     */
    private synchronized void removeLast() {
        SnakePart last = this.parts.removeFirst();
        board.free(last.getCoordinates());
    }

    /**
     * Goes to the position on map
     */
    private synchronized void goAhead() {
        if (queue > 0){
            queue--;
        }  else {
            removeLast();
        }
        Coordinates next = this.board.next(this.head, this.direction);
        add(next);
    }

    /**
     * If it is possible change the direction
     * @param direction Direction
     */
    public void turn(Direction direction) {
        if (this.direction == direction) {
            return;
        }

        if (this.direction.opposed() == direction) {
            return;
        }

        this.direction = direction;
        this.goAhead();
    }

    @Override
    public boolean isInterrupted() {
        return this.interrupt;
    }

    @Override
    public void interrupt() {
        this.interrupt = true;
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                System.err.print(e.getMessage());
                break;
            }
            this.goAhead();
        }
    }
}
