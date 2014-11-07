package analyse_en_programmeerproject.groep5.breakout.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Benjamin on 6/11/2014.
 */

public class MenuTopPanel extends JPanel {
    private Boolean isLoggedin = false; //REMOVE WHEN USER-CLASS IS ADDED
    private JLabel textLabel;
    private JButton loginButton, logoutButton, registerButton;

    public MenuTopPanel() {
        setLayout(new FlowLayout(FlowLayout.RIGHT));
        createComponents();
        setComponents();
        addComponents();
    }

    private void createComponents() {
        textLabel = new JLabel();
        loginButton = new JButton("Aanmelden");
        logoutButton = new JButton("Afmelden");
        registerButton = new JButton("Registreren");
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
