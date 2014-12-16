package be.howest.groep5.breakout.model.multimedia;

import javazoom.jl.decoder.JavaLayerException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Blackhat on 15/12/2014.
 */
public class Multimedia implements Observer{
    private BufferedImage image, mainBackground;
    private boolean playing;
    private Sound s;


    public Multimedia() {
        playing = false;

        try {
            image = (ImageIO.read(new File("src\\be\\howest\\groep5\\breakout\\multimedia\\Icon.jpg")));
            mainBackground = (ImageIO.read(new File("src\\be\\howest\\groep5\\breakout\\multimedia\\background.png")));
            setS(new Sound());
        } catch (JavaLayerException | IOException e) {
            System.out.println("Image laad niet in!");
        }
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
    public void setS(Sound s) {
        this.s = s;
    }

    public boolean isPlaying() {
        return playing;
    }
    public Sound getS() {
        return s;
    }

    public BufferedImage getIconImage() {
        return image;
    }
    public BufferedImage getMainBackground() { return  mainBackground; }


    @Override
    public void update(Observable o, Object arg) {
        if(isPlaying())
            try {
                getS().getPlayer().play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }

    }
}
