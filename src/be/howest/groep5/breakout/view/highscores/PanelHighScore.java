package be.howest.groep5.breakout.view.highscores;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dries Dekoninck on 3/12/2014.
 */
public class PanelHighScore extends JPanel{
    private JLabel nameLabel, highScore;
    private JPanel singlePlayerHighscore, multiPlayerHighscore;


    public PanelHighScore(){
        //super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        createComponents();
        addSinglePlayer();

        setPreferredSize(new Dimension(500, 575));
;
    }
    private void createComponents(){
        singlePlayerHighscore = new SinglePlayerHighscoresPanel();
        multiPlayerHighscore = new MultiPlayerHighscoresPanel();
    }

    private void addSinglePlayer(){
        add(new JLabel("Singleplayer"));
        add(singlePlayerHighscore);
        add(new JLabel("Multiplayer"));
        add(multiPlayerHighscore);
        revalidate();
        repaint();
    }

    private void addMultiPlayer(){
        remove(singlePlayerHighscore);
        add(multiPlayerHighscore);
        revalidate();
        repaint();
    }

}
