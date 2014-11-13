package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import javax.swing.*;
import java.awt.*;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class WelcomePanel extends JPanel {

    public WelcomePanel(CenterPanel centerPanel){
        setLayout(new GridLayout(1,2));
        add(new MenuCenterPanel());
        add(new DifficultyPanel(centerPanel));
    }
}