package sc.snake.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FillNamePanel extends JPanel {
    private final UIFactory UIFactory;
    private final int score;
    private JTextField field;
    private JButton savebutton;

    public FillNamePanel(int score) {
        super();
        this.score = score;
        UIFactory = new UIFactory();
        setLayout(new GridBagLayout());
        setBackground(new Color(0xFFFFFF));
        setMaximumSize(new Dimension(250, 2048));
        setMinimumSize(new Dimension(250, 480));
        setPreferredSize(new Dimension(250, 480));
        displayUi();
    }

    public void addOnSave(ActionListener onSave) {
        savebutton.addActionListener(onSave);
    }

    private void displayUi() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.gridx = 0;
        add(UIFactory.createLabel("Your score"), gbc);
        gbc.gridx = 1;
        add(UIFactory.createLabel(score), gbc);
        gbc.gridy = 1;
        gbc.gridx = 0;
        add(UIFactory.createLabel("Your name:"), gbc);
        gbc.gridx = 1;
        field = UIFactory.createField();
        field.grabFocus();
        add(field, gbc);
        savebutton = new ButtonFactory().createButton("Save");
        gbc.gridy = 2;
        gbc.gridx = 1;
        add(savebutton, gbc);
    }

    public String getName() {
        return field.getText();
    }
}
