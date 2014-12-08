package analyse_en_programmeerproject.groep5.breakout.controller.menu;

import analyse_en_programmeerproject.groep5.breakout.data.Database;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class Login_outButtonController implements ActionListener {
    private PanelLogin menuTopPanel;
    private boolean login;

    public Login_outButtonController(PanelLogin topPanel, boolean login) {
        this.menuTopPanel = topPanel;
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (login == true) {
            menuTopPanel.addLoginComponents();
        }else{
            menuTopPanel.setLoggedIn(false);
            Database.DatabaseInstance.updateHostNameUserLogout(menuTopPanel.getLoginPanel().getUserId());
            menuTopPanel.setComponents("");
        }
    }
}
