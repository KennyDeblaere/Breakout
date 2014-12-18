package be.howest.groep5.breakout.controller.registration;

//import CenterPanel;
import be.howest.groep5.breakout.view.welcome.ContentPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class CancelController implements ActionListener {
    private ContentPanel c;
    public  CancelController(ContentPanel centerPanel){
        c = centerPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        c.addDifficultyPanel(true);
    }
}
