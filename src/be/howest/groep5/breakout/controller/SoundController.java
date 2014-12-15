package be.howest.groep5.breakout.controller;

import be.howest.groep5.breakout.model.multimedia.Multimedia;
import be.howest.groep5.breakout.model.multimedia.Sound;
import be.howest.groep5.breakout.view.welcome.StatusPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Blackhat on 15/12/2014.
 */
public class SoundController implements Runnable{
    private Boolean music = true;

    @Override
    public void run() {
        while (music){
            new Sound();
        }
    }
}
