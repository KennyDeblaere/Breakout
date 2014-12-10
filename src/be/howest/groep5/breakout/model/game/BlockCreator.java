package be.howest.groep5.breakout.model.game;

import java.awt.*;

/**
 * Created by Kenny on 17/11/2014.
 */
public class BlockCreator {
    private Rectangle block;
    private int x, y, numberOfHitsLeft;
    private int score;
    private Color color;
    private boolean power;


    public BlockCreator(int x, int y, int numberOfHits, Color color, boolean power, int length, int height, int score){
        block = new Rectangle(x, y, length,height);
        this.x = x;
        this.y = y;
        this.color = color;
        this.score = score;
        numberOfHitsLeft = numberOfHits;
        this.power = power;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public Rectangle getBlock() {
        return block;
    }
    public int getScore() {
        return score;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public int getNumberOfHitsLeft() {
        return numberOfHitsLeft;
    }

    public Color getColor() {
        return color;
    }

    public boolean hasAPower() {
        return power;
    }

    public void setNumberOfHitsLeft(int numberOfHitsLeft) {
        this.numberOfHitsLeft = numberOfHitsLeft;
    }
}
