package be.howest.groep5.breakout.view;

import be.howest.groep5.breakout.view.welcome.MainPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class MainFrame extends JFrame {
    public MainFrame() {
        super();

        try {
            setIconImage(ImageIO.read(new File("src\\be\\howest\\groep5\\breakout\\multimedia\\Icon.jpg")));
        } catch (IOException e) {
            System.out.println("Image laad niet in!");
        }

        try {


        } catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

        setTitle("Breakout (c) 2014 groep 5");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MainPanel mainPanel = new MainPanel();
        setContentPane(mainPanel);


        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
