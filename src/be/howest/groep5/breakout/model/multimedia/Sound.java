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

        } catch (Exception e){
            System.out.println("Probleem bij mediaspeler!");
        }
    }
}
