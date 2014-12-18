package be.howest.groep5.breakout.model.game;

import be.howest.groep5.breakout.data.Database;
import be.howest.groep5.breakout.view.game.ScoreObserver;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Kenny on 12/11/2014.
 */


public class Ball implements Runnable {
    private int x, y, xDirection, yDirection, p1Score, p2Score, numberOfLifes, difficulty, topBound, lengthBound, speed, startSpeed, startWidth, level;
    private Rectangle ball;
    private Paddle p1, p2;
    private boolean singlePlayer, playing;
    private ScreenCreate screenCreate;
    private PowerCreator powerCreator;
    private ShooterCreator shooterCreator;
    private boolean intersected, breakBlocks, shoot;
    private List<ScoreObserver> observers;

    public Ball(boolean singlePlayer, int difficulty, int panelWidth){
        p1 = new Paddle(475,700,panelWidth,1);
        p2 = new Paddle(475,10, panelWidth, 2);
        setLevel(0);


        setStartSpeed(Database.DatabaseInstance.fillLevels().get(getLevel()).getBallSpeed());
        setStartWidth(15);

        shoot = false;

        this.difficulty = difficulty;
        intersected = false;
        breakBlocks = true;

        setX(p1.getX() + (p1.getPaddle().width / 2));
        setY(p1.getY() - p1.getPaddle().height);

        this.singlePlayer = singlePlayer;
        this.difficulty = difficulty;
        numberOfLifes = 3;
        startRandomX();
        startRandomY();

        ball = new Rectangle(getX(),getY(),15,15);
        setTopBound(1000 - ball.height);
        setLengthBound(1000 - ball.width);
        playing = false;

        observers = new ArrayList<ScoreObserver>();

        setP1Score(0);
        setP2Score(0);
        setSpeed(Database.DatabaseInstance.fillLevels().get(getLevel()).getBallSpeed());
        powerCreator = new PowerCreator(1,true, this, p1,0,0);

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
    public void setPlaying(boolean playing) {
        this.playing = playing;
    }
    public void setScreenCreate(ScreenCreate screenCreate) {
        this.screenCreate = screenCreate;
    }
    public void setStartSpeed(int startSpeed) {
        this.startSpeed = startSpeed;
    }
    public void setStartWidth(int startWidth) {
        this.startWidth = startWidth;
    }
    public void setBreakBlocks(boolean breakBlocks) {
        this.breakBlocks = breakBlocks;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setShooterCreator(ShooterCreator shooterCreator) {
        this.shooterCreator = shooterCreator;
    }
    public void setShoot(boolean shoot) {
        this.shoot = shoot;
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
    public int getP2Score() {
        return p2Score;
    }
    public int getP1Score() {
        return p1Score;
    }
    public boolean isSinglePlayer() {
        return singlePlayer;
    }
    public Rectangle getBall() {
        return ball;
    }
    public ScreenCreate getScreenCreate() {
        return screenCreate;
    }
    public int getLengthBound() {
        return lengthBound;
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
    public PowerCreator getPowerCreator() {
        return powerCreator;
    }
    public int getLevel() {
        return level;
    }
    public int getStartSpeed() {
        return startSpeed;
    }
    public int getStartWidth() {
        return startWidth;
    }
    public ShooterCreator getShooterCreator() {
        return shooterCreator;
    }

    public boolean canShoot() {
        return shoot;
    }

    public boolean isPlaying() {
        return playing;
    }
    public boolean isIntersected() {
        return intersected;
    }

    public boolean canBreakBlocks() {
        return breakBlocks;
    }

    private void startRandomX(){
        Random r = new Random();
        int rDirection = r.nextInt(2);
        if(rDirection == 0)
            rDirection--;
        setxDirection(rDirection);
    }
    private void startRandomY(){
        if(singlePlayer)
            setyDirection(-1);
        else
            setyDirection(1);
    }

    private void powersCollision(BlockCreator blockCreator){
        Random r = new Random();

        if(blockCreator.hasAPowerUp()){
            int temp = r.nextInt(Database.DatabaseInstance.fillPowers(true).size());
            powerCreator = new PowerCreator(temp, Database.DatabaseInstance.fillPowers(true).get(temp).isPowerup(), this, p1, blockCreator.getX(), blockCreator.getY());
            powerCreator.setIntersection(true);
            Thread t = new Thread(powerCreator);
            t.start();
        }
        if(blockCreator.hasAPowerDown()){
            int temp = r.nextInt(Database.DatabaseInstance.fillPowers(false).size());
            powerCreator = new PowerCreator(temp, Database.DatabaseInstance.fillPowers(false).get(temp).isPowerup(), this, p1, blockCreator.getX(), blockCreator.getY());
            powerCreator.setIntersection(true);
            Thread t = new Thread(powerCreator);
            t.start();
        }


    }
    
    private void blockBounceHorizontal(BlockCreator blockCreator){
        if(ball.x <= blockCreator.getBlock().x + blockCreator.getBlock().width/2) {
            setyDirection(getYDirection() * -1);
            setxDirection(-1);
        }
        if(ball.x > blockCreator.getBlock().x + blockCreator.getBlock().width/2 && ball.x <= blockCreator.getBlock().x + blockCreator.getBlock().width) {
            setyDirection(getYDirection() * -1);
            setxDirection(1);
        }
    }
    private void blockBounceVertical(BlockCreator blockCreator){
        if(ball.y <= blockCreator.getBlock().y + blockCreator.getBlock().height/2){
            setxDirection(getXDirection() * -1);
            setyDirection(-1);
        }
        if(ball.y > blockCreator.getBlock().y + blockCreator.getBlock().height/2 && ball.y <= blockCreator.getBlock().y + blockCreator.getBlock().height){
            setxDirection(getXDirection() *-1);
            setyDirection(1);
        }
    }
    private void afterCollision(BlockCreator blockCreator){
        if (blockCreator.getNumberOfHitsLeft() == 1)
            screenCreate.setNumberOfBrokenBlocks(screenCreate.getNumberOfBrokenBlocks() + 1);
        blockCreator.setNumberOfHitsLeft(blockCreator.getNumberOfHitsLeft() - 1);
        p1Score += blockCreator.getScore();
        if (difficulty == 1)
            p1Score += 5;
        if (difficulty == 2)
            p1Score += 10;
        notifyObservers();
    }

    private void powerCollisionWithPaddle(){
        if(p1.getPaddle().intersects(powerCreator.getPower()) || p2.getPaddle().intersects(powerCreator.getPower())) {
            powerCreator.setIntersection(false);
            powerCreator.returnPower();
            powerCreator.setIntersection(false);
        }
        if(p2.getPaddle().intersects(powerCreator.getPower())) {
            powerCreator.setPaddle(p2);

        }
    }
    private void shooterCollision(BlockCreator blockCreator){
        if(canShoot() && getShooterCreator().getShooter().intersects(blockCreator.getBlock()) && blockCreator.getNumberOfHitsLeft() != 0) {
            powersCollision(blockCreator);
            blockBounceHorizontal(blockCreator);
            blockBounceVertical(blockCreator);
            afterCollision(blockCreator);
            setShoot(false);
        }

    }

    public void collision(){
        if(ball.intersects(p1.getPaddle())){
            setyDirection(-1);
            if(ball.x <= p1.getPaddle().x + (p1.getPaddle().width)/2)
                setxDirection(-1);
            if(ball.x > p1.getPaddle().x + (p1.getPaddle().width)/2)
                setxDirection(1);
            setBreakBlocks(true);
        }
        if(ball.intersects(p2.getPaddle())) {
            intersected = true;
            setyDirection(+1);
            setBreakBlocks(true);
        }
        if(canBreakBlocks()) {
            for (BlockCreator blockCreator : getScreenCreate().getBlockCreatorList()) {
                if (ball.intersects(blockCreator.getBlock()) && blockCreator.getNumberOfHitsLeft() != 0) {
                    powersCollision(blockCreator);

                    blockBounceHorizontal(blockCreator);
                    blockBounceVertical(blockCreator);

                    afterCollision(blockCreator);
                }
                shooterCollision(blockCreator);
                powerCollisionWithPaddle();
            }
        }
        if(p1.getPaddle().intersects(powerCreator.getPower())) {
            powerCreator.setIntersection(false);
            if(isSinglePlayer()){
                powerCreator.returnPower();
            }
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
            if(!singlePlayer){
                setX(p2.getPaddle().x + (p1.getPaddle().width/2));
                setY(p2.getY());
                ball = new Rectangle(getX(),getY(),15,15);
                numberOfLifes--;
                playing = false;
                notifyObservers();
            }
            setyDirection(+1);
        }
        if(ball.y >= 750) {
            if(playing) {
                setX(p1.getPaddle().x + (p1.getPaddle().width / 2));
                setY(p1.getY() - p1.getPaddle().height);
                ball = new Rectangle(getX(), getY(), 15, 15);
            }
            numberOfLifes--;
            setyDirection(-1);
            playing = false;
            notifyObservers();
        }
    }
    @Override
    public void run() {
        try{
            while(true){
                if(isPlaying() && numberOfLifes != 0) {
                    move();
                }
                Thread.sleep(getSpeed());
            }
        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }

    public void addObserver(ScoreObserver o) {
        observers.add(o);
    }

    public void notifyObservers() {
        for (ScoreObserver o : observers) {
            o.update(p1Score, p2Score, numberOfLifes);
        }
    }
}
