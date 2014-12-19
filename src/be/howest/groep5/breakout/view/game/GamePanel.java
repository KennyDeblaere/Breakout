package be.howest.groep5.breakout.view.game;

import be.howest.groep5.breakout.controller.game.MovePanelController;
import be.howest.groep5.breakout.data.Database;
import be.howest.groep5.breakout.model.game.Ball;
import be.howest.groep5.breakout.model.game.BlockCreator;
import be.howest.groep5.breakout.model.game.ScreenCreate;
import be.howest.groep5.breakout.model.multimedia.Multimedia;
import be.howest.groep5.breakout.view.welcome.CenterPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kenny, Blackhat on 12/11/2014.
 */
public class GamePanel extends JPanel {
    private Image dbImage;
    private Graphics dbGraphics;
    private Thread ball, p1;
    private Ball b;
    private CenterPanel centerPanel;
    private boolean singleplayer;
    private int levelNumber, numberOfBlocks, difficulty;
    private ScreenCreate screenCreate;
    private ScorePanel scorePanel;
    private CenterPanel parent;
    private Multimedia multimedia;
    private Image power;

    public GamePanel(CenterPanel c, boolean singleplayer, int difficulty, CenterPanel parent){

        this.parent = parent;
        centerPanel = c;
        this.singleplayer = singleplayer;
        this.difficulty = difficulty;
        b = new Ball(singleplayer, difficulty, Database.DatabaseInstance.fillLevels().get(levelNumber).getPaddleLength());
        levelNumber = 0;
        b.setSpeed(Database.DatabaseInstance.fillLevels().get(levelNumber).getBallSpeed());

        setPreferredSize(new Dimension(1001, 710));
        setBackground(Color.white);
        ball = new Thread(b);
        p1 = new Thread(b.getP1());
        screenCreate = new ScreenCreate(singleplayer,levelNumber,getNumberOfBlocks(difficulty));

        addKeyListener(new MovePanelController(b));

        multimedia = new Multimedia();
        power = multimedia.getPower();

        repaint();
        setFocusable(true);
        setRequestFocusEnabled(true);
        requestFocusInWindow();
    }

    public CenterPanel getCenterPanel() { return parent; }

    private int getNumberOfBlocks(int difficulty){
        if(difficulty == 0)
            numberOfBlocks = 4;
        else if(difficulty == 1)
            numberOfBlocks = 6;
        else
            numberOfBlocks = Database.DatabaseInstance.fillBlocks().size();
        return numberOfBlocks;
    }

    public void setScorePanel(ScorePanel scorePanel) {
        this.scorePanel = scorePanel;
        getB().addObserver(scorePanel);
    }

    public void startGame(){
        ball.start();
        p1.start();
        if(!b.isSinglePlayer()){
            Thread p2 = new Thread(b.getP2());
            p2.start();
        }
        b.setScreenCreate(screenCreate);
    }

    public void paint(Graphics g){
        dbImage = createImage(getWidth(),getHeight());
        dbGraphics = dbImage.getGraphics();
        draw(dbGraphics);
        g.drawImage(dbImage,0,0,this);

    }

    public void drawPaddle(Graphics g, int id, Rectangle paddle){
        switch (id) {
            default:
                System.out.println("Please enter a valid id in paddleConstructor");
                break;
            case 1:
                g.setColor(Color.BLACK);
                g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
                break;
            case 2:
                g.setColor(Color.BLACK);
                g.fillRect(paddle.x, paddle.y, paddle.width, paddle.height);
                break;
        }
    }
    public void draw(Graphics g){
        requestFocus();
        if(b.getNumberOfLifes() != 0) {
            g.setColor(Color.decode("#666666"));
            g.fillOval(b.getBall().x, b.getBall().y, b.getBall().width, b.getBall().height);
            drawPaddle(g, b.getP1().getId(), b.getP1().getPaddle());
            if(b.getPowerCreator().isIntersection()) {
                //g.fillRect(b.getPowerCreator().getPower().x, b.getPowerCreator().getPower().y, b.getPowerCreator().getPower().width, b.getPowerCreator().getPower().height);
                g.drawImage(power,b.getPowerCreator().getPower().x, b.getPowerCreator().getPower().y, null);
            }
            if (!b.isSinglePlayer()) {
                drawPaddle(g, b.getP2().getId(), b.getP2().getPaddle());
            }
            if(b.getShooterCreator() != null){
                g.setColor(Color.decode("#43ABDC"));
                g.fillRect(b.getShooterCreator().getShooter().x, b.getShooterCreator().getShooter().y, b.getShooterCreator().getShooter().width, b.getShooterCreator().getShooter().height);
            }
            if(screenCreate.getNumberOfBrokenBlocks() == screenCreate.getBlockCreatorList().size()){
                levelNumber += 1;
                screenCreate = new ScreenCreate(singleplayer,levelNumber,getNumberOfBlocks(difficulty));
                b.setScreenCreate(screenCreate);
                b.setSpeed(Database.DatabaseInstance.fillLevels().get(levelNumber).getBallSpeed());
                b.getP1().setWidth(Database.DatabaseInstance.fillLevels().get(levelNumber).getPaddleLength());
                b.getP2().setWidth(Database.DatabaseInstance.fillLevels().get(levelNumber).getPaddleLength());
                b.getBall().x = b.getP1().getPaddle().x + b.getP1().getPaddle().width/2;
                b.setStartSpeed(Database.DatabaseInstance.fillLevels().get(levelNumber).getBallSpeed());
                b.setBreakBlocks(false);
            }
            for(BlockCreator blockCreator: screenCreate.getBlockCreatorList()) {
                if (blockCreator.getNumberOfHitsLeft() != 0) {
                    g.setColor(blockCreator.getColor());
                    g.fillRect(blockCreator.getBlock().x, blockCreator.getBlock().y, blockCreator.getBlock().width, blockCreator.getBlock().height);
                    g.setColor(Color.black);
                    g.drawRect(blockCreator.getBlock().x, blockCreator.getBlock().y, blockCreator.getBlock().width, blockCreator.getBlock().height);
                }
            }
        }
        else{
            centerPanel.addHighScoreAddPanel(b.getP1Score());
        }
        repaint();
    }

    public Boolean getGameMode() { return singleplayer; }

    public Ball getB() {
        return b;
    }
}
