package sc.snake.view;

import javax.swing.*;
import java.awt.*;

class BoardElement extends JPanel {


    public BoardElement(boolean topBorder, boolean leftBorder) {
        int t = 0, l = 0;
        if (topBorder) {
            t = 1;
        }
        if (leftBorder) {
            l = 1;
        }

        setBorder(BorderFactory.createMatteBorder(t, l, 1, 1, new Color(0x90A4AE)));
        free();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(20, 20);
    }

    private void change(Color color) {
        setBackground(color);
        repaint();
    }

    public void free() {
        this.change(Color.WHITE);
    }

    public void snake() {
        this.change(new Color(139, 195, 74));
    }

    public void bonus() {
        this.change(new Color(255, 87, 34));
    }

    public void obstacle() {
        this.change(new Color(92, 107, 192));
    }
}
