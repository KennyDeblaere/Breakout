package analyse_en_programmeerproject.groep5.breakout.controller.menuTop;

import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class LogoutButtonController implements ActionListener {
    private PanelLogin menuTopPanel;

    public LogoutButtonController(PanelLogin m){
        menuTopPanel = m;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menuTopPanel.setLoggedIn(false);
        menuTopPanel.setComponents("");
    }
}
