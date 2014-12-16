package be.howest.groep5.breakout.view.welcome;

import be.howest.groep5.breakout.controller.multimedia.SoundController;
import be.howest.groep5.breakout.model.multimedia.Multimedia;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class StatusPanel extends JPanel{
    private JLabel statusLabel;
    private JButton soundOnButton, soundOffButton;
    private BufferedImage onImage, offImage;
    private Multimedia multimedia;
    private Thread thread;

    public StatusPanel() {
        super();
        multimedia = new Multimedia();

        setPreferredSize(new Dimension((int) getMaximumSize().getWidth(), 40));
        createComponents();
        addComponents();
        addActionListener();
    }

    private void createComponents() {
            try {
                onImage = ImageIO.read(new File("src\\be\\howest\\groep5\\breakout\\multimedia\\Sound_on.png"));
                offImage = ImageIO.read(new File("src\\be\\howest\\groep5\\breakout\\multimedia\\Sound_off.png"));
            } catch (IOException ex) {
                System.out.println("Foto Sound kan niet worden ingeladen...");
            }
            statusLabel = new JLabel("Status: RUN");
            soundOnButton = new JButton(new ImageIcon(onImage));
            soundOffButton = new JButton(new ImageIcon(offImage));
        soundOnButton.setFocusable(false);
        }

    private void addActionListener(){
        soundOnButton.addActionListener(new SoundController(this));
        soundOffButton.addActionListener(new SoundController(this));

    }

    public void addComponents() {
        add(soundOnButton);
        add(soundOffButton);
        if(!multimedia.isPlaying()) {
            soundOffButton.setVisible(false);
            soundOnButton.setVisible(true);
        }
        else{
            soundOnButton.setVisible(false);
            soundOffButton.setVisible(true);
        }
            add(statusLabel);
    }

    public Multimedia getMultimedia() {
        return multimedia;
    }
}
