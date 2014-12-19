package be.howest.groep5.breakout.controller.highscores;

import be.howest.groep5.breakout.view.welcome.CenterPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class CancelController implements ActionListener {
    private CenterPanel panelCenter;

    public CancelController(CenterPanel panelCenter){
        this.panelCenter = panelCenter;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        panelCenter.addMainComponents();
    }
}
