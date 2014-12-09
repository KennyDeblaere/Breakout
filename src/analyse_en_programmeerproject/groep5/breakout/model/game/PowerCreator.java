package analyse_en_programmeerproject.groep5.breakout.model.game;

import java.awt.*;

/**
 * Created by Kenny on 9/12/2014.
 */
public class PowerCreator {

    public PowerCreator(int powerid, boolean powerup, Ball ball, Rectangle paddle){
        returnPower(powerid,powerup,    ball,paddle);

    }

    private void returnPower(int powerid, boolean powerup, Ball ball, Rectangle paddle){
        if(powerup){
            switch (powerid){
                case 0:
                    shooter();
                    break;
                case 1:
                    makeBallBigger(ball.getBall());
                    break;
                case 2:
                    makePaddleLongher(paddle);
                    break;
                case 3:
                    addALife(ball);
                    break;

            }
        }
    }

    private void addALife(Ball ball) {
        ball.setNumberOfLifes(ball.getNumberOfLifes() + 1);
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
