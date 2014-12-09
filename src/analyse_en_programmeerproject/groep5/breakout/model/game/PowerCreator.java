package analyse_en_programmeerproject.groep5.breakout.model.game;

import java.awt.*;

/**
 * Created by Kenny on 9/12/2014.
 */
public class PowerCreator {

    public PowerCreator(int powerid, boolean powerup, int life, Rectangle ball, Rectangle paddle){
        returnPower(powerid,powerup,life,ball,paddle);

    }

    private void returnPower(int powerid, boolean powerup, int life, Rectangle ball, Rectangle paddle){
        if(powerup){
            switch (powerid){
                case 0:
                    shooter();
                    break;
                case 1:
                    makeBallBigger(ball);
                    break;
                case 2:
                    makePaddleLongher(paddle);
                    break;
                case 3:
                    addALife(life);
                    break;

            }
        }
    }

    private void addALife(int life) {
        life++;
    }

    private void shooter(){
        System.out.println("shoooooooooooooooooooooooooooter");
    }

    private void makeBallBigger(Rectangle ball){
        ball.width *= 2;
        ball.height *= 2;
    }

    private void makePaddleLongher(Rectangle paddle){
        paddle.width *= 2;
    }

}
