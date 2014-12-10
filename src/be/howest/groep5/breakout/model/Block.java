package be.howest.groep5.breakout.model;

import java.awt.*;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class Block {
    private Color color;
    private int horizontalLength, verticalLength, numberOfHitsBeforeVanish, score;
    private boolean power;


    public Block(Color color, int horizontalLength, int verticalLength, int numberOfHitsBeforeVanish, boolean power, int score){
        setColor(color);
        setHorizontalLength(horizontalLength);
        setVerticalLength(verticalLength);
        setNumberOfHitsBeforeVanish(numberOfHitsBeforeVanish);
        setPower(power);
    }

    public void setColor(Color color) {
        this.color = color;
    }
    public void setHorizontalLength(int horizontalLength) {
        this.horizontalLength = horizontalLength;
    }
    public void setNumberOfHitsBeforeVanish(int numberOfHitsBeforeVanish) {
        this.numberOfHitsBeforeVanish = numberOfHitsBeforeVanish;
    }
    public void setPower(boolean power) {
        this.power = power;
    }
    public void setVerticalLength(int verticalLength) {
        this.verticalLength = verticalLength;
    }
    public void setScore(int score) {
        this.score = score;
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
    public boolean hasAPower() {
        return power;
    }
    public int getVerticalLength() {
        return verticalLength;
    }
    public int getScore() {
        return score;
    }
}
