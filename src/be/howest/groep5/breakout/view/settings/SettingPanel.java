package be.howest.groep5.breakout.view.settings;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 18/12/2014.
 */
public class SettingPanel extends JPanel {
    private JLabel titelLabel;
    private JComboBox soundList;
    private String[] soundStrings = {"Sound 1", "Sound 2", "Sound 3", "Sound 4", "Sound 5", "Sound 6", "Sound 7", "Sound 8", "Sound 9" };

    public SettingPanel(){
        super();
        //setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createComponents();
        setComponents();
        addComponents();
    }

    private void createComponents() {
        titelLabel = new JLabel("Instellingen");
    }

    private void setComponents() {
        titelLabel.setFont(new Font(null, Font.BOLD, 30));
    }

    private void addComponents() {
        add(titelLabel);
    }
}
