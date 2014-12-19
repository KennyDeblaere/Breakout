package be.howest.groep5.breakout.model.multimedia;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Dries Dekoninck on 15/12/2014.
 */
public class Multimedia{
    private BufferedImage image, mainBackground, subbackground, scorebackground, gamebackground, power1, power2, power3;
    private boolean playing = true;
    private int powerTeller = 0;

    public Multimedia() {
        try {
            image = (ImageIO.read(new File("src/be/howest/groep5/breakout/multimedia/pictures/Icon.png")));
            mainBackground = (ImageIO.read(new File("src/be/howest/groep5/breakout/multimedia/pictures/background.png")));
            scorebackground = (ImageIO.read(new File("src/be/howest/groep5/breakout/multimedia/pictures/@background.png")));
            subbackground = (ImageIO.read(new File("src/be/howest/groep5/breakout/multimedia/pictures/subbackground.png")));
            gamebackground = (ImageIO.read(new File("src/be/howest/groep5/breakout/multimedia/pictures/gamebackground.png")));
            power1 = (ImageIO.read(new File("src/be/howest/groep5/breakout/multimedia/pictures/power3.png")));
            power2 = (ImageIO.read(new File("src/be/howest/groep5/breakout/multimedia/pictures/power2.png")));
            power3 = (ImageIO.read(new File("src/be/howest/groep5/breakout/multimedia/pictures/power1.png")));
        } catch (IOException e) {
            System.out.println("Image laad niet in!");
        }
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    private BufferedImage newPower() {
        //
        if (powerTeller > 3) {
            powerTeller = 0;
    }
        powerTeller++;

        switch (powerTeller) {
            case 1:
                return power1;
            case 2:
                return power2;
            default:
                return power3;
        }
    }

    public boolean isPlaying() {
        return playing;
    }
    public BufferedImage getIconImage() { return image; }
    public BufferedImage getMainBackground() { return  mainBackground; }
    public BufferedImage getSubbackground() { return subbackground; }
    public BufferedImage getScorebackground() { return scorebackground; }
    public BufferedImage getPower() {
        return newPower();
    }
    public BufferedImage getGamebackground() { return gamebackground; }
}
