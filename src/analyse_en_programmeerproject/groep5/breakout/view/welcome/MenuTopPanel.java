package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import analyse_en_programmeerproject.groep5.breakout.controller.LoginButtonController;
import analyse_en_programmeerproject.groep5.breakout.controller.RegisterButtonController;
import analyse_en_programmeerproject.groep5.breakout.controller.RegisterController;

import javax.swing.*;
import java.awt.*;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class MenuTopPanel extends JPanel {
    private Boolean isLoggedin = false; //REMOVE WHEN USER-CLASS IS ADDED
    private JLabel textLabel;
    private JButton loginButton, logoutButton, registerButton;
    private CenterPanel centerPanel;

    public MenuTopPanel(CenterPanel centerPanel) {
        this.centerPanel = centerPanel;
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        createComponents();
        setComponents();
        addActionListeners();
        addComponents();
    }

    private void createComponents() {
        textLabel = new JLabel();
        loginButton = new JButton("Aanmelden");
        logoutButton = new JButton("Afmelden");
        registerButton = new JButton("Registreren");


    }

    private void addActionListeners() {
        loginButton.addActionListener(new LoginButtonController(centerPanel));
        registerButton.addActionListener(new RegisterButtonController());
    }

    private void setComponents() {
        if (isLoggedin) {
            textLabel.setText("Welkom << username >>");
        } else {
            textLabel.setText("Je speelt nu als gast");
        }
    }

    private void addComponents() {
        add(textLabel);
        if (isLoggedin) {
            add(logoutButton);
        } else {
            add(loginButton);
            add(registerButton);
        }
    }
}
