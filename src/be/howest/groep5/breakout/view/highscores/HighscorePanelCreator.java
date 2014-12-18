package be.howest.groep5.breakout.view.highscores;

import be.howest.groep5.breakout.data.Database;
import be.howest.groep5.breakout.model.ScoreUser;

import javax.swing.*;
//import java.awt.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Benjamin on 17/12/2014.
 */

/**
 * Moet niet aangepast worden voor uitbreiding naar veranderende panels
 */

public class HighscorePanelCreator {
    private JPanel toReturnPanel;
    private boolean singlePlayer;

    public JPanel createHighscorePanel(Boolean isSinglePlayer, int maxAmountOfRows) {
        toReturnPanel = new JPanel();
        toReturnPanel.setLayout(new GridLayout(maxAmountOfRows, 2));
        this.singlePlayer = isSinglePlayer;
        JLabel usernameLabel, scoreLabel;

        if (Database.DatabaseInstance.fillTopScores(singlePlayer).size() > 0 && Database.DatabaseInstance.fillTopScores(singlePlayer).size() < 5) {
            for (int i = 0; i < (5-Database.DatabaseInstance.fillTopScores(singlePlayer).size()); i++) {
                usernameLabel = new JLabel(Database.DatabaseInstance.fillTopScores(singlePlayer).get(i).getUserName());
                toReturnPanel.add(usernameLabel);
                scoreLabel = new JLabel(""+Database.DatabaseInstance.fillTopScores(singlePlayer).get(i).getScore());
                toReturnPanel.add(scoreLabel);
            }
        }

        for(ScoreUser score : Database.DatabaseInstance.fillTopScores(singlePlayer)){
            usernameLabel = new JLabel(score.getUserName());
            toReturnPanel.add(usernameLabel);
            scoreLabel = new JLabel("" + score.getScore());
            toReturnPanel.add(scoreLabel);
        }

        return  toReturnPanel;
    }
}
