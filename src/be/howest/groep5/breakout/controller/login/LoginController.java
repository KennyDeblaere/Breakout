package be.howest.groep5.breakout.controller.login;


import be.howest.groep5.breakout.view.welcome.PanelLogin;
import be.howest.groep5.breakout.data.Database;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class LoginController implements ActionListener {
    private String username, password;
    private PanelLogin menuTopPanel;

    public LoginController(PanelLogin topPanel){
        this.menuTopPanel = topPanel;
    }

    private int checkUsername(){
        int usernameIndex = -1;
        for(int i=0; i< Database.DatabaseInstance.fillUsers().size();i++)
            if(Database.DatabaseInstance.fillUsers().get(i).getUsername().toLowerCase().equals(username))
                usernameIndex = i;
        return usernameIndex;
    }

    private boolean login(){
        boolean canLogIn = false;
        password = "";
        for(int i=0; i< menuTopPanel.getLoginPanel().getPassword().getPassword().length;i++ )
            password += menuTopPanel.getLoginPanel().getPassword().getPassword()[i];
        if(checkUsername()>= 0)
            if(Database.DatabaseInstance.fillUsers().get(checkUsername()).getPassword().equals(password))
                canLogIn = true;
        return canLogIn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        username = menuTopPanel.getLoginPanel().getUsername().getText().toLowerCase();
        if(login()){
            menuTopPanel.setLoggedIn(true);
            menuTopPanel.addComponents();
            menuTopPanel.setComponents(Database.DatabaseInstance.fillUsers().get(checkUsername()).getFirstname());
            Database.DatabaseInstance.updateHostNameUserLogin(checkUsername());
            menuTopPanel.getLoginPanel().setUserId(checkUsername());
        } else {
            menuTopPanel.getLoginPanel().getErrorLabel().setVisible(true);
        }
    }
}
