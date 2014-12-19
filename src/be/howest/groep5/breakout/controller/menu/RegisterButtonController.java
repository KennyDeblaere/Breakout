package be.howest.groep5.breakout.controller.menu;


import be.howest.groep5.breakout.view.welcome.ContentPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class RegisterButtonController implements ActionListener {
    private ContentPanel c;
    public RegisterButtonController(ContentPanel panelContent) {
        c = panelContent;
    }


    @Override
        public void actionPerformed(ActionEvent e) {
            c.addRegistrationPanel();
        }
    }
