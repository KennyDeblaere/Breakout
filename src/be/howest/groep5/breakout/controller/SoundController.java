package be.howest.groep5.breakout.controller;

import be.howest.groep5.breakout.model.multimedia.Multimedia;
import be.howest.groep5.breakout.view.welcome.StatusPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Blackhat on 15/12/2014.
 */
public class SoundController implements ActionListener{
    private Multimedia multimedia;
    private Boolean music;
    private Thread t;

    public SoundController(boolean music){
        this.music = music;
        multimedia = new Multimedia();
        t = new Thread(multimedia);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (music) {
            t.start();
        }
    }
}
