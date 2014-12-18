package be.howest.groep5.breakout.model.game;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Kenny Deblaere.
 */
public class Paddle implements Runnable {
    private int x, y, xDirection, id, lengthGo;
    private Rectangle paddle;
    private int speed, width;
    private boolean playing;

    public Paddle(int x, int y, int width, int id){
        setX(x);
        setY(y);
        setWidth(width);
        setId(id);
        playing = false;
        paddle = new Rectangle(getX(), getY(), getWidth(),10);
        setSpeed(4);

    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getLengthGo() {
        return lengthGo;
    }
    public int getSpeed() {
        return speed;
    }
    public int getWidth() {
        return width;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }
    public void setLengthGo(int lengthGo) {
        this.lengthGo = lengthGo;
    }
    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setWidth(int width) {
        this.width = width;
        setLengthGo(1000 - width);
    }

    public Rectangle getPaddle() {
        return paddle;
    }

    public boolean isPlaying() {
        return playing;
    }

    public int getId() {
        return id;
    }

    public void move(){
        paddle.x += xDirection;
        if(paddle.x <= 0)
            paddle.x = 0;
        if(paddle.x >= getLengthGo())
            paddle.x = getLengthGo();
    }

    @Override
    public void run() {
        try{
            while (true){
                if(isPlaying())
                    move();
                Thread.sleep(getSpeed());
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
