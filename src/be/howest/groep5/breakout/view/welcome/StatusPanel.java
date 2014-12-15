package be.howest.groep5.breakout.view.welcome;

import be.howest.groep5.breakout.controller.SoundController;
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

    public StatusPanel() {
            super();
            setPreferredSize(new Dimension((int)getMaximumSize().getWidth(),40));
            createComponents();
            addComponents();
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
            soundOffButton.setVisible(false);
            soundOffButton.setFocusable(false);
            soundOnButton.addActionListener(new SoundController(false));
            soundOnButton.setFocusable(false);
        }

        private void addComponents() {
            add(soundOnButton);
            add(soundOffButton);
            add(statusLabel);
        }



}
