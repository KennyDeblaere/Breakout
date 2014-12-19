package be.howest.groep5.breakout.view.highscores;

import javax.swing.*;
import java.awt.*;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class PanelHighScore extends JPanel{
    private JPanel singlePlayerHighscore, multiPlayerHighscore;
    private HighscorePanelCreator highscorePanelCreator;


    public PanelHighScore(){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setOpaque(false);
        addComponents();
        setPreferredSize(new Dimension(500, 575));
    }

    private void addComponents() {
        highscorePanelCreator = new HighscorePanelCreator();
        add(highscorePanelCreator.createHighscorePanel(true,5));
        add(highscorePanelCreator.createHighscorePanel(false,5));
    }
}
