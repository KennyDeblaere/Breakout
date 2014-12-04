package analyse_en_programmeerproject.groep5.breakout.model.game;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Kenny on 12/11/2014.
 */
public class Ball implements Runnable {
    private int x, y, xDirection, yDirection, xPosition, yPosition, p1Score, p2Score, numberOfLifes, difficulty, numberOfLines;
    private Rectangle ball;
    private int numberOfUnbreakables;
    private Paddle p1, p2;
    private List<BlockCreator> blockCreatorList;
    private boolean singleplayer;
    public Ball(boolean singleplayer, int difficulty, int numberOfLines){
        p1 = new Paddle(475,700,1);
        p2 = new Paddle(475,15, 2);

        numberOfUnbreakables = 0;

        this.difficulty = difficulty;
        this.numberOfLines = numberOfLines;

        setX(p1.getX() + (p1.getPaddle().width / 2));
        setY(p1.getY());
        setxPosition(0);
        setyPosition(100);

        this.singleplayer = singleplayer;
        this.difficulty = difficulty;
        numberOfLifes  = 3;

        createScreen(7);
        //Ball random laten starten
        startRandomX();
        startRandomY();

        //Creeer ball
        ball = new Rectangle(getX(),getY(),7,7);

        setP1Score(0);
        setP2Score(0);

    }

    private void startRandomX(){
        Random r = new Random();
        int rDirection = r.nextInt(2);
        if(rDirection == 0)
            rDirection--;
        setxDirection(rDirection);
    }

    private void startRandomY(){
        Random r = new Random();
        int rDirection = r.nextInt(2);
        if(rDirection == 0)
            rDirection--;
        setyDirection(rDirection);
    }

    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }
    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }
    public void setxPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    public void setyPosition(int yPosition) {
        this.yPosition = yPosition;
    }
    public void setP1Score(int p1Score) {
        this.p1Score = p1Score;
    }
    public void setP2Score(int p2Score) {
        this.p2Score = p2Score;
    }

    public void setSingleplayer(boolean singleplayer) {
        this.singleplayer = singleplayer;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getxDirection() {
        return xDirection;
    }
    public int getyDirection() {
        return yDirection;
    }
    public int getxPosition() {
        return xPosition;
    }
    public int getyPosition() {
        return yPosition;
    }
    public int getP2Score() {
        return p2Score;
    }
    public int getP1Score() {
        return p1Score;
    }

    public int getNumberOfUnbreakables() {
        return numberOfUnbreakables;
    }


    public boolean isSingleplayer() {
        return singleplayer;
    }

    public Rectangle getBall() {
        return ball;
    }

    private BlockCreator[] blocksInArray(){
        BlockCreator[] blockCreators = new BlockCreator[7];
        blockCreators[0] = new BlockCreator(getxPosition(),getyPosition(),1,Color.YELLOW,false, 100,50,10);
        blockCreators[1] = new BlockCreator(getxPosition(),getyPosition(),1,Color.ORANGE, false, 50,50,10);
        blockCreators[2] = new BlockCreator(getxPosition(),getyPosition(),1,Color.PINK, false, 25,50,10);
        blockCreators[3] = new BlockCreator(getxPosition(),getyPosition(),1,Color.GREEN, true, 50,50,10);
        blockCreators[4] = new BlockCreator(getxPosition(),getyPosition(),1,Color.RED, true, 75,50,10);
        blockCreators[5] = new BlockCreator(getxPosition(),getyPosition(),3,Color.BLUE, false, 100,50,10);
        blockCreators[6] = new BlockCreator(getxPosition(),getyPosition(),-1,Color.GRAY, false,75,50,10);
        return blockCreators;
    }

    private void createScreen(int numberOfBlocks){
        blockCreatorList = new ArrayList<>();
        Random r = new Random();
        int counter = 0;
        while(counter < numberOfLines){
            int temp = r.nextInt(numberOfBlocks);

            if(getxPosition() + blocksInArray()[temp].getBlock().width < 1000) {
                if(temp == 6)
                    numberOfUnbreakables++;

                blockCreatorList.add(blocksInArray()[temp]);
                setxPosition(getxPosition() + blocksInArray()[temp].getBlock().width);
            } else {
                //waarschijnlijk meer optimaliseerbaar in een while waarmee je de rest eerst opvult ;)
                for(int i=0; i<blocksInArray().length;i++){
                    if(blocksInArray()[i].getBlock().width + getxPosition() == 1000)
                        blockCreatorList.add(blocksInArray()[i]);
                }

                counter++;
                setyPosition(getyPosition() + 50);
                setxPosition(0);
            }
        }
        if(numberOfUnbreakables == blockCreatorList.size())
            createScreen(numberOfBlocks);
    }


    public List<BlockCreator> getBlockCreatorList() {
        return blockCreatorList;
    }

    public Paddle getP1() {
        return p1;
    }
    public Paddle getP2() {
        return p2;
    }
    public int getNumberOfLifes() {
        return numberOfLifes;
    }

    public void collision(){
        if(ball.intersects(p1.getPaddle())){
            setyDirection(-1);
            System.out.println(ball.intersection(p1.getPaddle()));
        }
        if(ball.intersects(p2.getPaddle()))
            setyDirection(+1);
        for(BlockCreator blockCreator : blockCreatorList) {
            if (ball.intersects(blockCreator.getBlock()) && blockCreator.getNumberOfHitsLeft() > 0) {
                p1Score = p1Score + 10;
                setyDirection(getyDirection() * -1);
                setxDirection(getxDirection() * -1);
                blockCreator.setNumberOfHitsLeft(blockCreator.getNumberOfHitsLeft() - 1);
                if(blockCreator.getNumberOfHitsLeft() == 0)
                    numberOfUnbreakables++;
                System.out.println(numberOfUnbreakables);
            }
        }
    }

    public void move(){
        collision();
        ball.x += xDirection;
        ball.y += yDirection;

        if(ball.x <= 7){
            setxDirection(+1);
        }
        if(ball.x >= 993){
            setxDirection(-1);
        }
        if(ball.y <= 0){
            if(singleplayer)
                setyDirection(+1);
            else{
                setX(p2.getX() + (p1.getPaddle().width/2));
                setY(p2.getY());
                ball = new Rectangle(getX(),getY(),7,7);
                numberOfLifes--;
                System.out.println(numberOfLifes);
            }
        }
        if(ball.y >= 750){
            setX(p1.getX() + (p1.getPaddle().width/2));
            setY(p1.getY());
            ball = new Rectangle(getX(),getY(),7,7);
            numberOfLifes--;
            System.out.println(numberOfLifes);
            //p1 =  new Paddle(475,700,1);
        }
    }
    @Override
    public void run() {
        try{
            while(true){
                if(numberOfLifes != 0) {
                    move();
                    Thread.sleep(7);
                }
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
