package be.howest.groep5.breakout.view.game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 16/12/2014.
 */
public class ScorePanel extends JPanel{
    public ScorePanel(boolean singleplayer){
        super();

        setPreferredSize(new Dimension(250, 710));
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
        createComponents();
        addComponents();
    }

    private void addComponents() {

    }

    private void createComponents() {

    }
}
