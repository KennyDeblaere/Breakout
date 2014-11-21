package analyse_en_programmeerproject.groep5.breakout.view;

import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelMain;

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
            setIconImage(ImageIO.read(new File("src\\analyse_en_programmeerproject\\groep5\\breakout\\Pictures\\Icon.jpg")));
        } catch (IOException e) {

        }

        setTitle("Breakout (c) 2014 groep 5");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        PanelMain mainPanel = new PanelMain();
        setContentPane(mainPanel);


        pack();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}
