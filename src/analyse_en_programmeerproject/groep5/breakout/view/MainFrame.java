package analyse_en_programmeerproject.groep5.breakout.view;

import analyse_en_programmeerproject.groep5.breakout.view.welcome.MainPanel;

import javax.swing.*;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        super();

        setTitle("Breakout (c) 2014 groep 5");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainPanel mainPanel = new MainPanel();
        setContentPane(mainPanel);

        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
