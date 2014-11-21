package analyse_en_programmeerproject.groep5.breakout.view.welcome;
import analyse_en_programmeerproject.groep5.breakout.controller.menuTop.LoginButtonController;
import analyse_en_programmeerproject.groep5.breakout.controller.menuTop.LogoutButtonController;
import analyse_en_programmeerproject.groep5.breakout.controller.menuTop.RegisterButtonController;
import analyse_en_programmeerproject.groep5.breakout.view.login.LoginPanel;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class PanelLogin extends JPanel{
    private JPanel LoginPanel;
    private PanelCenter panelCenter;
    private Boolean loggedIn; //REMOVE WHEN USER-CLASS IS ADDED
    private JLabel textLabel;
    private JButton loginButton, logoutButton, registerButton;
    private LoginPanel loginPanel;

    public PanelLogin() {
        setLoggedIn(false);
        setPreferredSize(new Dimension((int)getMaximumSize().getWidth(), 100));
        setLoggedIn(false);
        this.panelCenter = panelCenter;
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        createComponents();
        setComponents("");
        addActionListeners();
        addComponents();
    }

    private void createComponents() {
        LoginPanel = new JPanel();
        textLabel = new JLabel();
        loginButton = new JButton("Aanmelden");
        logoutButton = new JButton("Afmelden");
        registerButton = new JButton("Registreren");
        loginPanel = new LoginPanel(this);


    }

    private void addActionListeners() {
        loginButton.addActionListener(new LoginButtonController(this));
        registerButton.addActionListener(new RegisterButtonController(panelCenter));
        logoutButton.addActionListener(new LogoutButtonController(this));
    }


    public void setComponents(String username) {
        if (loggedIn) {
            textLabel.setText("Welkom, " + username);
        } else {
            textLabel.setText("Je speelt nu als gast");
        }
        loginButton.setVisible(!loggedIn);
        registerButton.setVisible(!loggedIn);
        logoutButton.setVisible(loggedIn);
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public void addComponents() {
        add(LoginPanel);
        remove(loginPanel);
        add(textLabel);
        add(logoutButton);
        add(loginButton);
        add(registerButton);
        revalidate();
        repaint();
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }

    public void addLoginComponents(){
        remove(textLabel);
        remove(loginButton);
        remove(logoutButton);
        remove(registerButton);
        add(loginPanel);
        revalidate();
        repaint();
    }
}

