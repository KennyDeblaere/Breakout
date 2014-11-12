package analyse_en_programmeerproject.groep5.breakout.controller.menuTop;

import analyse_en_programmeerproject.groep5.breakout.view.welcome.CenterPanel;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.MenuTopPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class LoginButtonController implements ActionListener {
    private MenuTopPanel menuTopPanel;

    public LoginButtonController(MenuTopPanel menuTopPanel) {
        this.menuTopPanel = menuTopPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        menuTopPanel.setLoggedIn(true);
        menuTopPanel.setComponents("<< username>>");
    }
}
