package be.howest.groep5.breakout.model.multimedia;

import javazoom.jl.player.Player;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class Sound implements Runnable{
    private static Player player;
    private File file;

    @Override
    public void run() {
        try {
            while(true) {
                file = new File("src/be/howest/groep5/breakout/multimedia/sounds/Breakout_sound1.mp3");
                FileInputStream fis = new FileInputStream(file);
                player = new Player(fis);
                player.play();
            }
        } catch (Exception e){
            System.err.println("Probleem bij mediaspeler!");
        }
    }
}
