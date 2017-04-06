package sc.snake.view;

import javax.swing.*;
import java.awt.*;

/**
 * The main game window
 */
public class SnakeFrame extends JFrame {
    private final MainPanel mainPanel;
    private final LoadingPanel loadingPanel;

    /**
     * Creates new window
     */
    public SnakeFrame() {
        super("Flat Snake");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loadingPanel = new LoadingPanel();
        setSize(1024, 1024);
        setVisible(true);
        changeTo(loadingPanel);
        mainPanel = new MainPanel();
    }

    /**
     * Returns the main menu panel
     * @return mainPanel
     */
    public MainPanel getMainPanel() {
        return mainPanel;
    }

    /**
     * Shows the loading panel
     */
    public void loading() {
        changeTo(loadingPanel);
    }

    /**
     * Changes the panel to another
     * @param panel JPanel
     */
    public void changeTo(JPanel panel){
        panel.setVisible(true);
        panel.setSize(getSize());
        JPanel previous = (JPanel) getContentPane();
        setContentPane(panel);
        previous.setVisible(false);
    }
}
