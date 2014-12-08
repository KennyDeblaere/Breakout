package analyse_en_programmeerproject.groep5.breakout.controller.login;


import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static analyse_en_programmeerproject.groep5.breakout.data.Database.DatabaseInstance;

/**
 * Created by Kenny on 13/11/2014.
 */
public class LoginController implements ActionListener {
    private String username, password;
    private PanelLogin menuTopPanel;

    public LoginController(PanelLogin topPanel){
        this.menuTopPanel = topPanel;
    }

    private int checkUsername(){
        int usernameIndex = -1;
        for(int i=0; i< DatabaseInstance.fillUsers().size();i++)
            if(DatabaseInstance.fillUsers().get(i).getUsername().toLowerCase().equals(username))
                usernameIndex = i;
        return usernameIndex;
    }

    private boolean login(){
        boolean canLogIn = false;
        password = "";
        for(int i=0; i< menuTopPanel.getLoginPanel().getPassword().getPassword().length;i++ )
            password += menuTopPanel.getLoginPanel().getPassword().getPassword()[i];
        if(checkUsername()>= 0)
            if(DatabaseInstance.fillUsers().get(checkUsername()).getPassword().equals(password))
                canLogIn = true;
        return canLogIn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        username = menuTopPanel.getLoginPanel().getUsername().getText().toLowerCase();
        if(login()){
            menuTopPanel.setLoggedIn(true);
            menuTopPanel.addComponents();
            menuTopPanel.setComponents(DatabaseInstance.fillUsers().get(checkUsername()).getFirstname());
            DatabaseInstance.updateHostNameUserLogin(checkUsername());
            menuTopPanel.getLoginPanel().setUserId(checkUsername());
        } else {
            menuTopPanel.getLoginPanel().getErrorLabel().setVisible(true);
        }
    }
}
