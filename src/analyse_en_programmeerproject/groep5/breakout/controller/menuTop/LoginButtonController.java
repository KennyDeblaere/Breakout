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
public class LoginButtonController implements ActionListener {
    private PanelLogin menuTopPanel;

    public LoginButtonController(PanelLogin topPanel) {
        this.menuTopPanel = topPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menuTopPanel.addLoginComponents();
    }
}
