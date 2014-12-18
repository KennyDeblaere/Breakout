package be.howest.groep5.breakout.view.game;

import be.howest.groep5.breakout.model.game.Ball;
import be.howest.groep5.breakout.model.multimedia.Multimedia;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by Dries Dekoninck on 16/12/2014.
 */

public class ScorePanel extends JPanel implements Observer {
    private Ball b;
    private JPanel scorePanel, singlePanel, coopPanel, infoPanel, lifePanel;
    private JLabel titelLabel, scoresingle, scorecoop, pause, timer, life;
    private int seconds = 10;
    private Boolean singleplayer = false;
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
        changeTexts(gamePanel.getB().getP1Score(),gamePanel.getB().getP2Score(),gamePanel.getB().getNumberOfLifes());
        setBackground();
    }

    private void createComponents() {
        multimedia = new Multimedia();
        scorePanel = new JPanel();
        lifePanel = new JPanel();
        infoPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        singlePanel = new JPanel();
        coopPanel = new JPanel();
        titelLabel = new JLabel("Scorebord");
        scoresingle = new JLabel("Score: " + gamePanel.getB().getP1Score());
        scorecoop = new JLabel("Score: " + gamePanel.getB().getP2Score());
        pause = new JLabel("<html>Druk op \"P\"<br> of \"spatie\" \n om te pauzeren</html>");
        timer = new JLabel("<html>Power up/down voor :<br>" + seconds + " \n  seconden</html>");
        life = new JLabel("3");
    }

    private void setSinglePanel(){
        singlePanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white, 2, true), "Speler 1", TitledBorder.LEFT, TitledBorder.TOP, new Font(null, Font.BOLD, 15), Color.white));
        singlePanel.setPreferredSize(new Dimension(175, 150));
        singlePanel.add(scoresingle);
        singlePanel.setOpaque(false);
        revalidate();
        repaint();
    }

    private void setCoopPanel(){
        coopPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white, 2, true), "Speler 2", TitledBorder.LEFT, TitledBorder.TOP, new Font(null, Font.BOLD, 15), Color.white));
        coopPanel.setPreferredSize(new Dimension(175, 150));
        coopPanel.add(scorecoop);
        coopPanel.setOpaque(false);
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
        scoresingle.setForeground(Color.white);
        scorecoop.setForeground(Color.white);
        pause.setForeground(Color.white);
        timer.setForeground(Color.white);
        life.setForeground(Color.white);
        //------------ singlePanel ----------------
        setSinglePanel();
        //------------ coopPanel ------------------
        setCoopPanel();
        //------------ infoPanel ------------------
        setInfoPanel();
        //------------ lifePanel ------------------
        setLifePanel();
        //------------ ScorePanel -----------------
        scorePanel.add(titelLabel);
        scorePanel.add(lifePanel);
        scorePanel.add(singlePanel);
        if (!gamePanel.getB().isSingleplayer()) {
            scorePanel.add(coopPanel);
        }

        scorePanel.add(infoPanel);
        scorePanel.setOpaque(false);
    }

    private void addComponents() {
        add(scorePanel);
    }

    public void changeTexts(int singlePlayerScore, int coopScore, int numberOfLives){
        //remove(scorePanel);
        scoresingle.setText("Score: " + singlePlayerScore);
        scorecoop.setText("Score: " + coopScore);
        life.setText("" + numberOfLives);
        //add(scorePanel);
        //revalidate();
        repaint();
    }


    private void setBackground() {
        background = multimedia.getMainBackground();
        repaint();
    }


    @Override
    protected void paintComponent (Graphics g){
        g.drawImage(background, 0, 0, null);
    }


    @Override
    public void update(Observable o, Object arg) {
        changeTexts(gamePanel.getB().getP1Score(),gamePanel.getB().getP2Score(), gamePanel.getB().getNumberOfLifes());
    }
}

