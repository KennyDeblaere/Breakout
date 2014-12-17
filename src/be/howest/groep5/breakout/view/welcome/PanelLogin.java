package be.howest.groep5.breakout.view.welcome;
import be.howest.groep5.breakout.controller.menu.loginOutButtonController;
import be.howest.groep5.breakout.controller.menu.RegisterButtonController;
import be.howest.groep5.breakout.view.login.LoginPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Dries Dekoninck on 21/11/2014.
 */
public class PanelLogin extends JPanel{
    private ContentPanel panelContent;
    private Boolean loggedIn; //REMOVE WHEN USER-CLASS IS ADDED
    private JLabel textLabel;
    private JButton loginButton, logoutButton, registerButton;
    private LoginPanel loginPanel;
    private Font font;

    public PanelLogin(ContentPanel c) {
        panelContent = c;
        setLoggedIn(false);
        setPreferredSize(new Dimension((int) getMaximumSize().getWidth(), 100));
        setLoggedIn(false);
        createComponents();
        setComponents("");
        addComponents();
        addActionListeners();
    }

    private void createComponents() {
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

        textLabel.setForeground(Color.white);
        font = new Font("Tahoma", Font.BOLD, 15);
        textLabel.setFont(font);
        loginButton.setVisible(!loggedIn);
        registerButton.setVisible(!loggedIn);
        registerButton.setFocusable(false);
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
        loginButton.addActionListener(new loginOutButtonController(this, true));
        registerButton.addActionListener(new RegisterButtonController(panelContent));
        logoutButton.addActionListener(new loginOutButtonController(this, false));
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

