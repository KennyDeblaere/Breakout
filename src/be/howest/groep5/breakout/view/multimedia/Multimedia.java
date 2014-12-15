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
public class Multimedia implements Runnable {
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

    @Override
    public void run() {
        while (true){
            new Sound();
        }
    }
}
