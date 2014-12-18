package be.howest.groep5.breakout.model.game;

import java.awt.*;

/**
 * Created by Kenny on 18/12/2014.
 */
public class ShooterCreator implements Runnable {
    private int yDirection;
    private Ball ball;
    private Rectangle shooter;
    private boolean playing;

    public ShooterCreator(Ball ball){
        this.ball = ball;
        playing = true;
        setyDirection(-1);
        if(!ball.isSinglePlayer()) {
            setyDirection(-ball.getYDirection());
        }
        createShooter();
        ball.setShooterCreator(this);
    }
    private void createShooter(){
        if(!ball.isSinglePlayer() && getyDirection() == 1){
            shooter = new Rectangle(ball.getP2().getPaddle().x, ball.getP2().getPaddle().y, 10, 5);
        } else {
            shooter = new Rectangle(ball.getP1().getPaddle().x, ball.getP1().getPaddle().y, 10, 5);
        }
        ball.setShoot(true);
    }
    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public int getyDirection() {
        return yDirection;
    }
    public boolean isPlaying() {
        return playing;
    }
    public Rectangle getShooter() {
        return shooter;
    }

    private void move(){
        shooter.y += getyDirection();
        if(shooter.y < 0 || shooter.y + shooter.height > 750)
            createShooter();
    }
    @Override
    public void run() {
        while (true) {
            if(isPlaying())
                move();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
