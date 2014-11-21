package analyse_en_programmeerproject.groep5.breakout.view.login;

import analyse_en_programmeerproject.groep5.breakout.controller.login.CancelController;
import analyse_en_programmeerproject.groep5.breakout.controller.login.LoginController;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelCenter;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelLogin;

import javax.swing.*;

/**
 * Created by Kenny on 13/11/2014.
 */
public class LoginPanel extends JPanel {
    private JTextField username;
    private JPasswordField password;
    private JLabel usernameLabel, passwordLabel, errorLabel;
    private JButton login, cancel;

    private PanelCenter centerPanel;
    private PanelLogin menuTopPanel;

    public JTextField getUsername() {
        return username;
    }
    public JPasswordField getPassword() {
        return password;
    }
    public JLabel getErrorLabel() {
        return errorLabel;
    }

    public LoginPanel(PanelLogin topPanel){
        menuTopPanel = topPanel;
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
        cancel.addActionListener(new CancelController(menuTopPanel));
        login.addActionListener(new LoginController(menuTopPanel));
    }
}
