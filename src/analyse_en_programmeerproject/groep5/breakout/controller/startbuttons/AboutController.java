package analyse_en_programmeerproject.groep5.breakout.controller.startbuttons;

import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelCenter;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelContent;
import javafx.scene.layout.Pane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Blackhat on 3/12/2014.
 */
public class AboutController implements ActionListener{

    private PanelContent panelContent;

    public AboutController(PanelContent panelContent){
        this.panelContent = panelContent;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        panelContent.addAboutPanel();
    }
}
