package be.howest.groep5.breakout.view.highscores;

import be.howest.groep5.breakout.data.Database;
import be.howest.groep5.breakout.model.ScoreUser;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

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

    public JPanel createHighscorePanel(Boolean isSinglePlayer, int maxAmountOfRows) {
        this.singlePlayer = isSinglePlayer;
        this.maxAmountOfRows = maxAmountOfRows;
        createComponents();
        fillHighScore();

        return  toReturnPanel;
    }

    private void createComponents(){
        String name;
        if (singlePlayer){
            name = "Singleplayer";
        }else{
            name = "Multiplayer";
        }
        toReturnPanel = new JPanel();
        toReturnPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2, true), name));
        toReturnPanel.setLayout(new GridLayout(maxAmountOfRows, 2));
    }

    private void fillHighScore(){
        if (Database.DatabaseInstance.fillTopScores(singlePlayer).size() > 0 && Database.DatabaseInstance.fillTopScores(singlePlayer).size() < 5) {
            for (int i = 0; i < (Database.DatabaseInstance.fillTopScores(singlePlayer).size()); i++) {
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
    }
}
