package analyse_en_programmeerproject.groep5.breakout.view.highscores;

import javax.swing.*;
import java.awt.*;
import analyse_en_programmeerproject.groep5.breakout.data.Database;
import analyse_en_programmeerproject.groep5.breakout.model.ScoreUser;

/**
 * Created by Blackhat on 3/12/2014.
 */
public class PanelHighScore extends JPanel{
    private JLabel titleLabel, ranking, nameLabel, high_Score, XP;


    public PanelHighScore(){
        super();
        setLayout(new GridLayout(6,2,5,5));

        createComponents();
        setComponents();
        addComponents();
        fillPanel();
    }
    private void createComponents() {

        titleLabel = new JLabel("High Score");
        ranking = new JLabel("Ranking");
        nameLabel = new JLabel("Name");
        high_Score = new JLabel("High Score");
        XP = new JLabel("XP");
    }

    private void setComponents(){
        setPreferredSize(new Dimension(500, 575));

    }

    private void addComponents() {
        add(nameLabel);
        add(high_Score);
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
