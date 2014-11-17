package analyse_en_programmeerproject.groep5.breakout.view.game;

import analyse_en_programmeerproject.groep5.breakout.controller.game.MovePanelController;
import analyse_en_programmeerproject.groep5.breakout.model.game.Ball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Created by Kenny on 12/11/2014.
 */
public class GamePanel extends JPanel {
    private Image dbImage;
    private Graphics dbGraphics;

    private Ball b;

    public GamePanel(){
        b = new Ball(193,143);
        setPreferredSize(new Dimension(500,400));
        Thread ball = new Thread(b);
        ball.start();
        Thread p1 = new Thread(b.getP1());
        Thread p2 = new Thread(b.getP2());
        p1.start();
        p2.start();
        addKeyListener(new MovePanelController(b));

        setFocusable(true);
        setRequestFocusEnabled(true);
        requestFocus();

    }
    public void paint(Graphics g){
        dbImage = createImage(getWidth(),getHeight());
        dbGraphics = dbImage.getGraphics();
        draw(dbGraphics);
        g.drawImage(dbImage,0,0,this);

    }

    public void draw(Graphics g){
        b.draw(g);
        b.getP1().draw(g);
        b.getP2().draw(g);
        b.getBlockCreator().draw(g);
        g.setColor(Color.black);
        g.drawString("" + b.getP1Score(), 15, 20);
        g.drawString("" + b.getP2Score(),15,200);
        repaint();
    }
}
