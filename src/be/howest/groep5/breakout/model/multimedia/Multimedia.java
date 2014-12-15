package be.howest.groep5.breakout.model.multimedia;

import be.howest.groep5.breakout.controller.SoundController;

import javax.imageio.ImageIO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Blackhat on 15/12/2014.
 */
public class Multimedia implements ActionListener{
    private BufferedImage Image;
    private SoundController soundController;
    private Thread tread;

    public Multimedia() {
        try {
            Image = (ImageIO.read(new File("src\\be\\howest\\groep5\\breakout\\multimedia\\Icon.jpg")));
        } catch (IOException e) {
            System.out.println("Image laad niet in!");
        }
        tread = new Thread(soundController);
        tread.start();
    }

    public BufferedImage getIconImage() {
        return Image;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
            tread.start();
    }
}
