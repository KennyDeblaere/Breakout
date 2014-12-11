package be.howest.groep5.breakout.model.game;

import be.howest.groep5.breakout.data.Database;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Kenny on 12/11/2014.
 */
public class Ball implements Runnable {
    private int x, y, xDirection, yDirection, xPosition, yPosition, p1Score, p2Score, numberOfLifes, difficulty, numberOfLines, scoreAndDif, topBound, lengthBound, speed;
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
        numberOfLifes = 3;
        createScreen(getNumberOfBlocks(difficulty));
        startRandomX();
        startRandomY();

        ball = new Rectangle(getX(),getY(),7,7);
        setTopBound(1000 - ball.height);
        setLengthBound(1000 - ball.width);

        setP1Score(0);
        setP2Score(0);
        setSpeed(7);

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
    public void setTopBound(int topBound) {
        this.topBound = topBound;
    }
    public void setLengthBound(int lengthBound) {
        this.lengthBound = lengthBound;
    }
    public void setNumberOfLifes(int numberOfLifes) {
        this.numberOfLifes = numberOfLifes;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public int getXDirection() {
        return xDirection;
    }
    public int getYDirection() {
        return yDirection;
    }
    public int getXPosition() {
        return xPosition;
    }
    public int getYPosition() {
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
    private int getNumberOfBlocks(int difficulty){
        switch (difficulty){
            case 0:
                scoreAndDif = 1;
                return 4;
            case 1:
                scoreAndDif = 2;
                return 6;
            default:
                scoreAndDif = 3;
                return 7;
        }
    }
    public int getTopBound() {
        return topBound;
    }
    public int getLengthBound() {
        return lengthBound;
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
    public int getSpeed() {
        return speed;
    }
    private void createScreen(int numberOfBlocks){
        BlockCreators blockCreators = new BlockCreators(getXPosition(), getYPosition());
        blockCreatorList = new ArrayList<>();
        Random r = new Random();
        if(blockCreators.getBlockCreators().size() < numberOfBlocks)
            numberOfBlocks = blockCreators.getBlockCreators().size();
        int counter = 0;
        while(counter < numberOfLines){
            int temp = r.nextInt(numberOfBlocks);

            if(getXPosition() + blockCreators.getBlockCreators().get(temp).getBlock().width < 1000) {
                if(temp == 6)
                    numberOfUnbreakables++;

                blockCreatorList.add(blockCreators.getBlockCreators().get(temp));
                setxPosition(getXPosition() + blockCreators.getBlockCreators().get(temp).getBlock().width);
                blockCreators = new BlockCreators(getXPosition(), getYPosition());
            } else {
                //waarschijnlijk meer optimaliseerbaar in een while waarmee je de rest eerst opvult ;)
                for(int i=0; i<blockCreators.getBlockCreators().size();i++){
                    if(blockCreators.getBlockCreators().get(i).getBlock().width + getXPosition() == 1000)
                        blockCreatorList.add(blockCreators.getBlockCreators().get(i));
                }

                counter++;
                setyPosition(getYPosition() + 50);
                setxPosition(0);
                blockCreators = new BlockCreators(getXPosition(), getYPosition());
            }
        }
        if(numberOfUnbreakables == blockCreatorList.size())
            createScreen(numberOfBlocks);
    }


    public void collision(){
        if(ball.intersects(p1.getPaddle())){
            setyDirection(-1);
            if(ball.x <= p1.getPaddle().x + (p1.getPaddle().width)/2)
                setxDirection(-1);
            if(ball.x > p1.getPaddle().x + (p1.getPaddle().width)/2)
                setxDirection(1);

        }
        if(ball.intersects(p2.getPaddle()))
            setyDirection(+1);
        for(BlockCreator blockCreator : blockCreatorList) {
            if (ball.intersects(blockCreator.getBlock()) && blockCreator.getNumberOfHitsLeft() != 0) {
                if(blockCreator.hasAPower() && blockCreator.getColor() == Color.GREEN){
                    Random r = new Random();
                    int temp = r.nextInt(Database.DatabaseInstance.fillPowers(true).size());
                    if(singleplayer) {
                        new PowerCreator(temp, Database.DatabaseInstance.fillPowers(true).get(temp).isPowerup(), this, p1);
                        p1Score += 100;
                    }
                    else if(! singleplayer && getYDirection() == 1) {
                        new PowerCreator(temp, Database.DatabaseInstance.fillPowers(true).get(temp).isPowerup(), this, p2);
                        p2Score -= 100;
                    }
                }
                if(blockCreator.hasAPower() && blockCreator.getColor() == Color.RED){
                    Random r = new Random();
                    int temp = r.nextInt(Database.DatabaseInstance.fillPowers(false).size());
                    if(singleplayer)
                        new PowerCreator(temp, Database.DatabaseInstance.fillPowers(false).get(temp).isPowerup(), this, p1);
                    else if(! singleplayer && getYDirection() == 1)
                        new PowerCreator(temp, Database.DatabaseInstance.fillPowers(false).get(temp).isPowerup(), this, p2);
                }
                if(ball.x <= blockCreator.getBlock().x + blockCreator.getBlock().width/2) {
                    setyDirection(getYDirection() * -1);
                    setxDirection(-1);
                }
                if(ball.x > blockCreator.getBlock().x + blockCreator.getBlock().width/2 && ball.x <= blockCreator.getBlock().x + blockCreator.getBlock().width) {
                    setyDirection(getYDirection() * -1);
                    setxDirection(1);
                }
                if(ball.y <= blockCreator.getBlock().y + blockCreator.getBlock().height/2){
                    setxDirection(getXDirection() * -1);
                    setyDirection(-1);
                }
                if(ball.y > blockCreator.getBlock().y + blockCreator.getBlock().height/2 && ball.y <= blockCreator.getBlock().y + blockCreator.getBlock().height){
                    setxDirection(getXDirection() *-1);
                    setyDirection(1);
                }
                blockCreator.setNumberOfHitsLeft(blockCreator.getNumberOfHitsLeft() - 1);
                p1Score += blockCreator.getScore();
                if(difficulty == 1)
                    p1Score += 5;
                if(difficulty == 2)
                    p1Score += 10;
        }
            if(blockCreator.getNumberOfHitsLeft() == 0)
                numberOfUnbreakables++;
        }
    }

    public void move(){
        collision();
        ball.x += xDirection;
        ball.y += yDirection;

        if(ball.x <= 0){
            setxDirection(+1);
        }
        if(ball.x >= getLengthBound()){
            setxDirection(-1);
        }
        if(ball.y <= 0){
            if(!singleplayer){
                setX(p2.getPaddle().x + (p1.getPaddle().width/2));
                setY(p2.getY());
                ball = new Rectangle(getX(),getY(),7,7);
                numberOfLifes--;
            }
            setyDirection(+1);
        }
        if(ball.y >= 750) {
            setX(p1.getPaddle().x + (p1.getPaddle().width/2));
            setY(p1.getY());
            ball = new Rectangle(getX(),getY(),7,7);
            numberOfLifes--;
            setyDirection(-1);
        }
    }
    @Override
    public void run() {
        try{
            while(true){
                if(numberOfLifes != 0) {
                    move();
                    Thread.sleep(getSpeed());
                }
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
