package be.howest.groep5.breakout.controller.game;

import be.howest.groep5.breakout.model.game.Ball;
import be.howest.groep5.breakout.model.multimedia.Sound;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Kenny Deblaere.
 */
public class MovePanelController extends KeyAdapter {
    private Ball b;
    public MovePanelController(Ball ball){
        b = ball;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        b.getP1().keyPressed(e);
        b.getP2().keyPressed(e);
        if(e.getKeyCode() == KeyEvent.VK_P || e.getKeyCode() == KeyEvent.VK_SPACE) {
            b.setPlaying(!b.isPlaying());
            b.getP1().setPlaying(b.isPlaying());
            b.getP2().setPlaying(b.isPlaying());

            System.out.println(b.isPlaying());
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        b.getP1().keyReleased(e);
        b.getP2().keyReleased(e);
    }
}
