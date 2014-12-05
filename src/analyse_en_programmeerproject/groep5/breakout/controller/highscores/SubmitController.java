package analyse_en_programmeerproject.groep5.breakout.controller.highscores;

import analyse_en_programmeerproject.groep5.breakout.data.Database;
import analyse_en_programmeerproject.groep5.breakout.model.Score;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelCenter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Kenny on 5/12/2014.
 */
public class SubmitController implements ActionListener {
    private PanelCenter panelCenter;
    private int score;

    public SubmitController(int score, PanelCenter center){
        panelCenter = center;
        this.score = score;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Database.DatabaseInstance.insertScore(new Score(0,new Date(), score));
        panelCenter.addMainComponents();
    }
}
