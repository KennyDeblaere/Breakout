package analyse_en_programmeerproject.groep5.breakout.controller.game;

import analyse_en_programmeerproject.groep5.breakout.model.game.Ball;

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
    }

    @Override
    public void keyReleased(KeyEvent e) {
        b.getP1().keyReleased(e);
        b.getP2().keyReleased(e);
    }
}
