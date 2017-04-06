package sc.snake.view;

import sc.snake.model.*;

import javax.swing.*;
import java.awt.*;

/**
 * Panel which shows the game
 *
 * @see BoardListener
 */
public class GamePanel extends JPanel implements BoardListener {
    /**
     * Elements on the board
     */
    private final BoardElement[][] elements;
    private final UIFactory factory;

    /**
     * holds points value
     */
    private int points;

    private final JLabel pointsLabel;


    /**
     * Creates new game panel
     *
     * @param config BoardConfig
     */
    public GamePanel(BoardConfig config) {
        setLayout(new GridBagLayout());
        factory = new UIFactory();

        JPanel texts = new JPanel();
        texts.setLayout(new GridBagLayout());
        texts.setSize(texts.getWidth(), 50);
        texts.add(factory.createLabel("Your score"));

        pointsLabel = factory.createLabel("0");
        texts.add(pointsLabel);

        GridBagConstraints bc = new GridBagConstraints();
        bc.gridy = 1;
        add(texts);

        JPanel board = new JPanel();
        board.setLayout(new GridBagLayout());
        add(board, bc);

        elements = new BoardElement[config.getHeight()][config.getWidth()];
        GridBagConstraints gbc = new GridBagConstraints();
        for (int h = 0; h < config.getHeight(); h++) {
            gbc.gridy = h;
            for (int w = 0; w < config.getWidth(); w++) {
                gbc.gridx = w;
                BoardElement element = new BoardElement(h == 0, w == 0);
                board.add(element, gbc);
                elements[h][w] = element;
            }
        }
    }

    /**
     * Get element on the given coordinates
     *
     * @param coordinates Coordinates
     * @return BoardElement
     */
    private BoardElement getElement(Coordinates coordinates) {
        return elements[coordinates.getY()][coordinates.getX()];
    }

    @Override
    public void init(Board board) {
        points = 0;
        refreshPoints();
    }

    @Override
    public void placed(Coordinates coordinates, Placeable placed) {
        if (SnakePart.class.isInstance(placed)) {
            getElement(coordinates).snake();
            return;
        }
        if (Obstacle.class.isInstance(placed)) {
            getElement(coordinates).obstacle();
            return;
        }
        if (Bonus.class.isInstance(placed)) {
            getElement(coordinates).bonus();
            return;
        }
        getElement(coordinates).free();
    }

    @Override
    public void freed(Coordinates coordinates) {
        getElement(coordinates).free();
    }

    @Override
    public void overridden(Coordinates coordinates, Placeable old, Placeable placed) {
        this.placed(coordinates, placed);
        if (Bonus.class.isInstance(old)) {
            points++;
            refreshPoints();
        }
    }

    /**
     * Refresh points label
     */
    private void refreshPoints() {
        factory.updateLabel(pointsLabel, Integer.toString(points) + " points");
    }

    /**
     * Returns the score
     * @return int
     */
    public int getPoints() {
        return points;
    }

}
