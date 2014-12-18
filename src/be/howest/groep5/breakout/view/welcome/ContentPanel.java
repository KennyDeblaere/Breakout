package be.howest.groep5.breakout.view.welcome;

import be.howest.groep5.breakout.view.highscores.PanelHighScore;
import be.howest.groep5.breakout.view.registration.RegistrationPanel;
import be.howest.groep5.breakout.view.settings.SettingPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Dries Dekoninck on 21/11/2014.
 */
public class ContentPanel extends JPanel {
    private CenterPanel panelCenter;
    private RegistrationPanel registrationPanel;
    private DifficultyPanel panelDifficulty;
    private HowToPlayPanel howToPlayPanel;
    private AboutPanel panelAbout;
    private PanelHighScore panelHighScore;
    private SettingPanel settingPanel;


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
        howToPlayPanel = new HowToPlayPanel();
        panelAbout = new AboutPanel();
        settingPanel = new SettingPanel();
        panelHighScore = new PanelHighScore();
    }

    public RegistrationPanel getRegistration() {
        return registrationPanel;
    }

    public void addRegistrationPanel(){
        removePanels();
        add(registrationPanel);
        re();
    }

    public void addDifficultyPanel(boolean singleplayer){
        removePanels();
        panelDifficulty = new DifficultyPanel(panelCenter,singleplayer);
        add(panelDifficulty);
        re();
    }

    public void addHighScorePanel(){
        removePanels();
        add(panelHighScore);
        re();
    }

    public void addHowToPlayPanel(){
        removePanels();
        add(howToPlayPanel);
        re();
    }

    public void addSettingPanel(){
        removePanels();
        add(settingPanel);
        re();
    }

    public void addAboutPanel(){
        removePanels();
        add(panelAbout);
        re();
    }

    public void addMainComponents() {
        removePanels();
        re();
    }

    private void re(){
        revalidate();
        repaint();
    }

    private void removePanels(){
        remove(registrationPanel);
        remove(panelDifficulty);
        remove(panelAbout);
        remove(panelHighScore);
        remove(howToPlayPanel);
        remove(settingPanel);
    }

}
