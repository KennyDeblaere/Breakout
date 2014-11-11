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
    private MenuCenterPanel menuPanel;
    private DifficultyPanel difficultyPanel;
    private RegistrationPanel registration;

    public CenterPanel() {
        createComponents();
        addMainComponents();
    }

    private void createComponents() {
        menuPanel = new MenuCenterPanel();
        difficultyPanel = new DifficultyPanel();
        registration = new RegistrationPanel();
    }

    private void setComponents() {
    }

    public void addMainComponents() {
        add(new WelcomePanel());
    }

    public void addRegistrationPanel() {
        add(registration);
    }

    public void removeComponents() {
        removeAll();
    }
}
