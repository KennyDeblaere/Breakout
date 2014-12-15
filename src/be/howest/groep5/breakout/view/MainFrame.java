package be.howest.groep5.breakout.view;

import be.howest.groep5.breakout.view.multimedia.Multimedia;
import be.howest.groep5.breakout.view.welcome.MainPanel;
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

        Multimedia multimedia = new Multimedia();
        setIconImage(multimedia.getIconImage());

        setTitle("Breakout (c) 2014 groep 5");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainPanel mainPanel = new MainPanel();
        setContentPane(mainPanel);


        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
