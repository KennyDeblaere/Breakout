package analyse_en_programmeerproject.groep5.breakout.view.welcome;
import analyse_en_programmeerproject.groep5.breakout.controller.menu.Login_outButtonController;
import analyse_en_programmeerproject.groep5.breakout.controller.menu.RegisterButtonController;
import analyse_en_programmeerproject.groep5.breakout.view.login.LoginPanel;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class PanelLogin extends JPanel{
    private JPanel LoginPanel;
    private ContentPanel panelContent;
    private Boolean loggedIn; //REMOVE WHEN USER-CLASS IS ADDED
    private JLabel textLabel;
    private JButton loginButton, logoutButton, registerButton;
    private LoginPanel loginPanel;

    public PanelLogin(ContentPanel c) {
        panelContent = c;
        setLoggedIn(false);
        setPreferredSize(new Dimension((int) getMaximumSize().getWidth(), 100));
        setLoggedIn(false);
        //setLayout(new FlowLayout(FlowLayout.RIGHT));
        createComponents();
        setComponents("");
        addComponents();
        addActionListeners();
    }

    private void createComponents() {
        LoginPanel = new JPanel();
        textLabel = new JLabel();
        loginButton = new JButton("Aanmelden");
        logoutButton = new JButton("Afmelden");
        registerButton = new JButton("Registreren");
        loginPanel = new LoginPanel(this);
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

    public void addComponents() {
        remove(loginPanel);
        add(textLabel);
        add(logoutButton);
        add(loginButton);
        add(registerButton);
        revalidate();
        repaint();
    }

    private void addActionListeners() {
        loginButton.addActionListener(new Login_outButtonController(this, true));
        registerButton.addActionListener(new RegisterButtonController(panelContent));
        logoutButton.addActionListener(new Login_outButtonController(this, false));
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
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

