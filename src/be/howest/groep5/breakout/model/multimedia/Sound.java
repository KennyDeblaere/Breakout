package be.howest.groep5.breakout.model.multimedia;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


/**
 * Created by Blackhat on 15/12/2014.
 */
public class Sound{
    private Player player;

    public Sound() throws JavaLayerException, FileNotFoundException {
        File file = new File("src/be/howest/groep5/breakout/multimedia/Breakout.mp3");
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        player = new Player(bis);
    }

    public Player getPlayer() {
        return player;
    }
}
