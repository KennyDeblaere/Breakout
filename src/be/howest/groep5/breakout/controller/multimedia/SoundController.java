package be.howest.groep5.breakout.controller.multimedia;

import be.howest.groep5.breakout.model.multimedia.Sound;

/**
 * Created by Dries Dekoninck on 16/12/2014.
 */
public class SoundController {
    private Sound sound;
    private Thread t1;

    public SoundController(int soundnumber){
            t1 = new Thread(new Sound(soundnumber));
            t1.start();
    }
}
