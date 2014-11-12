package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import analyse_en_programmeerproject.groep5.breakout.view.game.GamePanel;
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
    private GamePanel game;

    public CenterPanel() {
        createComponents();
        //addMainComponents();
        addGamePanel();
    }

    public void createComponents() {
        welcomePanel = new WelcomePanel();
        registration = new RegistrationPanel(this);
        game = new GamePanel();
    }

    private void setComponents() {
    }

    public void addMainComponents() {
        remove(registration);
        remove(game);
        add(welcomePanel);
        revalidate();
        repaint();
    }

    public void addGamePanel(){
        remove(welcomePanel);
        remove(registration);
        add(game);
        revalidate();
        repaint();
    }

    public void addRegistrationPanel() {
        remove(welcomePanel);
        remove(game);
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
