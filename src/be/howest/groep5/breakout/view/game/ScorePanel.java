package be.howest.groep5.breakout.view.game;

import be.howest.groep5.breakout.model.multimedia.Multimedia;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by Blackhat on 16/12/2014.
 */
public class ScorePanel extends JPanel{
    private JPanel scorePanel, singlePanel, coopPanel, infoPanel;
    private JLabel titelLabel, scoresingle, scorecoop, pause, timer;
    private int seconds = 10;
    private Boolean singleplayer;
    private Multimedia multimedia;
    private Image background;

    public ScorePanel(boolean singleplayer){
        super();

        this.singleplayer = singleplayer;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, 710));
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
        createComponents();
        setComponents();
        addComponents();
        setBackground();
    }

    private void createComponents() {
        multimedia = new Multimedia();
        scorePanel = new JPanel();
        infoPanel = new JPanel(new GridLayout(2,1,0,10));
        singlePanel = new JPanel();
        coopPanel = new JPanel();
        titelLabel = new JLabel("Scoreboard");
        scoresingle = new JLabel("Score: 0");
        scorecoop = new JLabel("Score: 0");
        pause = new JLabel("Press \"P\" for pause the game");
        timer = new JLabel("Power up/down for : " + seconds + "seconds");
    }

    private void setComponents(){
        Font fonts = new Font(null, Font.BOLD, 15);
        titelLabel.setFont(new Font(null, Font.BOLD, 30));
        titelLabel.setForeground(Color.white);
        scoresingle.setForeground(Color.white);
        scorecoop.setForeground(Color.white);
        pause.setForeground(Color.white);
        timer.setForeground(Color.white);
        singlePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white, 2, true), "Player 1", TitledBorder.LEFT, TitledBorder.TOP, fonts, Color.white));
        singlePanel.setPreferredSize(new Dimension(175, 150));
        singlePanel.add(scoresingle);
        singlePanel.setOpaque(false);
        coopPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white, 2, true), "Player 2", TitledBorder.LEFT, TitledBorder.TOP, fonts, Color.white));
        coopPanel.setPreferredSize(new Dimension(175, 150));
        coopPanel.add(scorecoop);
        coopPanel.setOpaque(false);
        infoPanel.add(pause);
        infoPanel.add(timer);
        infoPanel.setOpaque(false);
        scorePanel.add(titelLabel);
        scorePanel.add(singlePanel);
        if (!singleplayer){
            scorePanel.add(coopPanel);
        }
        scorePanel.add(infoPanel);
        scorePanel.setOpaque(false);
    }

    private void addComponents() {
        add(scorePanel);
    }

    private void setBackground() {
        background = multimedia.getMainBackground();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }
}
