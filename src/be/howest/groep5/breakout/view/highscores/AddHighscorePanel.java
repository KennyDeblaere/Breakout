package be.howest.groep5.breakout.view.highscores;

import be.howest.groep5.breakout.controller.highscores.CancelController;
import be.howest.groep5.breakout.controller.highscores.SubmitController;
import be.howest.groep5.breakout.view.welcome.CenterPanel;

import javax.swing.*;

/**
 * Created by Kenny on 5/12/2014.
 */
public class AddHighscorePanel extends JPanel {
    private int score;
    private JButton submit, cancel;
    private JLabel highscore;
    private CenterPanel center;

    public AddHighscorePanel(int score, CenterPanel panelCenter){
        super();
        center = panelCenter;
        this.score = score;
        createComponents();
        addActionListeners();
        addComponents();
    }

    private void createComponents(){
        highscore = new JLabel("U behaalde de score van : " + score);
        submit = new JButton("Toevoegen");
        cancel = new JButton("Niet toevoegen");
    }

    private void addActionListeners(){
        submit.addActionListener(new SubmitController(score, center));
        cancel.addActionListener(new CancelController(center));

    }

    private void addComponents(){
        add(highscore);
        add(submit);
        add(cancel);
    }
}
