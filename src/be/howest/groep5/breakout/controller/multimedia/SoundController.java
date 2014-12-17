package be.howest.groep5.breakout.controller.multimedia;

import be.howest.groep5.breakout.model.multimedia.Multimedia;
import be.howest.groep5.breakout.model.multimedia.Sound;
import be.howest.groep5.breakout.view.welcome.StatusPanel;
import javazoom.jl.decoder.JavaLayerException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.Observable;

/**
 * Created by Kenny and Benjamin on 16/12/2014.
 */
public class SoundController extends Observable implements ActionListener {
    private Multimedia multimedia;
    private StatusPanel statusPanel;


    public SoundController(StatusPanel statusPanel){
        multimedia = statusPanel.getMultimedia();
        this.statusPanel = statusPanel;
        addObserver(multimedia);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        multimedia.setPlaying(!multimedia.isPlaying());
        statusPanel.addComponents();
        setChanged();
        (new Thread() {
            @Override
            public void run() {
                notifyObservers();
            }
        }).start();
    }
}
