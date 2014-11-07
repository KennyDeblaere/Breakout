package analyse_en_programmeerproject.groep5.breakout.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kenny on 7/11/2014.
 */
public class WelcomePanel extends JPanel {

    public WelcomePanel(){
        setLayout(new GridLayout(1,2));
        add(new MenuCenterPanel());
        add(new DifficultyPanel());
    }
}
