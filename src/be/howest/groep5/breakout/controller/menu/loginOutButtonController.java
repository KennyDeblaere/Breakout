package be.howest.groep5.breakout.controller.menu;

import be.howest.groep5.breakout.data.Database;
import be.howest.groep5.breakout.view.welcome.PanelLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class loginOutButtonController implements ActionListener {
    private PanelLogin panelLogin;
    private boolean login;

    public loginOutButtonController(PanelLogin panelLogin, boolean login) {
        this.panelLogin = panelLogin;
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (login == true) {
            panelLogin.addLoginComponents();
        }else{
            panelLogin.setLoggedIn(false);
            Database.DatabaseInstance.updateHostNameUserLogout(panelLogin.getLoginPanel().getUserId());
            panelLogin.setComponents("");
        }
    }
}
