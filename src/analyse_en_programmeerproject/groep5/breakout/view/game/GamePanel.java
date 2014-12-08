package analyse_en_programmeerproject.groep5.breakout.view.game;

import analyse_en_programmeerproject.groep5.breakout.controller.game.MovePanelController;
import analyse_en_programmeerproject.groep5.breakout.model.game.Ball;
import analyse_en_programmeerproject.groep5.breakout.model.game.BlockCreator;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelCenter;

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
    private PanelCenter centerPanel;

    private boolean singleplayer;

    public GamePanel(PanelCenter c, int rows, boolean singleplayer){
        centerPanel = c;
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black,5,true));
        this.singleplayer = singleplayer;

        b = new Ball(singleplayer, 0, rows);
        setPreferredSize(new Dimension(1001, 710));
        setBackground(Color.WHITE);
        ball = new Thread(b);
        p1 = new Thread(b.getP1());


        addKeyListener(new MovePanelController(b));

        setFocusable(true);
        setRequestFocusEnabled(true);
        requestFocus();
    }

    public void startGame(){
        ball.start();
        p1.start();
        if(!b.isSingleplayer()){
            Thread p2 = new Thread(b.getP2());
            p2.start();
        }
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
        if(b.getNumberOfLifes() != 0) {
            g.setColor(Color.black);
            g.drawString("Levens: ",0,0);
            g.setColor(Color.BLUE);
            int positionx = 100;
            for(int i=0; i<b.getNumberOfLifes();i++){
                g.fillOval(positionx,0,10,10);
                positionx += 15;
            }
            g.fillOval(b.getBall().x, b.getBall().y, b.getBall().width, b.getBall().height);
            drawPaddle(g, b.getP1().getId(), b.getP1().getPaddle());
            if (!b.isSingleplayer()) {
                drawPaddle(g, b.getP2().getId(), b.getP2().getPaddle());
            }
            for(BlockCreator blockCreator: b.getBlockCreatorList()) {
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
        //g.setColor(Color.black);
        //g.drawString("" + b.getP1Score(), 15, 20);
        //g.drawString("" + b.getP2Score(),15,200);
        repaint();
    }

    public void setSingleplayer(boolean singleplayer) {
        this.singleplayer = singleplayer;
    }
}
