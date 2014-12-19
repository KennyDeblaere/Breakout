package be.howest.groep5.breakout.view.welcome;

import be.howest.groep5.breakout.model.multimedia.Multimedia;

import javax.swing.*;
import javax.swing.text.StyledEditorKit;
import java.awt.*;

/**
 * Created by Dries Dekoninck on 2/12/2014.
 */
public class AboutPanel extends JPanel{
    private JPanel about;
    private JLabel titelLabel, createLabel, licensedtoLabel, versionLabel;
    private ImagePanel imagePanel;

    public AboutPanel(){
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));


        createComponents();
        setComponents();
        addComponents();
    }
    private void createComponents() {
        setPreferredSize(new Dimension(650,750));
        about = new JPanel(new GridLayout(3,1));
        titelLabel = new JLabel("Over ons");
        createLabel = new JLabel();
        licensedtoLabel = new JLabel();
        versionLabel = new JLabel();
        imagePanel = new ImagePanel("Icon.png");

    }

    private void setComponents(){
        setOpaque(false);
        about.setOpaque(false);
        titelLabel.setFont(new Font(null, Font.BOLD, 30));
        titelLabel.setForeground(Color.white);
        createLabel.setText("Created by: \n   Deblaere Kenny - CCCP | Dekoninck Dries - CCCP | Vansteelandt Benjamin - SSD");
        createLabel.setForeground(Color.white);
        licensedtoLabel.setText("Licensed to: \n   " + System.getProperty("user.name"));
        licensedtoLabel.setForeground(Color.white);
        versionLabel.setText("Version: \n   1.6.4");
        versionLabel.setForeground(Color.white);
        imagePanel.setPreferredSize(new Dimension(200,200));
        about.add(createLabel);
        about.add(licensedtoLabel);
        about.add(versionLabel);
    }

    private void addComponents() {
        add(titelLabel);
        add(about);
        add(imagePanel);
    }
}
