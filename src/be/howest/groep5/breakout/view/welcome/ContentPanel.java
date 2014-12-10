package be.howest.groep5.breakout.view.welcome;

import be.howest.groep5.breakout.view.highscores.PanelHighScore;
import be.howest.groep5.breakout.view.registration.RegistrationPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Blackhat on 21/11/2014.
 */
public class ContentPanel extends JPanel {
    private CenterPanel panelCenter;
    private RegistrationPanel registrationPanel;
    private DifficultyPanel panelDifficulty;
    private AboutPanel panelAbout;
    private PanelHighScore panelHighScore;


    public ContentPanel(CenterPanel c) {
        super();
        panelCenter = c;
        setPreferredSize(new Dimension(700, 600));
        createComponents();
        addMainComponents();
    }

    private void createComponents() {
        registrationPanel = new RegistrationPanel(this);
        panelDifficulty = new DifficultyPanel(panelCenter, true);
        panelAbout = new AboutPanel();
        panelHighScore = new PanelHighScore();
    }

    public RegistrationPanel getRegistration() {
        return registrationPanel;
    }

    public void addRegistrationPanel(){
        remove(panelDifficulty);
        add(registrationPanel);
        remove(panelAbout);
        remove(panelHighScore);
        revalidate();
        repaint();
    }

    public void addDifficultyPanel(boolean singleplayer){
        remove(panelDifficulty);
        panelDifficulty = new DifficultyPanel(panelCenter,singleplayer);
        remove(registrationPanel);
        remove(panelAbout);
        remove(panelHighScore);

        add(panelDifficulty);
        revalidate();
        repaint();
    }


    public void addHighScorePanel(){
        remove(registrationPanel);
        remove(panelDifficulty);
        remove(panelAbout);
        add(panelHighScore);
        revalidate();
        repaint();
    }

    public void addAboutPanel(){
        remove(registrationPanel);
        remove(panelDifficulty);
        remove(panelHighScore);
        add(panelAbout);
        revalidate();
        repaint();
    }

    public void addMainComponents() {
        remove(registrationPanel);
        remove(panelDifficulty);
        remove(panelAbout);
        remove(panelHighScore);
        revalidate();
        repaint();
    }
}
