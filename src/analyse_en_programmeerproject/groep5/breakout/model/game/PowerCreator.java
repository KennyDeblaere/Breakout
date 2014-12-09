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
                    shooter(ball);
                    break;
                case 1:
                    makeBallBigger(ball);
                    break;
                case 2:
                    makePaddleLongher(paddle, ball);
                    break;
                case 3:
                    addALife(ball);
                    break;

            }
        }
    }

    private void addALife(Ball ball) {
        if(ball.getNumberOfLifes() <= 6)
            ball.setNumberOfLifes(ball.getNumberOfLifes() + 1);
        ball.setP1Score(ball.getP1Score() + 100);
    }

    private void shooter(Ball ball){
        System.out.println("shoooooooooooooooooooooooooooter");

        ball.setP1Score(ball.getP1Score() + 100);
    }

    private void makeBallBigger(Ball ball){
        if(ball.getBall().width <= 28) {
            ball.setLengthBound(ball.getLengthBound() - ball.getBall().width);
            ball.getBall().width *= 2;
            ball.getBall().height *= 2;
        }
        ball.setP1Score(ball.getP1Score() + 100);

    }

    private void makePaddleLongher(Paddle paddle, Ball ball){
        if(paddle.getPaddle().width <= 500) {
            paddle.setLengthGo(paddle.getLengthGo() - paddle.getPaddle().width);
            paddle.getPaddle().width *= 2;
        }
        ball.setP1Score(ball.getP1Score() + 100);
    }

}
