package be.howest.groep5.breakout.model.multimedia;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Blackhat on 15/12/2014.
 */
public class Multimedia{
    private BufferedImage image, mainBackground;
    private boolean playing = true;

    public Multimedia() {
        try {
            image = (ImageIO.read(new File("src\\be\\howest\\groep5\\breakout\\multimedia\\Icon.jpg")));
            mainBackground = (ImageIO.read(new File("src\\be\\howest\\groep5\\breakout\\multimedia\\background.png")));

        } catch (IOException e) {
            System.out.println("Image laad niet in!");
        }
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isPlaying() {
        return playing;
    }

    public BufferedImage getIconImage() {
        return image;
    }
    public BufferedImage getMainBackground() { return  mainBackground; }
}
