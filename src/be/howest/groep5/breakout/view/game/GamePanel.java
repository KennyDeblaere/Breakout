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

    public GamePanel(CenterPanel c, boolean singleplayer, int difficulty){
        centerPanel = c;
        this.singleplayer = singleplayer;
        this.difficulty = difficulty;
        b = new Ball(singleplayer, difficulty);
        setPreferredSize(new Dimension(1001, 710));
        setBackground(Color.WHITE);
        ball = new Thread(b);
        p1 = new Thread(b.getP1());
        levelNumber = 0;
        screenCreate = new ScreenCreate(singleplayer,levelNumber,getNumberOfBlocks(difficulty));

        addKeyListener(new MovePanelController(b));

        setFocusable(true);
        setRequestFocusEnabled(true);
        requestFocusInWindow();
    }

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
    }

    public void startGame(){
        ball.start();
        p1.start();
        if(!b.isSingleplayer()){
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
                g.fillRect(b.getPowerCreator().getPower().x, b.getPowerCreator().getPower().y, b.getPowerCreator().getPower().width, b.getPowerCreator().getPower().height);
            }
            if (!b.isSingleplayer()) {
                drawPaddle(g, b.getP2().getId(), b.getP2().getPaddle());
            }
            if(screenCreate.getNumberOfBrokenBlocks() == screenCreate.getBlockCreatorList().size()){
                levelNumber += 1;
                screenCreate = new ScreenCreate(singleplayer,levelNumber,getNumberOfBlocks(difficulty));
                b.setScreenCreate(screenCreate);
                b.getBall().x = b.getP1().getPaddle().x + b.getP1().getPaddle().width/2;
                b.setPlaying(false);
            }
            for(BlockCreator blockCreator: screenCreate.getBlockCreatorList()) {
                if (blockCreator.getNumberOfHitsLeft() != 0) {
                    g.setColor(blockCreator.getColor());
                    g.fillRect(blockCreator.getBlock().x, blockCreator.getBlock().y, blockCreator.getBlock().width, blockCreator.getBlock().height);
                    g.setColor(Color.black);
                    g.drawRect(blockCreator.getBlock().x, blockCreator.getBlock().y, blockCreator.getBlock().width, blockCreator.getBlock().height);
                }
            }
            scorePanel.changeTexts(b.getP1Score(), b.getP2Score(), b.getNumberOfLifes());
        }
        else{
            centerPanel.addHighScoreAddPanel(b.getP1Score());

        }
        repaint();
    }

    public Ball getB() {
        return b;
    }
}
