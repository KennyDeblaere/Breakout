package be.howest.groep5.breakout.view.highscores;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Benjamin Vansteelandt on 17/12/2014.
 */
public class PanelHighScore extends JPanel{
    private JLabel nameLabel, highScore;
    private JPanel singlePlayerHighscore, multiPlayerHighscore;
    private HighscorePanelCreator highscorePanelCreator;


    public PanelHighScore(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //createComponents();
        //addSinglePlayer();
        addComponents();
        setPreferredSize(new Dimension(500, 575));
;
    }

    private void addComponents() {
        highscorePanelCreator = new HighscorePanelCreator();

        add(new JLabel("Singleplayer"));
        add(highscorePanelCreator.createHighscorePanel(true,5));
        add(new JLabel("Multiplayer"));
        add(highscorePanelCreator.createHighscorePanel(false,5));
    }
}
