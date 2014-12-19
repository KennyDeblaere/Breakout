package be.howest.groep5.breakout.view.login;

import be.howest.groep5.breakout.controller.login.CancelController;
import be.howest.groep5.breakout.controller.login.LoginController;
import be.howest.groep5.breakout.view.welcome.PanelLogin;

import javax.swing.*;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class LoginPanel extends JPanel {
    private JTextField username;
    private JPasswordField password;
    private JLabel usernameLabel, passwordLabel, errorLabel;
    private JButton login, cancel;
    private int userId;
    private PanelLogin panelLogin;

    public JTextField getUsername() {
        return username;
    }
    public JPasswordField getPassword() {
        return password;
    }
    public JLabel getErrorLabel() {
        return errorLabel;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LoginPanel(PanelLogin p){
        panelLogin = p;
        createComponents();
        addComponents();
        addListeners();
    }

    private void createComponents(){
        username = new JTextField(10);
        password = new JPasswordField(10);

        usernameLabel = new JLabel("Gebruikersnaam: ");
        passwordLabel = new JLabel("Wachtwoord: ");

        errorLabel = new JLabel("Controleer je gebruikersnaam/wachtwoord! ");
        errorLabel.setVisible(false);

        login = new JButton("Aanmelden");
        cancel = new JButton("Annuleren");
    }

    private void addComponents(){
        add(errorLabel);
        add(usernameLabel);
        add(username);
        add(passwordLabel);
        add(password);
        add(login);
        add(cancel);
    }

    private void addListeners(){
        cancel.addActionListener(new CancelController(panelLogin));
        login.addActionListener(new LoginController(panelLogin));
    }


}
