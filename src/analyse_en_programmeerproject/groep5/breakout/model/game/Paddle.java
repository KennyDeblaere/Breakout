package analyse_en_programmeerproject.groep5.breakout.model.game;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Kenny Deblaere.
 */
public class Paddle implements Runnable {
    private int x, y, xDirection, id;
    private Rectangle paddle;

    public Paddle(int x, int y, int id){
        setX(x);
        setY(y);
        setId(id);
        paddle = new Rectangle(x, y, 50,10);

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
    public Rectangle getPaddle() {
        return paddle;
    }

    public void keyPressed(KeyEvent e) {
        switch (id) {
            default:
                System.out.println("Please enter a valid id in paddleConstructor");
                break;
            case 1:
                if (e.getKeyCode() == e.VK_LEFT) {
                    setxDirection(-1);
                }
                if (e.getKeyCode() == e.VK_RIGHT) {
                    setxDirection(+1);
                }
                break;
            case 2:
                if (e.getKeyCode() == e.VK_Q) {
                    setxDirection(-1);
                }
                if (e.getKeyCode() == e.VK_D) {
                    setxDirection(+1);
                }
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        switch (id) {
            default:
                System.out.println("Please enter a valid id in paddleConstructor");
                break;
            case 1:
                if (e.getKeyCode() == e.VK_LEFT) {
                    setxDirection(0);
                }
                if (e.getKeyCode() == e.VK_RIGHT) {
                    setxDirection(0);
                }
                break;
            case 2:
                if (e.getKeyCode() == e.VK_Q) {
                    setxDirection(0);
                }
                if (e.getKeyCode() == e.VK_D) {
                    setxDirection(0);

                }
                break;
        }
    }

    public int getId() {
        return id;
    }

    public void move(){
        paddle.x += xDirection;
        if(paddle.x <= 50)
            paddle.x = 50;
        if(paddle.x >= 450)
            paddle.x = 450;
    }

    @Override
    public void run() {
        try{
            while (true){
                move();
                Thread.sleep(8);
            }
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
