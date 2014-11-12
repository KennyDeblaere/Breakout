package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import analyse_en_programmeerproject.groep5.breakout.view.registration.RegistrationPanel;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.DifficultyPanel;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.MenuCenterPanel;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.WelcomePanel;

import javax.swing.*;

/**
 * Created by
 *      Kenny Deblaere.
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */
public class CenterPanel extends JPanel {
    private WelcomePanel welcomePanel;
    private RegistrationPanel registration;

    public CenterPanel() {
        createComponents();
        addMainComponents();
    }

    public void createComponents() {
        welcomePanel = new WelcomePanel();
        registration = new RegistrationPanel(this);
    }

    private void setComponents() {
    }

    public void addMainComponents() {
        remove(registration);
        add(welcomePanel);
        revalidate();
        repaint();
    }

    public void addRegistrationPanel() {
        remove(welcomePanel);
        add(registration);
        revalidate();
        repaint();
    }

    public void removeComponents() {
        removeAll();
    }

    public RegistrationPanel getRegistration() {
        return registration;
    }
}
