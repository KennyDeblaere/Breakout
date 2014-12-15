package be.howest.groep5.breakout.model.multimedia;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Blackhat on 15/12/2014.
 */
public class Multimedia{
    private BufferedImage Image;


    public Multimedia() {
        try {
            Image = (ImageIO.read(new File("src\\be\\howest\\groep5\\breakout\\multimedia\\Icon.jpg")));
        } catch (IOException e) {
            System.out.println("Image laad niet in!");
        }
    }

    public BufferedImage getIconImage() {
        return Image;
    }
}
