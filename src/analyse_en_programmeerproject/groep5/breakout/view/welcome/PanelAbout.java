package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Blackhat on 2/12/2014.
 */
public class PanelAbout extends JPanel{
    private JPanel about;
    private JLabel titelLabel, createLabel, licensedtoLabel, versionLabel;


    public PanelAbout(){
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        createComponents();
        setComponents();
        addComponents();
    }
    private void createComponents() {
        about = new JPanel(new GridLayout(10,1));
        titelLabel = new JLabel("About");
        createLabel = new JLabel();
        licensedtoLabel = new JLabel();
        versionLabel = new JLabel();

    }

    private void setComponents(){
        createLabel.setText(convertToMultiline("Created by: \n   Deblaere Kenny - CCCP | Dekoninck Dries - CCCP | Vansteelandt Benjamin - SSD"));
        licensedtoLabel.setText(convertToMultiline("Licensed to: \n   " + System.getProperty("user.name")));
        versionLabel.setText(convertToMultiline("Version: \n   1.6.4"));

        about.setPreferredSize(new Dimension(500, 400));
        about.add(titelLabel);
        about.add(createLabel);
        about.add(licensedtoLabel);
        about.add(versionLabel);
    }

    private String convertToMultiline(String orig) {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }

    private void addComponents() {
        add(about);
    }
}
