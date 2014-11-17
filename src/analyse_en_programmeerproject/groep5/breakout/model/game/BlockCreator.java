package analyse_en_programmeerproject.groep5.breakout.model.game;

import analyse_en_programmeerproject.groep5.breakout.data.Database;

import java.awt.*;

/**
 * Created by Kenny on 17/11/2014.
 */
public class BlockCreator {
    private Rectangle block;
    private int numberOfHitsLeft;

    public BlockCreator(){
        //block = new Rectangle(Database.DatabaseInstance.fillBlocks().get(0).getHorizontalLength(), Database.DatabaseInstance.fillBlocks().get(0).getVerticalLength(), 100,100);
        block = new Rectangle(100,100,30,15);
        numberOfHitsLeft = 1;
    }

    public void draw(Graphics g){
        g.setColor(Color.black);
        g.fillRect(block.x, block.y, block.width, block.height);
        if(numberOfHitsLeft == 0){
            g.clearRect(0,0,block.width,block.height);
        }

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
