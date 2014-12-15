package be.howest.groep5.breakout.view;

import be.howest.groep5.breakout.controller.LogoutOnCloseController;
import be.howest.groep5.breakout.view.multimedia.Multimedia;
import be.howest.groep5.breakout.view.welcome.MainPanel;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;

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

        Multimedia multimedia = new Multimedia();
        setIconImage(multimedia.getIconImage());

        addWindowListener(new LogoutOnCloseController());
        Thread t1 = new Thread(multimedia);
        t1.start();

        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
