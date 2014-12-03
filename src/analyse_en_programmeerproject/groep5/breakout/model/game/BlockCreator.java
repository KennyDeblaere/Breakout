package analyse_en_programmeerproject.groep5.breakout.model.game;

import analyse_en_programmeerproject.groep5.breakout.data.Database;

import java.awt.*;

/**
 * Created by Kenny on 17/11/2014.
 */
public class BlockCreator {
    private Rectangle block;
    private int x, y, numberOfHitsLeft;


    public BlockCreator(int x, int y, int numberOfHits){
        block = new Rectangle(x, y, 500,20);
        this.x = x;
        this.y = y;
        numberOfHitsLeft = numberOfHits;
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

    public int getNumberOfHitsLeft() {
        return numberOfHitsLeft;
    }

    public void setNumberOfHitsLeft(int numberOfHitsLeft) {
        this.numberOfHitsLeft = numberOfHitsLeft;
    }
}
