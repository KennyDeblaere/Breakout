package analyse_en_programmeerproject.groep5.breakout.controller.startbuttons;

import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kenny on 28/11/2014.
 */
public class SingleplayerController implements ActionListener {
    private PanelContent panelContent;

    public SingleplayerController(PanelContent pc){
        panelContent = pc;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        panelContent.addDifficultyPanel();
    }
}
