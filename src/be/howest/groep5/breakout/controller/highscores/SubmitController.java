package be.howest.groep5.breakout.controller.highscores;

import be.howest.groep5.breakout.data.Database;
import be.howest.groep5.breakout.model.Score;
import be.howest.groep5.breakout.view.welcome.CenterPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
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
        if(Database.DatabaseInstance.getUserId() != -1) {
            Database.DatabaseInstance.insertScoreUsers(Database.DatabaseInstance.getUserId(), Database.DatabaseInstance.fillScores().size() - 1);
            Database.DatabaseInstance.updateXPUser(score, Database.DatabaseInstance.getUserId());
        }
        panelCenter.addMainComponents();
    }
}
