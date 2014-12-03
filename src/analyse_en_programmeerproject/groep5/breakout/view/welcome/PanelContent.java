package analyse_en_programmeerproject.groep5.breakout.view.welcome;

import analyse_en_programmeerproject.groep5.breakout.view.registration.RegistrationPanel;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelAbout;
import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class PanelContent extends JPanel {
    private PanelCenter panelCenter;
    private RegistrationPanel registrationPanel;
    private PanelDifficulty panelDifficulty;
    private PanelAbout panelAbout;


    public PanelContent(PanelCenter c) {
        super();
        panelCenter = c;
        setPreferredSize(new Dimension(700, 600));
        createComponents();
        addMainComponents();
    }

    private void createComponents() {
        registrationPanel = new RegistrationPanel(this);
        panelDifficulty = new PanelDifficulty(panelCenter);
        panelAbout = new PanelAbout(panelCenter);
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

    public void addDifficultyPanel(boolean singleplayer){
        remove(registrationPanel);
        remove(panelAbout);
        add(panelDifficulty);
        panelDifficulty.setSingleplayer(singleplayer);
        System.out.println(panelDifficulty.isSingleplayer());
        revalidate();
        repaint();
    }

    public void addAboutPanel(){
        remove(registrationPanel);
        remove(panelDifficulty);
        add(panelAbout);
        revalidate();
        repaint();
    }

    public void addMainComponents() {
        remove(registrationPanel);
        remove(panelDifficulty);
        remove(panelAbout);
        revalidate();
        repaint();
    }
}
