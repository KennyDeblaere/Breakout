package be.howest.groep5.breakout.model.multimedia;

import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Dries Dekoninck on 15/12/2014.
 */
public class Sound implements Runnable{
    private Player player;

    @Override
    public void run() {
        try {
            File file = new File("src/be/howest/groep5/breakout/multimedia/Breakout.mp3");
            FileInputStream fis = new FileInputStream(file);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
            player.play();
        } catch (Exception e){
            System.out.println("Probleem bij mediaspeler!");
        }
    }
}
