package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import analyse_en_programmeerproject.groep5.breakout.view.registration.RegistrationPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class PanelContent extends JPanel {
    private RegistrationPanel registrationPanel;

    public PanelContent() {
        super();
        setPreferredSize(new Dimension(700, 600));
        createComponents();
        setComponents();
        addMainComponents();
    }

    private void createComponents() {
        registrationPanel = new RegistrationPanel(this);
    }

    private void setComponents() {


    }

    public void addRegistrationPanel(){
        add(registrationPanel);
        revalidate();
        repaint();
    }

    public RegistrationPanel getRegistration() {
        return registrationPanel;
    }

    public void addMainComponents() {
        remove(registrationPanel);
        revalidate();
        repaint();
    }
}
