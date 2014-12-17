package be.howest.groep5.breakout.model.game;

import be.howest.groep5.breakout.data.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Kenny on 17/12/2014.
 */
public class ScreenCreate {
    private List<BlockCreator> blockCreatorList;
    private int levelNumber, numberOfBrokenBlocks, xPosition, yPosition, numberOfBlocks;
    private boolean singlePlayer;

    public ScreenCreate(boolean singlePlayer, int levelNumber, int numberOfBlocks){
        setXPosition(0);
        setNumberOfBrokenBlocks(0);
        setLevelNumber(levelNumber);
        setNumberOfBlocks(numberOfBlocks);
        if(!singlePlayer)
            setYPosition((690 - (Database.DatabaseInstance.fillLevels().get(getLevelNumber()).getNumberOfRows()*50))/2);
        else
            setYPosition(100);
        createScreen(getNumberOfBlocks());
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }
    public void setLevelNumber(int levelNumber) {
        if(levelNumber >= 0)
            this.levelNumber = levelNumber;
        else
            this.levelNumber = 0;
    }
    public void setNumberOfBlocks(int numberOfBlocks) {
        if(numberOfBlocks >= 0 && numberOfBlocks <= Database.DatabaseInstance.fillBlocks().size())
            this.numberOfBlocks = numberOfBlocks;
        else
            this.numberOfBlocks = Database.DatabaseInstance.fillBlocks().size();
    }
    public void setNumberOfBrokenBlocks(int numberOfBrokenBlocks) {
        this.numberOfBrokenBlocks = numberOfBrokenBlocks;
    }

    public int getXPosition() {
        return xPosition;
    }
    public int getYPosition() {
        return yPosition;
    }
    public int getLevelNumber() {
        return levelNumber;
    }
    public int getNumberOfBlocks() {
        return numberOfBlocks;
    }
    public int getNumberOfBrokenBlocks() {
        return numberOfBrokenBlocks;
    }
    public List<BlockCreator> getBlockCreatorList() {
        return blockCreatorList;
    }

    private void createScreen(int numberOfBlocks){
        BlockCreators blockCreators = new BlockCreators(getXPosition(), getYPosition());
        blockCreatorList = new ArrayList<>();
        Random r = new Random();
        if(blockCreators.getBlockCreators().size() < numberOfBlocks)
            numberOfBlocks = blockCreators.getBlockCreators().size();
        int counter = 0;
        while(counter < Database.DatabaseInstance.fillLevels().get(getLevelNumber()).getNumberOfRows()){
            int temp = r.nextInt(numberOfBlocks);

            if(getXPosition() + blockCreators.getBlockCreators().get(temp).getBlock().width < 1000) {
                if(temp == 6)
                    setNumberOfBlocks(getNumberOfBlocks() + 1);

                blockCreatorList.add(blockCreators.getBlockCreators().get(temp));
                setXPosition(getXPosition() + blockCreators.getBlockCreators().get(temp).getBlock().width);
                blockCreators = new BlockCreators(getXPosition(), getYPosition());
            } else {
                //waarschijnlijk meer optimaliseerbaar in een while waarmee je de rest eerst opvult ;)
                for(int i=0; i<numberOfBlocks;i++){
                    if(blockCreators.getBlockCreators().get(i).getBlock().width + getXPosition() == 1000)
                        blockCreatorList.add(blockCreators.getBlockCreators().get(i));
                }

                counter++;
                setYPosition(getYPosition() + 50);
                setXPosition(0);
                blockCreators = new BlockCreators(getXPosition(), getYPosition());
            }
        }
    }

}
