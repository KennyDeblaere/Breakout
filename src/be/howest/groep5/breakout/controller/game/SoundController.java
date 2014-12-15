package be.howest.groep5.breakout.controller.game;

import be.howest.groep5.breakout.model.multimedia.Sound;

/**
 * Created by Blackhat on 15/12/2014.
 */
public class SoundController{
    private Thread t1;
    public SoundController(){
        t1 = new Thread(new Sound());
        t1.start();
    }
}
