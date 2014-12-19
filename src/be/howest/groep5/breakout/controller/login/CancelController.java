package be.howest.groep5.breakout.controller.login;

import be.howest.groep5.breakout.view.welcome.PanelLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class CancelController implements ActionListener {
    private PanelLogin topPanel;

    public CancelController(PanelLogin topPanel){
        this.topPanel = topPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        topPanel.addComponents();
    }
}
