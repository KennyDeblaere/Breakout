package analyse_en_programmeerproject.groep5.breakout.controller.game;

import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelCenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kenny on 13/11/2014.
 */
public class StartGameController implements ActionListener {
    private PanelCenter c;

    public StartGameController(PanelCenter panelCenter){
        c = panelCenter;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Database.DatabaseInstance.insertGameMode(new Gamemode());
        c.addGamePanel();
    }
}
