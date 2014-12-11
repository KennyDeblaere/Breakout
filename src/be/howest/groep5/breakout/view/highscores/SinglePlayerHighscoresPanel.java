package be.howest.groep5.breakout.view.highscores;

import be.howest.groep5.breakout.data.Database;
import be.howest.groep5.breakout.model.ScoreUser;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kenny on 11/12/2014.
 */
public class SinglePlayerHighscoresPanel extends JPanel {
    public SinglePlayerHighscoresPanel(){
        super();
        setLayout(new GridLayout(6,2,5,5));
        add(new JLabel("Gebruikersnaam 1"));
        add(new JLabel("Highscore"));

        fillPanel();

    }
    private void fillPanel(){
        JLabel username, score;
        for(ScoreUser su : Database.DatabaseInstance.fillTopScores(true)){
            username = new JLabel(su.getUserName());
            add(username);
            score = new JLabel("" + su.getScore());
            add(score);
        }
    }
}
