package analyse_en_programmeerproject.groep5.breakout.model.game;

import java.awt.*;
import java.util.Random;

/**
 * Created by Kenny on 12/11/2014.
 */
public class Ball implements Runnable {
    private int x, y, xDirection, yDirection, p1Score, p2Score;
    private Rectangle ball;
    private Paddle p1, p2;
    private BlockCreator blockCreator;

    public Ball(int x, int y){
        setX(x);
        setY(y);

        //Ball random laten starten
        startRandomX();
        startRandomY();

        //Creeer ball
        ball = new Rectangle(getX(),getY(),7,7);

        p1 = new Paddle(475,700,1);
        p2 = new Paddle(475,15, 2);

        blockCreator = new BlockCreator(1);


        setP1Score(0);
        setP2Score(0);
    }

    private void startRandomX(){
        Random r = new Random();
        int rDirection = r.nextInt(2);
        if(rDirection == 0)
            rDirection--;
        setxDirection(rDirection);
    }

    private void startRandomY(){
        Random r = new Random();
        int rDirection = r.nextInt(2);
        if(rDirection == 0)
            rDirection--;
        setyDirection(rDirection);
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }
    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }
    public void setP1Score(int p1Score) {
        this.p1Score = p1Score;
    }
    public void setP2Score(int p2Score) {
        this.p2Score = p2Score;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getxDirection() {
        return xDirection;
    }
    public int getyDirection() {
        return yDirection;
    }
    public int getP2Score() {
        return p2Score;
    }
    public int getP1Score() {
        return p1Score;
    }

    public Rectangle getBall() {
        return ball;
    }

    public BlockCreator getBlockCreator() {
        return blockCreator;
    }

    public Paddle getP1() {
        return p1;
    }
    public Paddle getP2() {
        return p2;
    }


    public void collision(){
        if(ball.intersects(p1.getPaddle())){
            setyDirection(-1);
        }
        if(ball.intersects(p2.getPaddle()))
            setyDirection(+1);
        if(ball.intersects(blockCreator.getBlock())) {
            p1Score = p1Score + 10;
            setyDirection(getyDirection() * -1);
            setxDirection(getxDirection() * -1 );
            blockCreator.setNumberOfHitsLeft(blockCreator.getNumberOfHitsLeft()-1);
        }
    }

    public void move(){
        collision();
        ball.x += xDirection;
        ball.y += yDirection;

        if(ball.x <= 7){
            setxDirection(+1);
        }
        if(ball.x >= 993){
            setxDirection(-1);
        }
        if(ball.y <= 0){
            setyDirection(+1);
            p2Score++;
        }
        if(ball.y >= 750){
            setyDirection(-1);
            p1Score++;
        }
    }
    @Override
    public void run() {
        try{
            while(true){
                move();
                Thread.sleep(7);
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
