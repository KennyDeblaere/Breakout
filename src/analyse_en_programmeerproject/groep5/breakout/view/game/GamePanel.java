package analyse_en_programmeerproject.groep5.breakout.view.game;

import analyse_en_programmeerproject.groep5.breakout.controller.game.MovePanelController;
import analyse_en_programmeerproject.groep5.breakout.model.game.Ball;
import analyse_en_programmeerproject.groep5.breakout.model.game.BlockCreator;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelCenter;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kenny on 12/11/2014.
 */
public class GamePanel extends JPanel {
    private Image dbImage;
    private Graphics dbGraphics;
    private Thread ball, p1;

    private Ball b;
    private PanelCenter centerPanel;

    private boolean singleplayer;
    private int difficulty;

    public GamePanel(PanelCenter c){
        centerPanel = c;
        centerPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        b = new Ball(false, 0);
        setPreferredSize(new Dimension(1000, 750));
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
            g.setColor(Color.BLUE);
            g.fillRect(b.getBall().x, b.getBall().y, b.getBall().width, b.getBall().height);
            drawPaddle(g, b.getP1().getId(), b.getP1().getPaddle());
            if (!b.isSingleplayer()) {
                drawPaddle(g, b.getP2().getId(), b.getP2().getPaddle());
            }
            g.setColor(Color.YELLOW);
            for(BlockCreator blockCreator: b.getBlockCreatorList()) {
                if (blockCreator.getNumberOfHitsLeft() > 0) {
                    g.fillRect(blockCreator.getBlock().x, blockCreator.getBlock().y, blockCreator.getBlock().width, blockCreator.getBlock().height);
                }
            }
        }
        else{
            //g.setColor(Color.black);
            //g.drawString("GAME OVER", 15,500);
            centerPanel.addMainComponents();
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
