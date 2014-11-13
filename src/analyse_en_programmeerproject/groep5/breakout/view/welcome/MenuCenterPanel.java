package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class MenuCenterPanel extends JPanel {
    private JButton buttonSP, buttonCO, buttonHS, buttonAbout;
    private List<JButton> buttons = new ArrayList<JButton>();

    public MenuCenterPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300,500));

        createComponents();
        setComponents();
        addComponents();
        addListeners();
    }

    private void createComponents() {
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
        for (JButton btn : buttons) {
            btn.setMaximumSize(new Dimension(300, 50));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
        }
    }

    private void addComponents() {
        for (JButton btn : buttons) {
            add(btn);
        }
    }

    private void addListeners(){
        buttonSP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonSP.setBackground(Color.WHITE);
                revalidate();
                repaint();
            }
        });
    }
}
