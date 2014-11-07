package analyse_en_programmeerproject.groep5.breakout.view;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Benjamin on 6/11/2014.
 */
public class MenuCenterPanel extends JPanel {
    private JButton buttonSP, buttonCO, buttonHS, buttonAbout;
    private JLabel fillLabel;
    private List<JButton> buttons = new ArrayList<JButton>();

    public MenuCenterPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300,500));

        createComponents();
        setComponents();
        addComponents();
    }

    private void createComponents() {
        fillLabel = new JLabel();
        buttonSP = new JButton("Singleplayer");
        buttonCO = new JButton("Co-Op");
        buttonHS = new JButton("Topscores");
        buttonAbout = new JButton("About");

        buttons.add(buttonSP);
        buttons.add(buttonCO);
        buttons.add(buttonHS);
        buttons.add(buttonAbout);
    }

    private void setComponents() {
        fillLabel.setMaximumSize(new Dimension(1, 200));
        fillLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        for (JButton btn : buttons) {
            btn.setMaximumSize(new Dimension(300, 50));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
    }

    private void addComponents() {
        add(fillLabel);

        for (JButton btn : buttons) {
            add(btn);
        }
    }
}
