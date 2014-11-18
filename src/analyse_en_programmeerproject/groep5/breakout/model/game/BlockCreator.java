package analyse_en_programmeerproject.groep5.breakout.model.game;

import analyse_en_programmeerproject.groep5.breakout.data.Database;

import java.awt.*;

/**
 * Created by Kenny on 17/11/2014.
 */
public class BlockCreator {
    private Rectangle block;
    private int numberOfHitsLeft;

    public BlockCreator(int numberOfHits){
        //block = new Rectangle(Database.DatabaseInstance.fillBlocks().get(0).getHorizontalLength(), Database.DatabaseInstance.fillBlocks().get(0).getVerticalLength(), 100,100);
        block = new Rectangle(100,100,30,15);
        numberOfHitsLeft = numberOfHits;
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
