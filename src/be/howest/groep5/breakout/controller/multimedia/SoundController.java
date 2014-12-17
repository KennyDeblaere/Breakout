package be.howest.groep5.breakout.controller.multimedia;

import be.howest.groep5.breakout.model.multimedia.Sound;

/**
 * Created by Kenny, Dries and Benjamin on 16/12/2014.
 */
public class SoundController {
    private Sound sound;
    private Thread t1;

    public SoundController(){
        t1 = new Thread(new Sound());
        t1.start();
    }
}
