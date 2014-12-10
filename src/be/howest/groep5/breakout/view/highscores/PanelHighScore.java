package be.howest.groep5.breakout.view.highscores;

import javax.swing.*;
import java.awt.*;
import be.howest.groep5.breakout.data.Database;
import be.howest.groep5.breakout.model.ScoreUser;

/**
 * Created by Blackhat on 3/12/2014.
 */
public class PanelHighScore extends JPanel{
    private JLabel nameLabel, highScore;


    public PanelHighScore(){
        //super();
        setLayout(new GridLayout(6,2,5,5));

        setPreferredSize(new Dimension(500, 575));

        createComponents();
        addComponents();
        fillPanel();
    }
    private void createComponents() {

        nameLabel = new JLabel("Name");
        highScore = new JLabel("High Score");
    }


    private void addComponents() {
        add(nameLabel);
        add(highScore);
    }
    private void fillPanel(){
        JLabel username, score;
        for(ScoreUser su :Database.DatabaseInstance.fillTopScores(true)){
            username = new JLabel(su.getUserName());
            add(username);
            score = new JLabel("" + su.getScore());
            add(score);
        }
    }
}
