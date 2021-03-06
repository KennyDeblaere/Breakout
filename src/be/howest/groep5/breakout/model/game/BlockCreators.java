package be.howest.groep5.breakout.model.game;

import be.howest.groep5.breakout.data.Database;
import be.howest.groep5.breakout.model.Block;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class BlockCreators {
    private List<BlockCreator> blockCreators;
    public BlockCreators(int x, int y){
        blockCreators = new ArrayList<>();
        for(Block b : Database.DatabaseInstance.fillBlocks()){
            blockCreators.add(new BlockCreator(x,y,b.getNumberOfHitsBeforeVanish(),b.getColor(), b.hasAPowerUp(),b.hasAPowerDown(), b.getHorizontalLength(),b.getVerticalLength(),b.getScore()));
        }
    }

    public List<BlockCreator> getBlockCreators() {
        return blockCreators;
    }
}
