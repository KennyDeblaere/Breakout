package be.howest.groep5.breakout.view.welcome;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 2/12/2014.
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
        about = new JPanel(new GridLayout(3,1));
        titelLabel = new JLabel("About");
        createLabel = new JLabel();
        licensedtoLabel = new JLabel();
        versionLabel = new JLabel();
        imagePanel = new ImagePanel();

    }

    private void setComponents(){
        createLabel.setText(convertToMultiline("Created by: \n   Deblaere Kenny - CCCP | Dekoninck Dries - CCCP | Vansteelandt Benjamin - SSD"));
        licensedtoLabel.setText(convertToMultiline("Licensed to: \n   " + System.getProperty("user.name")));
        versionLabel.setText(convertToMultiline("Version: \n   1.6.4"));
        imagePanel.setPreferredSize(new Dimension(200,200));
        about.setPreferredSize(new Dimension(500, 250));
        about.add(createLabel);
        about.add(licensedtoLabel);
        about.add(versionLabel);

    }

    private void addComponents() {
        add(titelLabel);
        add(about);
        add(imagePanel);
    }

    private String convertToMultiline(String orig) {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }
}
