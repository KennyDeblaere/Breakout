package be.howest.groep5.breakout.view.game;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 16/12/2014.
 */
public class ScorePanel extends JPanel{
    private JLabel titelLabel;
    private Boolean singleplayer;
    public ScorePanel(boolean singleplayer){
        super();

        this.singleplayer = singleplayer;
        setPreferredSize(new Dimension(250, 710));
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.BLACK,3,true));
        createComponents();
        setComponents();
        addComponents();
    }

    private void createComponents() {
        titelLabel = new JLabel("Scoreboard");

    }

    private void setComponents(){
        titelLabel.setFont(new Font(null, Font.BOLD, 30));
    }

    private void addComponents() {
        add(titelLabel);
    }
}
