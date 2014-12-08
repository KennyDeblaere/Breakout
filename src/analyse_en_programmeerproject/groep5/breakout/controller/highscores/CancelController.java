package analyse_en_programmeerproject.groep5.breakout.controller.highscores;

import analyse_en_programmeerproject.groep5.breakout.view.welcome.CenterPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Kenny on 5/12/2014.
 */
public class CancelController implements ActionListener {
    private CenterPanel panelCenter;

    public CancelController(CenterPanel panelCenter){
        this.panelCenter = panelCenter;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        panelCenter.addMainComponents();
    }
}
