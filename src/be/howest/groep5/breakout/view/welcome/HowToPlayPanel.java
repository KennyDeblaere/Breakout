package be.howest.groep5.breakout.view.welcome;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 16/12/2014.
 */
public class HowToPlayPanel extends JPanel{
    private JLabel titelLabel;
    public HowToPlayPanel(){
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createComponents();
        setComponents();
        addComponents();
    }

    private void createComponents() {
        titelLabel = new JLabel("How to play?");

    }

    private void setComponents(){
        titelLabel.setFont(new Font(null, Font.BOLD, 30));
    }

    private void addComponents() {
        add(titelLabel);
    }
}
