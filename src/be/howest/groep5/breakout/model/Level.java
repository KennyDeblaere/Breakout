package be.howest.groep5.breakout.model;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class Level {
    private int ballSpeed, paddleLength, numberOfRows;

    public Level(int ballSpeed, int paddleLength, int numberOfRows){
        setBallSpeed(ballSpeed);
        setPaddleLength(paddleLength);
        setNumberOfRows(numberOfRows);
    }

    public void setBallSpeed(int ballSpeed) {
        if(ballSpeed > 0 && ballSpeed < 15)
            this.ballSpeed = ballSpeed;
        else
            this.ballSpeed = 7;
    }
    public void setPaddleLength(int paddleLength) {
        if(paddleLength >= 25 && paddleLength < 400)
            this.paddleLength = paddleLength;
        else
            this.paddleLength = 100;
    }
    public void setNumberOfRows(int numberOfRows) {
        if(numberOfRows > 2 && numberOfRows < 11)
            this.numberOfRows = numberOfRows;
        else
            this.numberOfRows = 3;
    }

    public int getBallSpeed() {
        return ballSpeed;
    }
    public int getPaddleLength() {
        return paddleLength;
    }
    public int getNumberOfRows() {
        return numberOfRows;
    }
}
