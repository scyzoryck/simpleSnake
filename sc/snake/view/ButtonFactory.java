package sc.snake.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Factory for buttons, which fits the layout
 *
 * @deprecated Replaced with UIFactory
 * @see UIFactory
 */
class ButtonFactory {
    private final CompoundBorder border;

    /**
     * Creates new factory
     */
    ButtonFactory() {
        Border line = new LineBorder(new Color(0x90A4AE), 1);
        Border margin = new EmptyBorder(16, 40, 16, 40);
        border = new CompoundBorder(margin, new CompoundBorder(line, margin));
    }

    /**
     * Creates new button
     * @see UIFactory::createButton()
     * @param label String
     * @return JButton
     */
    JButton createButton(String label) {
        JButton button = new JButton();
        button.setBackground(new Color(0xFFFFFF));
        button.setFont(new Font("Source Code Pro", button.getFont().getStyle(), button.getFont().getSize()));
        button.setText(label);
        button.setBorder(border);
        return button;
    }
}
