package analyse_en_programmeerproject.groep5.breakout.controller;

import analyse_en_programmeerproject.groep5.breakout.view.registration.RegistrationPanel;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.CenterPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class RegisterButtonController implements ActionListener {
    private CenterPanel c;
    public RegisterButtonController(CenterPanel centerPanel) {
        c = centerPanel;
    }

    private void createRegisterPanel(){
        c.setVisible(false);
    }

    @Override
        public void actionPerformed(ActionEvent e) {
            createRegisterPanel();
        }
    }
