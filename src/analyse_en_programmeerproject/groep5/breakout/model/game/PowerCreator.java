package analyse_en_programmeerproject.groep5.breakout.model.game;

import java.awt.*;

/**
 * Created by Kenny on 9/12/2014.
 */
public class PowerCreator {

    public PowerCreator(int powerid, boolean powerup, Ball ball, Paddle paddle){
        returnPower(powerid,powerup,ball,paddle);

    }

    private void returnPower(int powerid, boolean powerup, Ball ball, Paddle paddle){
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

    private void makeBallBigger(Ball ball){
        ball.setLengthBound(ball.getLengthBound() - ball.getBall().width);
        ball.getBall().width *= 2;
        ball.getBall().height *= 2;

    }

    private void makePaddleLongher(Paddle paddle){
        paddle.setLengthGo(paddle.getLengthGo() - paddle.getPaddle().width);
        paddle.getPaddle().width *= 2;
    }

}
