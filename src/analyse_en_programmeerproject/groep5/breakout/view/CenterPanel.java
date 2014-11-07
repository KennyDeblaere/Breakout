package analyse_en_programmeerproject.groep5.breakout.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Benjamin on 6/11/2014.
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
        add(menuPanel);
        add(difficultyPanel);
    }

    public void addRegistrationPanel() {
        add(registration);
    }

    public void removeComponents() {
        removeAll();
    }
}
