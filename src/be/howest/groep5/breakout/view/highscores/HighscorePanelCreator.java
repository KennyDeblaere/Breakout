package be.howest.groep5.breakout.view.highscores;

import be.howest.groep5.breakout.data.Database;
import be.howest.groep5.breakout.model.ScoreUser;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.*;

/**
 * Created by Benjamin on 17/12/2014.
 */

/**
 * Moet niet aangepast worden voor uitbreiding naar veranderende panels
 */

public class HighscorePanelCreator {
    private JPanel toReturnPanel;
    private JLabel usernameLabel, scoreLabel;
    private boolean singlePlayer;
    private int maxAmountOfRows;
    private java.util.List<ScoreUser> scores;

    public JPanel createHighscorePanel(Boolean isSinglePlayer, int maxAmountOfRows) {
        this.singlePlayer = isSinglePlayer;
        this.maxAmountOfRows = maxAmountOfRows;

        scores = new ArrayList<ScoreUser>();

        createComponents();
        fillHighScore();
        toReturnPanel.setOpaque(false);

        return  toReturnPanel;
    }

    private void createComponents(){
        String name;
        if (singlePlayer){
            name = "Singleplayer";
        }else{
            name = "Co-op";
        }
        toReturnPanel = new JPanel();
        toReturnPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white, 2, true), name,0,0,null,Color.white));
        toReturnPanel.setLayout(new GridLayout(maxAmountOfRows, 2));
    }

    private void fillHighScore(){
        scores = Database.DatabaseInstance.fillTopScores(singlePlayer);
        System.out.println("got here");
        System.out.println(scores);

       for(ScoreUser score : scores){
           usernameLabel = new JLabel(score.getUserName());
           usernameLabel.setForeground(Color.white);
           toReturnPanel.add(usernameLabel);
           scoreLabel = new JLabel("" + score.getScore());
           scoreLabel.setForeground(Color.white);
           toReturnPanel.add(scoreLabel);
        }
           //Dummy creator:
         if (scores.size() > 0 && scores.size() < 5) {
            for (int i = 0; i < (5-scores.size()); i++) {
                usernameLabel = new JLabel("-");
                toReturnPanel.add(usernameLabel);
                scoreLabel = new JLabel("-");
                toReturnPanel.add(scoreLabel);
            }
        }
    }
}
