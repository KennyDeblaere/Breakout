package be.howest.groep5.breakout.view;

import be.howest.groep5.breakout.controller.LogoutOnCloseController;
import be.howest.groep5.breakout.controller.multimedia.SoundController;
import be.howest.groep5.breakout.model.multimedia.Multimedia;
import be.howest.groep5.breakout.model.multimedia.Sound;
import be.howest.groep5.breakout.view.welcome.MainPanel;
import be.howest.groep5.breakout.view.welcome.StatusPanel;
import com.sun.xml.internal.ws.api.message.Packet;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;
import java.net.URL;

/**
 * Created by
 *      Kenny Deblaere
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
        SoundController sound = new SoundController();
        addWindowListener(new LogoutOnCloseController());

        setExtendedState(JFrame.MAXIMIZED_BOTH);

    }
}
