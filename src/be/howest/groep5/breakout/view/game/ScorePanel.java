package be.howest.groep5.breakout.view.game;

import be.howest.groep5.breakout.model.game.Ball;
import be.howest.groep5.breakout.model.multimedia.Multimedia;
import be.howest.groep5.breakout.model.observer.ScoreObserver;
import be.howest.groep5.breakout.view.welcome.CenterPanel;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * Created by
 *      Kenny Deblaere
 *      Dries Dekoninck
 *      Benjamin Vansteelandt
 */


public class ScorePanel extends JPanel implements ScoreObserver {
    private Ball b;
    private JPanel scorePanel, singlePanel, infoPanel, lifePanel;
    private JLabel titelLabel, scoresingle, scorecoop, pause, timer, life;
    private int seconds = 10;
    private Multimedia multimedia;
    private Image background;
    private GamePanel gamePanel;

    public ScorePanel(GamePanel gamePanel) {
        super();

        this.gamePanel = gamePanel;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(200, 710));
        setBackground(Color.white);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 3, true));
        createComponents();
        setComponents();
        addComponents();
        changeTexts(gamePanel.getB().getP1Score(),gamePanel.getB().getNumberOfLifes());
        setBackground();
    }

    private void createComponents() {
        multimedia = new Multimedia();
        scorePanel = new JPanel();
        lifePanel = new JPanel();
        infoPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        singlePanel = new JPanel();
        titelLabel = new JLabel("Scorebord");
        pause = new JLabel("<html>Druk op \" P \"<br> of \"spatie\" \n om te pauzeren</html>");
        timer = new JLabel("<html>Power up/down voor :<br>" + seconds + " \n  seconden</html>");
        life = new JLabel("3");
    }

    private JPanel playerScorePanelCreator(String spelerNaam, Boolean isCoOp) {
        JPanel toReturnPanel = new JPanel();

        toReturnPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white, 2, true), spelerNaam, TitledBorder.LEFT, TitledBorder.TOP, new Font(null, Font.BOLD, 15), Color.white));
        toReturnPanel.setPreferredSize(new Dimension(175, 65));

        if (isCoOp) {
            scorecoop = new JLabel("Score: " + gamePanel.getB().getP2Score());
            scorecoop.setForeground(Color.white);
            toReturnPanel.add(scorecoop);
        } else {
            scoresingle = new JLabel("Score: " + gamePanel.getB().getP1Score());
            scoresingle.setForeground(Color.white);
            toReturnPanel.add(scoresingle);
        }
        toReturnPanel.setOpaque(false);

        return toReturnPanel;
    }

    private void setInfoPanel(){
        infoPanel.add(pause);
        infoPanel.add(timer);
        infoPanel.setOpaque(false);
    }

    private void setLifePanel(){
        lifePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white, 2, true), "Levens", TitledBorder.LEFT, TitledBorder.TOP, new Font(null, Font.BOLD, 15), Color.white));
        lifePanel.setPreferredSize(new Dimension(175, 50));
        lifePanel.setOpaque(false);
        lifePanel.add(life);
    }


    public void setComponents() {
        Font fonts = new Font(null, Font.BOLD, 15);
        titelLabel.setFont(new Font(null, Font.BOLD, 30));
        titelLabel.setForeground(Color.white);
        pause.setForeground(Color.white);
        timer.setForeground(Color.white);
        life.setForeground(Color.white);
        singlePanel = playerScorePanelCreator("Speler 1", false);
        setInfoPanel();
        setLifePanel();
        scorePanel.add(titelLabel);
        scorePanel.add(lifePanel);
        scorePanel.add(singlePanel);

        scorePanel.add(infoPanel);
        scorePanel.setOpaque(false);
    }

    private void addComponents() {
        add(scorePanel);
    }

    public void changeTexts(int singlePlayerScore, int numberOfLives){
        scoresingle.setText("Score: " + singlePlayerScore);
        life.setText("" + numberOfLives);
        repaint();
    }


    private void setBackground() {
        background = multimedia.getScorebackground();
        repaint();
    }


    @Override
    protected void paintComponent (Graphics g){
        g.drawImage(background, 0, 0, null);
    }


    @Override
    public void update(int p1Score, int p2score, int numberOfLifesLeft) {
        changeTexts(p1Score, numberOfLifesLeft);
            if (numberOfLifesLeft == 0) {
            gamePanel.getCenterPanel().remove(this);
        }
    }
}

