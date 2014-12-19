package be.howest.groep5.breakout.model;

import java.awt.*;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class Block {
    private Color color;
    private int horizontalLength, verticalLength, numberOfHitsBeforeVanish, score;
    private boolean powerUp, powerDown;


    public Block(Color color, int horizontalLength, int verticalLength, int numberOfHitsBeforeVanish, boolean powerup, boolean powerdown, int score){
        setColor(color);
        setHorizontalLength(horizontalLength);
        setVerticalLength(verticalLength);
        setNumberOfHitsBeforeVanish(numberOfHitsBeforeVanish);
        setPowerUp(powerup);
        setPowerDown(powerdown);
        setScore(score);
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void setHorizontalLength(int horizontalLength) {
        if(horizontalLength <= 1000 && horizontalLength > 0)
            this.horizontalLength = horizontalLength;
        else
            this.horizontalLength = 100;
    }
    public void setNumberOfHitsBeforeVanish(int numberOfHitsBeforeVanish) {
        this.numberOfHitsBeforeVanish = numberOfHitsBeforeVanish;
    }
    public void setPowerUp(boolean powerUp) {
        this.powerUp = powerUp;
    }
    public void setVerticalLength(int verticalLength) {
        if(verticalLength <= 500 && verticalLength > 0)
            this.verticalLength = verticalLength;
        else
            this.verticalLength = 50;
    }
    public void setScore(int score) {
        if(score > 0 && score < 100)
            this.score = score;
        else
            this.score = 10;
    }
    public void setPowerDown(boolean powerDown) {
        this.powerDown = powerDown;
    }

    public Color getColor() {
        return color;
    }
    public int getHorizontalLength() {
        return horizontalLength;
    }
    public int getNumberOfHitsBeforeVanish() {
        return numberOfHitsBeforeVanish;
    }
    public boolean hasAPowerUp() {
        return powerUp;
    }
    public boolean hasAPowerDown() {
        return powerDown;
    }
    public int getVerticalLength() {
        return verticalLength;
    }
    public int getScore() {
        return score;
    }
}
