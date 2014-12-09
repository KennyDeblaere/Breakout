package analyse_en_programmeerproject.groep5.breakout.model.game;

import analyse_en_programmeerproject.groep5.breakout.data.Database;
import analyse_en_programmeerproject.groep5.breakout.model.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kenny on 9/12/2014.
 */
public class BlockCreators {
    private List<BlockCreator> blockCreators;
    public BlockCreators(int x, int y){
        blockCreators = new ArrayList<>();
        for(Block b : Database.DatabaseInstance.fillBlocks()){
            blockCreators.add(new BlockCreator(x,y,b.getNumberOfHitsBeforeVanish(),b.getColor(), b.hasAPower(),b.getHorizontalLength(),b.getVerticalLength(),b.getScore()));
        }
    }

    public List<BlockCreator> getBlockCreators() {
        return blockCreators;
    }
}
