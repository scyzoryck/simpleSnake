package sc.snake.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * SimpleSnake menu panel
 */
public class MainPanel extends JPanel {

    private final ButtonFactory buttonFactory;

    /**
     * The position of current button
     */
    private int y;

    MainPanel() {
        buttonFactory = new ButtonFactory();
        y = 1;

        setLayout(new GridBagLayout());
        setBackground(new Color(0xFFFFFF));
        setMaximumSize(new Dimension(250, 2048));
        setMinimumSize(new Dimension(250, 480));
        setPreferredSize(new Dimension(250, 480));
    }

    /**
     * Adds new button into menu
     * @param label String button label
     * @param listener ActionListener listener for button
     */
    public void addButton(String label, ActionListener listener){
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = y;
        y++;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JButton button = buttonFactory.createButton(label);
        button.addActionListener(listener);
        add(button, gbc);
    }
}

