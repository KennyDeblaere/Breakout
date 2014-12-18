package be.howest.groep5.breakout.view.welcome;

import be.howest.groep5.breakout.model.multimedia.Multimedia;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dries Dekoninck on 21/11/2014.
 */
public class StatusPanel extends JPanel implements ActionListener, ChangeListener{
    private JButton soundOnButton, soundOffButton;
    private JSlider volume;
    private BufferedImage onImage, offImage;
    private Multimedia multimedia;

    public StatusPanel(){
        super();
        setVolume(1);
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
        soundOnButton = new JButton(new ImageIcon(onImage));
        soundOffButton = new JButton(new ImageIcon(offImage));
        soundOnButton.setFocusable(false);
        volume = new JSlider(0,100,50);
        volume.addChangeListener(this);
    }

    private void addActionListener(){
        soundOnButton.addActionListener(this);
        soundOffButton.addActionListener(this);
    }

    public void addComponents() {
        add(soundOnButton);
        add(soundOffButton);
        add(volume);
        if(multimedia.isPlaying()) {
            soundOffButton.setVisible(false);
            soundOnButton.setVisible(true);
        }
        else{
            soundOnButton.setVisible(false);
            soundOffButton.setVisible(true);
        }
    }

    public static void setVolume(float value){
        value /= 100;
        try {
            Line line = AudioSystem.getLine(Port.Info.SPEAKER);
            line.open();
            FloatControl control =(FloatControl)line.getControl(FloatControl.Type.VOLUME);
            control.setValue(value);
            line.close();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (multimedia.isPlaying()){
            multimedia.setPlaying(false);
            setVolume(0);

        }
        else{
            multimedia.setPlaying(true);
            setVolume(1);
        }
        addComponents();
    }

    public void stateChanged(ChangeEvent e) {
        int vol = volume.getValue();
        setVolume((float)vol);

    }
}
