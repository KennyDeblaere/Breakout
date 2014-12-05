package analyse_en_programmeerproject.groep5.breakout.controller.startbuttons;

import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelContent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Blackhat on 3/12/2014.
 */
public class ButtonController implements ActionListener{

    private PanelContent panelContent;
    private String button;

    public ButtonController(PanelContent panelContent, String button){
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