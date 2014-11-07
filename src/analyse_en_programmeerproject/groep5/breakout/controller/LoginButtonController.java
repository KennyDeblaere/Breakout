package analyse_en_programmeerproject.groep5.breakout.controller;

import analyse_en_programmeerproject.groep5.breakout.view.CenterPanel;
import analyse_en_programmeerproject.groep5.breakout.view.WelcomePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kenny on 7/11/2014.
 */
public class LoginButtonController implements ActionListener {

    private CenterPanel welcomePanel;

    public LoginButtonController(CenterPanel panel){
        welcomePanel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        welcomePanel.setVisible(false);

    }
}
