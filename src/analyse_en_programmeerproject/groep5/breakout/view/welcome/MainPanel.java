package analyse_en_programmeerproject.groep5.breakout.view.welcome;

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
        setLayout(new BorderLayout(0,200));

        createComponents();
        addComponents();
    }

    private void createComponents(){
        topPanel = new MenuTopPanel();
        centerPanel = new CenterPanel();
    }

    private void addComponents() {
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }
}
