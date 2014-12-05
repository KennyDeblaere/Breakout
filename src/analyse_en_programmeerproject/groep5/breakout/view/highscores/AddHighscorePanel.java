package analyse_en_programmeerproject.groep5.breakout.view.highscores;

import analyse_en_programmeerproject.groep5.breakout.controller.highscores.CancelController;
import analyse_en_programmeerproject.groep5.breakout.controller.highscores.SubmitController;
import analyse_en_programmeerproject.groep5.breakout.view.welcome.PanelCenter;

import javax.swing.*;

/**
 * Created by Kenny on 5/12/2014.
 */
public class AddHighscorePanel extends JPanel {
    private int score;
    private JButton submit, cancel;
    private JLabel highscore;
    private PanelCenter center;

    public AddHighscorePanel(int score, PanelCenter panelCenter){
        super();
        center = panelCenter;
        this.score = score;
        createComponents();
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
