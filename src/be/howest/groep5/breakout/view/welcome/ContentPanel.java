package be.howest.groep5.breakout.view.welcome;

import be.howest.groep5.breakout.view.highscores.PanelHighScore;
import be.howest.groep5.breakout.view.registration.RegistrationPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */

public class ContentPanel extends JPanel {
    private CenterPanel panelCenter;
    private RegistrationPanel registrationPanel;
    private DifficultyPanel panelDifficulty;
    private HowToPlayPanel howToPlayPanel;
    private AboutPanel panelAbout;
    private PanelHighScore panelHighScore;


    public ContentPanel(CenterPanel c) {
        super();
        panelCenter = c;
        setPreferredSize(new Dimension(700, 600));
        createComponents();
        addDifficultyPanel(true);
        setOpaque(false);
    }

    private void createComponents() {
        registrationPanel = new RegistrationPanel(this);
        panelDifficulty = new DifficultyPanel(panelCenter, true);
        howToPlayPanel = new HowToPlayPanel();
        panelAbout = new AboutPanel();
        panelHighScore = new PanelHighScore();
    }

    public RegistrationPanel getRegistration() {
        return registrationPanel;
    }

    public void addRegistrationPanel(){
        removePanels();
        add(registrationPanel);
        reDraw();
    }

    public void addDifficultyPanel(boolean singleplayer){
        removePanels();
        panelDifficulty = new DifficultyPanel(panelCenter,singleplayer);
        add(panelDifficulty);
        reDraw();
    }

    public void addHighScorePanel(){
        removePanels();
        add(panelHighScore);
        reDraw();
    }

    public void addHowToPlayPanel(){
        removePanels();
        add(howToPlayPanel);
        reDraw();
    }

    public void addAboutPanel(){
        removePanels();
        add(panelAbout);
        reDraw();
    }

    public void shutDown(){
        System.exit(0);
    }

    private void reDraw(){
        revalidate();
        repaint();
    }

    private void removePanels(){
        remove(registrationPanel);
        remove(panelDifficulty);
        remove(panelAbout);
        remove(panelHighScore);
        remove(howToPlayPanel);
    }

}
