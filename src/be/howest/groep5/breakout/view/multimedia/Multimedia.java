package be.howest.groep5.breakout.view.multimedia;

import com.sun.media.jfxmedia.events.PlayerStateEvent;
import javazoom.jl.player.Player;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.*;

/**
 * Created by Blackhat on 15/12/2014.
 */
public class Multimedia {
    private BufferedImage Image;

    public Multimedia() {
        try {
            Image = (ImageIO.read(new File("src\\be\\howest\\groep5\\breakout\\multimedia\\Icon.jpg")));
        } catch (IOException e) {
            System.out.println("Image laad niet in!");
        }

        try {
           File file = new File("src/be/howest/groep5/breakout/multimedia/300.mp3");
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            Player player = new Player(bis);
            player.play();
        } catch (Exception e){
            System.out.println("Probleem bij mediaspeler!");
        }

    }

    public BufferedImage getIconImage() {
        return Image;
    }
}
