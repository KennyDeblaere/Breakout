package be.howest.groep5.breakout.view.welcome;

import be.howest.groep5.breakout.controller.multimedia.SoundController;
import be.howest.groep5.breakout.model.multimedia.Multimedia;
import be.howest.groep5.breakout.view.settings.SettingPanel;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dries Dekoninck on 21/11/2014.
 */
public class StatusPanel extends JPanel implements ActionListener{
    private JLabel statusLabel;
    private JButton soundOnButton, soundOffButton;
    private BufferedImage onImage, offImage;
    private Multimedia multimedia;
    private SettingPanel settingPanel;

    public StatusPanel(){
        super();
        settingPanel.setVolume(6);
        multimedia = new Multimedia();
        setPreferredSize(new Dimension((int) getMaximumSize().getWidth(), 40));
        createComponents();
        addComponents();
        addActionListener();
    }

    private void createComponents() {
            try {
                onImage = ImageIO.read(new File("src/be/howest/groep5/breakout/multimedia/pictures/Sound_on.png"));
                offImage = ImageIO.read(new File("src/be/howest/groep5/breakout/multimedia/pictures/Sound_off.png"));
            } catch (IOException ex) {
                System.out.println("Foto Sound kan niet worden ingeladen...");
            }
            statusLabel = new JLabel("Status: RUN");
            soundOnButton = new JButton(new ImageIcon(onImage));
            soundOffButton = new JButton(new ImageIcon(offImage));
            soundOnButton.setFocusable(false);
        }

    private void addActionListener(){
        soundOnButton.addActionListener(this);
        soundOffButton.addActionListener(this);

    }

    public void addComponents() {
        add(soundOnButton);
        add(soundOffButton);
        if(multimedia.isPlaying()) {
            soundOffButton.setVisible(false);
            soundOnButton.setVisible(true);
        }
        else{
            soundOnButton.setVisible(false);
            soundOffButton.setVisible(true);
        }
            add(statusLabel);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (multimedia.isPlaying()){
            multimedia.setPlaying(false);
            settingPanel.setVolume(0);

        }
        else{
            multimedia.setPlaying(true);
            settingPanel.setVolume((float)60);
        }
        addComponents();
    }
}
