package be.howest.groep5.breakout.controller.startbuttons;

import be.howest.groep5.breakout.view.welcome.ContentPanel;
import be.howest.groep5.breakout.view.welcome.StatusPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Blackhat on 3/12/2014.
 */
public class ButtonController implements ActionListener{
    private ContentPanel panelContent;
    private String button;

    public ButtonController(ContentPanel panelContent, String button){
        this.panelContent = panelContent;
        this.button = button;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (button) {
            case "Single":  panelContent.addDifficultyPanel(true);
                break;
            case "CO":  panelContent.addDifficultyPanel(false);
                break;
            case "High":  panelContent.addHighScorePanel();
                break;
            case "About":  panelContent.addAboutPanel();
                break;
        }
    }
}
