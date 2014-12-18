package be.howest.groep5.breakout.model.multimedia;

import javazoom.jl.player.Player;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by Dries Dekoninck on 15/12/2014.
 */
public class Sound implements Runnable{
    private static Player player;
    private int soundnumber;
    private File file;
    public Sound(int number){

        soundnumber = number;
        file = new File("src/be/howest/groep5/breakout/multimedia/sounds/Breakout_sound" + soundnumber + ".mp3");
    }

    @Override
    public void run() {
        try {

            while(true) {
                FileInputStream fis = new FileInputStream(file);
                //BufferedInputStream bis = new BufferedInputStream(fis);
                player = new Player(fis);
                player.play();
            }
        } catch (Exception e){
            System.out.println("Probleem bij mediaspeler!");
        }
    }
}
