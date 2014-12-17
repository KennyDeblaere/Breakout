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
    private List<ScoreUser> scores = new ArrayList<ScoreUser>();

    public JPanel createHighscorePanel(Boolean isSinglePlayer, int maxAmountOfRows) {
        toReturnPanel = new JPanel();
        toReturnPanel.setLayout(new GridLayout(maxAmountOfRows, 2));

        JLabel usernameLabel, scoreLabel;
        scores = Database.DatabaseInstance.fillTopScores(isSinglePlayer);

        if (scores.size() < 5) {
            for (int i = 0; i < (5-scores.size()); i++) {
                usernameLabel = new JLabel("Benjameister");
                toReturnPanel.add(usernameLabel);
                scoreLabel = new JLabel("0");
                toReturnPanel.add(scoreLabel);
            }
        }

        for(ScoreUser score : scores){
            usernameLabel = new JLabel(score.getUserName());
            toReturnPanel.add(usernameLabel);
            scoreLabel = new JLabel("" + score.getScore());
            toReturnPanel.add(scoreLabel);
        }

        return  toReturnPanel;
    }
}
