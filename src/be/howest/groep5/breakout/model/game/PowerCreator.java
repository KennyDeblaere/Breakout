package be.howest.groep5.breakout.model.game;

import java.awt.*;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class PowerCreator implements Runnable {
    private Rectangle power;
    private Ball ball;
    private Paddle paddle;
    private int yDirection, powerid;
    private boolean intersection, powerup, playing;
    private int teller;
    private ShooterCreator shooterCreator;

    public PowerCreator(int powerid, boolean powerup, Ball ball, Paddle paddle, int x, int y){
        setPower(new Rectangle(x, y+50, 15,15));
        setPowerid(powerid);
        setPowerup(powerup);
        setPaddle(paddle);
        setBall(ball);
        if(!ball.isSinglePlayer())
            setyDirection(ball.getYDirection() * -1);
        else
            setyDirection(1);
        playing = true;
        teller = 0;

    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }
    public void setBall(Ball ball) {
        this.ball = ball;
    }
    public void setPaddle(Paddle paddle) {
        this.paddle = paddle;
    }
    public void setPower(Rectangle power) {
        this.power = power;
    }
    public void setPowerup(boolean powerup) {
        this.powerup = powerup;
    }
    public void setPowerid(int powerid) {
        this.powerid = powerid;
    }
    public void setIntersection(boolean intersection) {
        this.intersection = intersection;
    }
    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public int getyDirection() {
        return yDirection;
    }
    public Rectangle getPower() {
        return power;
    }
    public int getPowerid() {
        return powerid;
    }
    public Paddle getPaddle() {
        return paddle;
    }
    public boolean isPowerup() {
        return powerup;
    }
    public Ball getBall() {
        return ball;
    }

    public boolean isIntersection() {
        return intersection;
    }

    public void returnPower(){

        while (teller < 1) {
            shooterCreator = null;
            ball.setShooterCreator(shooterCreator);
            getBall().setSpeed(getBall().getStartSpeed());
            getBall().getBall().width = getBall().getStartWidth();
            getBall().getBall().height = getBall().getBall().width;
            getPaddle().getPaddle().width = getPaddle().getStartWidth();
            getPaddle().setLengthGo(1000 - getPaddle().getStartWidth());
            getPaddle().setSpeed(getPaddle().getStartSpeed());
            if (isPowerup()) {
                switch (getPowerid()) {
                    case 0:
                        shooter(getBall());
                        break;
                    case 1:
                        makeBallBigger(getBall());
                        break;
                    case 2:
                        makePaddleLonger(getPaddle(), getBall());
                        break;
                    case 3:
                        makeBallSlower();
                        break;
                    case 4:
                        addALife(getBall());
                        break;
                }
                getBall().setP1Score(getBall().getP1Score() + 100);

            } else {
                switch (getPowerid()) {
                    case 0:
                        makeBallSmaller(getBall());
                        break;
                    case 1:
                        makePaddleSmaller(getPaddle());
                        break;
                    case 2:
                        deleteALife(getBall());
                        break;
                    case 3:
                        makeBallFaster(getBall());
                        break;
                    case 4:
                        makePaddleSlower();
                        break;
                }
                if (getyDirection() == 1)
                    getBall().setP2Score(getBall().getP2Score() - 100);
                else
                    getBall().setP1Score(getBall().getP1Score() - 100);
            }
            teller++;
        }

    }


    private void shooter(Ball ball){
        shooterCreator = new ShooterCreator(ball);
        Thread thread = new Thread(shooterCreator);
        thread.start();
    }

    private void makeBallBigger(Ball ball) {
        ball.setLengthBound(ball.getLengthBound() - ball.getBall().width);
        ball.getBall().width *= 2;
        ball.getBall().height *= 2;
    }

    private void makePaddleLonger(Paddle paddle, Ball ball) {
        paddle.setLengthGo(paddle.getLengthGo() - paddle.getPaddle().width);
        paddle.getPaddle().width *= 2;
    }

    private void makeBallSlower() {
        ball.setSpeed(20);
    }

    private void addALife(Ball ball) {
        if(ball.getNumberOfLifes() <= 6)
            ball.setNumberOfLifes(ball.getNumberOfLifes() + 1);
    }

    private void makeBallSmaller(Ball ball) {
        ball.setLengthBound(ball.getLengthBound() - ball.getBall().width);
        ball.getBall().width /= 2;
        ball.getBall().height /= 2;
    }

    private void makePaddleSmaller(Paddle paddle) {
        paddle.setLengthGo(paddle.getLengthGo() + paddle.getPaddle().width);
        paddle.getPaddle().width /= 2;
    }

    private void deleteALife(Ball ball){
        if(ball.getNumberOfLifes() >= 2)
            ball.setNumberOfLifes(ball.getNumberOfLifes() - 1);
    }

    private void makeBallFaster(Ball ball){
        ball.setSpeed(5);
    }

    private void move(){
        power.y += getyDirection();
        if(power.y > 800)
            setIntersection(false);
    }

    private void makePaddleSlower(){
        getPaddle().setSpeed(8);
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
