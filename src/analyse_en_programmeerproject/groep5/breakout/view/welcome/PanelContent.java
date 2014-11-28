package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import analyse_en_programmeerproject.groep5.breakout.view.registration.RegistrationPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class PanelContent extends JPanel {
    private PanelCenter panelCenter;
    private RegistrationPanel registrationPanel;
    private PanelDifficulty panelDifficulty;


    public PanelContent(PanelCenter c) {
        super();
        panelCenter = c;
        setPreferredSize(new Dimension(700, 600));
        createComponents();
        setComponents();
        addMainComponents();
    }

    private void createComponents() {
        registrationPanel = new RegistrationPanel(this);
        panelDifficulty = new PanelDifficulty(panelCenter);
    }

    private void setComponents() {


    }

    public void addRegistrationPanel(){
        remove(panelDifficulty);
        add(registrationPanel);
        revalidate();
        repaint();
    }

    public RegistrationPanel getRegistration() {
        return registrationPanel;
    }

    public void addDifficultyPanel(){
        remove(registrationPanel);
        add(panelDifficulty);
        revalidate();
        repaint();
    }

    public void addMainComponents() {
        remove(registrationPanel);
        remove(panelDifficulty);
        revalidate();
        repaint();
    }
}
