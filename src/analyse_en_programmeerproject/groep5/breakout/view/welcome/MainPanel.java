package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import analyse_en_programmeerproject.groep5.breakout.view.game.GamePanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class MainPanel extends JPanel {
    private CenterPanel centerPanel;
    private MenuTopPanel topPanel;


    public MainPanel() {
        setLayout(new BorderLayout(200,200));
        createComponents();
        addComponents();
    }

    private void createComponents(){
        centerPanel = new CenterPanel();
        topPanel = new MenuTopPanel(centerPanel);
    }

    private void addComponents() {
        add(centerPanel, BorderLayout.CENTER);
        add(topPanel, BorderLayout.NORTH);

    }
}
