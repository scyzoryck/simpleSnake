package sc.snake.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Factory for UI elements
 */
class UIFactory {

    private final Border  margin;

    private final Font font;

    private final Color foreground;

    private final Color background;


    {
        margin = new EmptyBorder(16, 40, 16, 40);
        font = new Font("Source Code Pro", Font.PLAIN, 16);
        foreground = new Color(0x90A4AE);
        background = new Color(0xFFFFFF);
    }
    /**
     * Creates new label
     *
     * @param text String
     * @return JButton
     */
    JLabel createLabel(String text) {
        JLabel label = new JLabel(text.toUpperCase());
        label.setFont(font);
        label.setBorder(margin);
        label.setForeground(foreground);
        label.setBackground(background);

        return label;
    }

    void updateLabel(JLabel label, String text){
        label.setText(text.toUpperCase());
    }

    /**
     * Creates label from int
     * @param number int
     * @return JLabel
     */
    JLabel createLabel(int number) {
        return createLabel(Integer.toString(number));
    }

    /**
     * Creates label from Date
     * @param date Date
     * @return JLabel
     */
    JLabel createDatetime(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return createLabel(format.format(date));
    }

    /**
     * Creates text fieled
     * @return JTextField
     */
    JTextField createField() {
        JTextField field = new JTextField();
        field.setFont(font);
        field.setBorder(new CompoundBorder(margin, BorderFactory.createMatteBorder(0, 0, 1, 0, foreground)));
        field.setEditable(true);
        field.setBackground(background);
        field.setPreferredSize(new Dimension(200, 60));

        return field;
    }

    /**
     * Creates new button
     *
     * @param label String
     * @return JButton
     */
    JButton createButton(String label) {
        JButton button = new JButton();
        button.setBackground(background);
        button.setForeground(foreground);
        button.setFont(font);
        button.setText(label.toUpperCase());
        button.setBorder(new CompoundBorder(margin, new LineBorder(foreground, 1)));
        return button;
    }
}
