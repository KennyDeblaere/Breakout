package be.howest.groep5.breakout.view;

import be.howest.groep5.breakout.controller.LogoutOnCloseController;
import be.howest.groep5.breakout.controller.SoundController;
import be.howest.groep5.breakout.model.multimedia.Multimedia;
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
        MainPanel mainPanel = new MainPanel();
        setTitle("Breakout (c) 2014 groep 5");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(mainPanel);
        setIconImage(multimedia.getIconImage());
        addWindowListener(new LogoutOnCloseController());

        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
