package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import javax.swing.*;
import javax.xml.crypto.Data;
import java.awt.*;
import analyse_en_programmeerproject.groep5.breakout.data.Database;

/**
 * Created by Blackhat on 3/12/2014.
 */
public class PanelHighScore extends JPanel{
    private JPanel HighScorePanel;
    private JLabel titleLabel, ranking, nameLabel, high_Score, XP;
    private Database database;


    public PanelHighScore(){
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createComponents();
        setComponents();
        addComponents();
    }
    private void createComponents() {
        HighScorePanel = new JPanel(new GridLayout(11,4));
        titleLabel = new JLabel("High Score");
        ranking = new JLabel("Ranking");
        nameLabel = new JLabel("Name");
        high_Score = new JLabel("High Score");
        XP = new JLabel("XP");

    }

    private void setComponents(){
        HighScorePanel.setPreferredSize(new Dimension(500,600));
        HighScorePanel.add(ranking);
        HighScorePanel.add(nameLabel);
        HighScorePanel.add(high_Score);
        HighScorePanel.add(XP);
    }

    private void addComponents() {
        add(titleLabel);
        add(HighScorePanel);

    }
}
