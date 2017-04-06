package sc.snake.controller;

import sc.snake.model.*;
import sc.snake.view.FillNamePanel;
import sc.snake.view.GamePanel;
import sc.snake.view.ScoresPanel;
import sc.snake.view.SnakeFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class Controller {
    private final SnakeFrame frame;
    private GamePanel game;
    private Snake snake;
    private final ScoreRepository scores;

    public Controller() {
        frame = new SnakeFrame();
        scores = new ScoreRepository();
        frame.getMainPanel().addButton("NEW GAME", e -> startSnake());
        frame.getMainPanel().addButton("SCORES", e -> showScores());
        frame.getMainPanel().addButton("EXIT", e -> frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING)));
        frame.changeTo(frame.getMainPanel());
    }
    private void fillName() {
        frame.loading();
        FillNamePanel panel = new FillNamePanel(game.getPoints());
        panel.addOnSave(e -> {
            scores.add(new Score(game.getPoints(), panel.getName()));
            frame.changeTo(frame.getMainPanel());
        });
        frame.changeTo(panel);
    }

    private void showScores() {
        frame.loading();
        frame.changeTo(new ScoresPanel(scores, e -> frame.changeTo(frame.getMainPanel())));
    }

    private void startSnake() {
        frame.loading();
        BoardConfig config = getConfig();
        game = new GamePanel(config);
        frame.changeTo(game);

        Board board = new DefaultBoard(config, getListener());
        snake = new Snake(board);
        snake.start();
        InputMap im = game.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = game.getActionMap();
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), Direction.RIGHT);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), Direction.UP);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), Direction.LEFT);
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), Direction.DOWN);
        am.put(Direction.RIGHT, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snake.turn(Direction.RIGHT);
            }
        });
        am.put(Direction.UP, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snake.turn(Direction.UP);
            }
        });
        am.put(Direction.LEFT, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snake.turn(Direction.LEFT);
            }
        });
        am.put(Direction.DOWN, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                snake.turn(Direction.DOWN);
            }
        });
    }

    private BoardConfig getConfig() {
        return new BoardConfig(20, 30);
    }

    private BoardListener getListener() {
        ArrayList<BoardListener> listeners = new ArrayList<>();
//        listeners.add(new LoggingBoardListener());
        listeners.add(new MainListener());
        listeners.add(game);
        listeners.add(new NullBoardListener() {
            @Override
            public void overridden(Coordinates coordinates, Placeable old, Placeable placed) {
                if (SnakePart.class.isInstance(old)) {
                    fillName();
                }
            }
        });
        return new CompositeListener(listeners);
    }
}
