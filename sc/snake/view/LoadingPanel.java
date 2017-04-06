package sc.snake.view;

import javax.swing.*;
import java.awt.*;

/**
 * The loading panel
 */
class LoadingPanel extends JPanel {

    /**
     * Creates new loading panel
     */
    LoadingPanel() {
        super();
        setLayout(new GridBagLayout());
        setBackground(new Color(0xFFFFFF));
        setMaximumSize(new Dimension(250, 2048));
        setMinimumSize(new Dimension(250, 480));
        setPreferredSize(new Dimension(250, 480));
        setFont(new Font("Source Code Pro", getFont().getStyle(), getFont().getSize()));
        add(new JLabel("LOADING"));
    }
}
