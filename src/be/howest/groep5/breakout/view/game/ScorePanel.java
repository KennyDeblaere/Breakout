package be.howest.groep5.breakout.view.game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 16/12/2014.
 */
public class ScorePanel extends JPanel{
    private JPanel singlePanel, coopPanel, scorePanel;
    private JLabel titelLabel, titelsingle, titelcoop, scoresingle, scorecoop, score, pause, timer;
    private int seconds = 10;
    private Boolean singleplayer;
    public ScorePanel(boolean singleplayer){
        super();

        this.singleplayer = singleplayer;
        setPreferredSize(new Dimension(250, 710));
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
        createComponents();
        setComponents();
        addComponents();
    }

    private void createComponents() {
        titelLabel = new JLabel("Scoreboard");
        scorePanel = new JPanel(new GridLayout(5,1,0,10));
        singlePanel = new JPanel(new GridLayout(3,1,0,10));
        coopPanel = new JPanel(new GridLayout(3,1,0,10));
        titelsingle = new JLabel("Player 1");
        titelcoop = new JLabel("Player 2");
        scoresingle = new JLabel();
        scorecoop = new JLabel();
        score = new JLabel("Score:");
        pause = new JLabel("Press P for pause the game");
        timer = new JLabel("Power up/down for : " + seconds + "seconds");
    }

    private void setComponents(){
        titelLabel.setFont(new Font(null, Font.BOLD, 30));
        singlePanel.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        singlePanel.add(titelsingle);
        singlePanel.add(score);
        singlePanel.add(scoresingle);
        coopPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2, true));
        coopPanel.add(titelcoop);
        coopPanel.add(score);
        coopPanel.add(scorecoop);
        scorePanel.add(titelLabel);
        scorePanel.add(singlePanel);
        if (!singleplayer){
            scorePanel.add(coopPanel);
        }
        scorePanel.add(timer);
        scorePanel.add(pause);
    }

    private void addComponents() {
        add(scorePanel);
    }
}
