package be.howest.groep5.breakout.controller.startbuttons;

import be.howest.groep5.breakout.view.welcome.ContentPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Dries Dekoninck on 3/12/2014.
 */
public class ButtonController implements ActionListener{
    private ContentPanel contentPanel;
    private String button;

    public ButtonController(ContentPanel panelContent, String button){
        this.contentPanel = panelContent;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (button) {
            case "Single":  contentPanel.addDifficultyPanel(true);
                break;
            case "CO":  contentPanel.addDifficultyPanel(false);
                break;
            case "High":  contentPanel.addHighScorePanel();
                break;
            case "Howto":  contentPanel.addHowToPlayPanel();
                break;
            case "About":  contentPanel.addAboutPanel();
                break;
        }
    }
}
