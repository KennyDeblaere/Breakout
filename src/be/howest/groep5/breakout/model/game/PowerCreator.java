package be.howest.groep5.breakout.model.game;

import java.awt.*;

/**
 * Created by Kenny, Blackhat on 9/12/2014.
 */
public class PowerCreator implements Runnable {
    private Rectangle power;
    private Ball ball;
    private Paddle paddle;
    private int yDirection;
    private boolean intersection;

    public PowerCreator(int powerid, boolean powerup, Ball ball, Paddle paddle, int x, int y){
        power = new Rectangle(x, y+50, 15,15);
        if(!ball.isSingleplayer())
            setyDirection(ball.getYDirection() * -1);
        else
            setyDirection(1);
        //returnPower(powerid,powerup,ball,paddle);

    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }

    public void setIntersection(boolean intersection) {
        this.intersection = intersection;
    }

    public int getyDirection() {
        return yDirection;
    }
    public Rectangle getPower() {
        return power;
    }
    public boolean isIntersection() {
        return intersection;
    }

    public void returnPower(int powerid, boolean powerup, Ball ball, Paddle paddle){
        if(powerup){
            switch (powerid){
                case 0: shooter(ball);
                    break;
                case 1: makeBallBigger(ball);
                    break;
                case 2: makePaddleLongher(paddle, ball);
                    break;
                case 3: makeBallSlower();
                    break;
                case 4: addALife(ball);
                    break;
            }
        }else{
            switch (powerid){
                case 0: makeBallSmaller(ball);
                    break;
                case 1: makePaddleSmaller(paddle);
                    break;
                case 2: deleteALife(ball);
                    break;
                case 3: makeBallFaster(ball);
                    break;
                case 4: makePaddleSlower();
                    break;
            }
        }
    }

    // ---------------------- POWER UP -----------------------------------

    private void shooter(Ball ball){
        System.out.println("shoooooooooooooooooooooooooooter");

    }

    private void makeBallBigger(Ball ball){
        if(ball.getBall().width < 14) {
            ball.setLengthBound(ball.getLengthBound() - ball.getBall().width);
            ball.getBall().width *= 2;
            ball.getBall().height *= 2;
        }
    }

    private void makePaddleLongher(Paddle paddle, Ball ball){
        if(paddle.getPaddle().width < 400) {
            paddle.setLengthGo(paddle.getLengthGo() - paddle.getPaddle().width);
            paddle.getPaddle().width *= 2;
        }
    }

    private void makeBallSlower() {
        ball.setSpeed(ball.getSpeed() - 1);
    }

    private void addALife(Ball ball) {
        if(ball.getNumberOfLifes() <= 6)
            ball.setNumberOfLifes(ball.getNumberOfLifes() + 1);
    }

    // ---------------------- POWER DOWN -----------------------------------

    private void makeBallSmaller(Ball ball){
        if(ball.getBall().width < 14) {
            ball.setLengthBound(ball.getLengthBound() - ball.getBall().width);
            ball.getBall().width /= 2;
            ball.getBall().height /= 2;
        }
    }

    private void makePaddleSmaller(Paddle paddle){
        if(paddle.getPaddle().width < 50) {
            paddle.setLengthGo(paddle.getLengthGo() - paddle.getPaddle().width);
            paddle.getPaddle().width /= 2;
        }
    }

    private void deleteALife(Ball ball){
        if(ball.getNumberOfLifes() >= 2)
            ball.setNumberOfLifes(ball.getNumberOfLifes() - 1);
    }

    private void makeBallFaster(Ball ball){
        ball.setSpeed(ball.getSpeed() +1);
    }

    private void move(){
        power.y += getyDirection();
        if(power.y > 800)
            setIntersection(false);
    }

    private void makePaddleSlower(){

    }

    @Override
    public void run() {
        while (true){
            move();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
