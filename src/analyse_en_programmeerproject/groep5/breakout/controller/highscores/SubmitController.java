package analyse_en_programmeerproject.groep5.breakout.controller.highscores;

import analyse_en_programmeerproject.groep5.breakout.data.Database;
import analyse_en_programmeerproject.groep5.breakout.model.Score;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.CenterPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by Kenny on 5/12/2014.
 */
public class SubmitController implements ActionListener {
    private CenterPanel panelCenter;
    private int score;

    public SubmitController(int score, CenterPanel center){
        panelCenter = center;
        this.score = score;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Database.DatabaseInstance.insertScore(new Score(score, new Date(), Database.DatabaseInstance.fillGames().size()-1));
        Database.DatabaseInstance.insertScoreUsers(0, Database.DatabaseInstance.fillScores().size()-1);
        panelCenter.addMainComponents();
    }
}
