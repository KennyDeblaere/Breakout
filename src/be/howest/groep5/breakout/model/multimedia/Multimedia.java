package be.howest.groep5.breakout.model.multimedia;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by Blackhat on 15/12/2014.
 */
public class Multimedia{
    private BufferedImage image, mainBackground, life;
    private boolean playing = true;


    public Multimedia() {
        playing = false;

        try {
            image = (ImageIO.read(new File("src\\be\\howest\\groep5\\breakout\\multimedia\\Icon.jpg")));
            mainBackground = (ImageIO.read(new File("src\\be\\howest\\groep5\\breakout\\multimedia\\background.png")));
            life = (ImageIO.read(new File("src\\be\\howest\\groep5\\breakout\\multimedia\\heart.png")));
        } catch (Exception e)/*(JavaLayerException | IOException e)*/ {
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
    public BufferedImage getLife() { return life; }
}
