package analyse_en_programmeerproject.groep5.breakout.controller.startbuttons;

import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelContent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kenny on 28/11/2014.
 */
public class PlayermodeController implements ActionListener {
    private PanelContent panelContent;
    private boolean singleplayer;

    public PlayermodeController(PanelContent pc, boolean single){
        panelContent = pc;
        singleplayer = single;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        panelContent.addDifficultyPanel(singleplayer);
    }
}
