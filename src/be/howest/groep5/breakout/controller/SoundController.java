package be.howest.groep5.breakout.controller;

import be.howest.groep5.breakout.model.multimedia.Sound;

/**
 * Created by Blackhat on 15/12/2014.
 */
public class SoundController implements Runnable{

    @Override
    public void run() {
        while (true){
            new Sound();
        }
    }
}
