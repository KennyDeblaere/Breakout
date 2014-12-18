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
        //int startSpeed = b.getP1().getSpeed();
        switch (b.getP1().getId()) {
            default:
                System.out.println("Please enter a valid id in paddleConstructor");
                break;
            case 1:
                if (e.getKeyCode() == e.VK_LEFT) {
                    b.getP1().setxDirection(-1);
                }
                if (e.getKeyCode() == e.VK_RIGHT) {
                    b.getP1().setxDirection(+1);
                }
                break;
            case 2:
                if (e.getKeyCode() == e.VK_Q) {
                    b.getP2().setxDirection(-1);
                    if(!b.isIntersected()){
                        b.getP1().setSpeed(b.getP2().getSpeed()/2);
                    }
                    else
                        b.getP1().setSpeed(b.getP2().getSpeed());
                }
                if (e.getKeyCode() == e.VK_D) {
                    b.getP2().setxDirection(+1);
                    if(!b.isIntersected()){
                        b.getP1().setSpeed(b.getP2().getSpeed()/2);
                    }
                    else
                        b.getP1().setSpeed(b.getP2().getSpeed());
                }
                break;
        }
        switch (b.getP2().getId()) {
            default:
                System.out.println("Please enter a valid id in paddleConstructor");
                break;
            case 1:
                if (e.getKeyCode() == e.VK_LEFT) {
                    b.getP2().setxDirection(-1);

                }
                if (e.getKeyCode() == e.VK_RIGHT) {
                    b.getP2().setxDirection(+1);
                }
                break;
            case 2:
                if (e.getKeyCode() == e.VK_Q) {
                    b.getP2().setxDirection(-1);
                    if(!b.isIntersected()){
                        b.getP1().setSpeed(b.getP2().getSpeed()/2);
                    }
                    else
                        b.getP1().setSpeed(b.getP2().getSpeed());
                }
                if (e.getKeyCode() == e.VK_D) {
                    b.getP2().setxDirection(+1);
                    if(!b.isIntersected()){
                        b.getP1().setSpeed(b.getP2().getSpeed()/2);
                    }
                    else
                        b.getP1().setSpeed(b.getP2().getSpeed());
                }
                break;
        }
        if(e.getKeyCode() == KeyEvent.VK_P || e.getKeyCode() == KeyEvent.VK_SPACE) {
            b.setPlaying(!b.isPlaying());
            b.getP1().setPlaying(b.isPlaying());
            b.getP2().setPlaying(b.isPlaying());
        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (b.getP1().getId()) {
            default:
                System.out.println("Please enter a valid id in paddleConstructor");
                break;
            case 1:
                if (e.getKeyCode() == e.VK_LEFT) {
                    b.getP1().setxDirection(0);
                }
                if (e.getKeyCode() == e.VK_RIGHT) {
                    b.getP1().setxDirection(0);
                }
                break;
            case 2:
                if (e.getKeyCode() == e.VK_Q) {
                    b.getP2().setxDirection(0);
                }
                if (e.getKeyCode() == e.VK_D) {
                    b.getP2().setxDirection(0);
                }
                break;
        }
        switch (b.getP2().getId()) {
            default:
                System.out.println("Please enter a valid id in paddleConstructor");
                break;
            case 1:
                if (e.getKeyCode() == e.VK_LEFT) {
                    b.getP2().setxDirection(0);
                }
                if (e.getKeyCode() == e.VK_RIGHT) {
                    b.getP2().setxDirection(0);
                }
                break;
            case 2:
                if (e.getKeyCode() == e.VK_Q) {
                    b.getP2().setxDirection(0);
                }
                if (e.getKeyCode() == e.VK_D) {
                    b.getP2().setxDirection(0);
                }
                break;
        }
        if(!b.isIntersected()){
            b.getP1().setSpeed(b.getP2().getSpeed());
        }
    }
}
