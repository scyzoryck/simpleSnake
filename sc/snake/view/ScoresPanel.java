package sc.snake.view;

import sc.snake.controller.Score;
import sc.snake.controller.ScoreRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * SimpleSnake menu panel
 */
public class ScoresPanel extends JPanel {

    private final UIFactory UIFactory;

    private int y = 1;

    public ScoresPanel(ScoreRepository repository, ActionListener action) {
        super();
        UIFactory = new UIFactory();
        setLayout(new GridBagLayout());
        setBackground(new Color(0xFFFFFF));
        setMaximumSize(new Dimension(250, 2048));
        setMinimumSize(new Dimension(250, 480));
        setPreferredSize(new Dimension(250, 480));
        add(UIFactory.createLabel("SCORE"));
        add(UIFactory.createLabel("USER"));
        add(UIFactory.createLabel("AT"));
        writeScores(repository.getTop());
        addBack(action);
    }

    private void addBack(ActionListener action) {
        JButton back = new ButtonFactory().createButton("BACK");
        back.addActionListener(action);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 2;
        gbc.gridy = 12;
        add(back, gbc);
    }

    private void writeScores(List<Score> scores) {
        y = 1;
        scores.forEach((Score score) -> {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridy = y;
            gbc.gridx = 0;
            add(UIFactory.createLabel(score.getScore()), gbc);
            gbc.gridx = 1;
            add(UIFactory.createLabel(score.getName()), gbc);
            gbc.gridx = 2;
            add(UIFactory.createDatetime(score.getAt()), gbc);

            y++;
        });
    }
}

