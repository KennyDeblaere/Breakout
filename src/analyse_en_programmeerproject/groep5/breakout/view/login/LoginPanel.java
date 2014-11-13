package analyse_en_programmeerproject.groep5.breakout.view.login;

import analyse_en_programmeerproject.groep5.breakout.controller.login.CancelController;
import analyse_en_programmeerproject.groep5.breakout.controller.login.LoginController;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.CenterPanel;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.MenuTopPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Kenny on 13/11/2014.
 */
public class LoginPanel extends JPanel {
    private JTextField username;
    private JPasswordField password;
    private JLabel usernameLabel, passwordLabel, usernameErrorLabel, passwordErrorLabel;
    private JButton login, cancel;

    private CenterPanel centerPanel;
    private MenuTopPanel menuTopPanel;

    public JTextField getUsername() {
        return username;
    }
    public JPasswordField getPassword() {
        return password;
    }
    public JLabel getUsernameErrorLabel() {
        return usernameErrorLabel;
    }
    public JLabel getPasswordErrorLabel() {
        return passwordErrorLabel;
    }

    public LoginPanel(MenuTopPanel topPanel){
        this.centerPanel = centerPanel;
        menuTopPanel = topPanel;
        setLayout(new GridLayout(3,3,10,10));
        createComponents();
        addComponents();
        addListeners();
    }

    private void createComponents(){
        username = new JTextField(10);
        password = new JPasswordField();

        usernameLabel = new JLabel("Gebruikersnaam: ");
        passwordLabel = new JLabel("Wachtwoord: ");

        usernameErrorLabel = new JLabel("Controleer je gebruikersnaam");
        usernameErrorLabel.setVisible(false);

        passwordErrorLabel = new JLabel("Controleer je wachtwoord");
        passwordErrorLabel.setVisible(false);

        login = new JButton("Aanmelden");
        cancel = new JButton("Annuleren");
    }

    private void addComponents(){
        add(usernameLabel);
        add(username);
        add(usernameErrorLabel);
        add(passwordLabel);
        add(password);
        add(passwordErrorLabel);
        add(login);
        add(cancel);
    }

    private void addListeners(){
        cancel.addActionListener(new CancelController(menuTopPanel));
        login.addActionListener(new LoginController(menuTopPanel));
    }
}
